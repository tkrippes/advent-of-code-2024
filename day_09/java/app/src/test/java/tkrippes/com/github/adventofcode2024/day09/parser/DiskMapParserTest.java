package tkrippes.com.github.adventofcode2024.day09.parser;

import tkrippes.com.github.adventofcode2024.day09.DiskMap;
import tkrippes.com.github.adventofcode2024.day09.disk.File;
import tkrippes.com.github.adventofcode2024.day09.disk.FreeSpace;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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

        DiskMap expectedMap = new DiskMap(List.of(
                new File(2, 0), new FreeSpace(3), new File(3, 1), new FreeSpace(3),
                new File(1, 2), new FreeSpace(3), new File(3, 3), new FreeSpace(1),
                new File(2, 4), new FreeSpace(1), new File(4, 5), new FreeSpace(1),
                new File(4, 6), new FreeSpace(1), new File(3, 7), new FreeSpace(1),
                new File(4, 8), new File(2, 9)));

        assertEquals(expectedMap, DiskMapParser.parse(validInputFileName));
    }

    @AfterEach
    public void tearDown() {
    }
}
