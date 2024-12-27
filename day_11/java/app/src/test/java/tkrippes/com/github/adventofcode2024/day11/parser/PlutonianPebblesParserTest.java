package tkrippes.com.github.adventofcode2024.day11.parser;

import tkrippes.com.github.adventofcode2024.day11.PlutonianPebble;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlutonianPebblesParserTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void parseThrowsForInvalidInputFileName() {
        assertThrows(FileNotFoundException.class, () -> PlutonianPebblesParser.parse("../../input/invalid_test_input" +
                ".txt"));
    }

    @Test
    public void parseShouldParseInputFile1Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_1.txt";

        assertEquals(List.of(new PlutonianPebble(0), new PlutonianPebble(1), new PlutonianPebble(10),
                        new PlutonianPebble(99), new PlutonianPebble(999)),
                PlutonianPebblesParser.parse(validInputFileName));
    }

    @Test
    public void parseShouldParseInputFile2Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_2.txt";

        assertEquals(List.of(new PlutonianPebble(125), new PlutonianPebble(17)),
                PlutonianPebblesParser.parse(validInputFileName));
    }

    @AfterEach
    public void tearDown() {
    }
}
