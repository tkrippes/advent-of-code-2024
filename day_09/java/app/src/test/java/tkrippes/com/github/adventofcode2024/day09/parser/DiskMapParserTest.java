package tkrippes.com.github.adventofcode2024.day09.parser;

import tkrippes.com.github.adventofcode2024.day09.DiskMap;
import tkrippes.com.github.adventofcode2024.day09.disk.File;
import tkrippes.com.github.adventofcode2024.day09.disk.FileFreeSpaceBlock;
import tkrippes.com.github.adventofcode2024.day09.disk.FreeSpace;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class DiskMapParserTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void parseThrowsForInvalidInputFileName() {
        assertThrows(FileNotFoundException.class, () -> DiskMapParser.parse("../../input/invalid_test_input.txt"));
    }

    @Test
    public void parseShouldParseInputFileCorrectly() throws IOException {
        String validInputFileName = "../../input/test_input.txt";

        DiskMap expectedDiskMap = new DiskMap(List.of(
                new FileFreeSpaceBlock(new File(2, 0), Optional.of(new FreeSpace(3))),
                new FileFreeSpaceBlock(new File(3, 1), Optional.of(new FreeSpace(3))),
                new FileFreeSpaceBlock(new File(1, 2), Optional.of(new FreeSpace(3))),
                new FileFreeSpaceBlock(new File(3, 3), Optional.of(new FreeSpace(1))),
                new FileFreeSpaceBlock(new File(2, 4), Optional.of(new FreeSpace(1))),
                new FileFreeSpaceBlock(new File(4, 5), Optional.of(new FreeSpace(1))),
                new FileFreeSpaceBlock(new File(4, 6), Optional.of(new FreeSpace(1))),
                new FileFreeSpaceBlock(new File(3, 7), Optional.of(new FreeSpace(1))),
                new FileFreeSpaceBlock(new File(4, 8), Optional.of(new FreeSpace(0))),
                new FileFreeSpaceBlock(new File(2, 9), Optional.empty())));

        assertEquals(expectedDiskMap, DiskMapParser.parse(validInputFileName));
    }

    @AfterEach
    public void tearDown() {
    }
}
