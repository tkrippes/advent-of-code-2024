package tkrippes.com.github.adventofcode2024.day12.parser;

import tkrippes.com.github.adventofcode2024.day12.GardenPlotsTestInputHelper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class GardenPlotsParserTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void parseThrowsForInvalidInputFileName() {
        assertThrows(FileNotFoundException.class, () -> GardenPlotsParser.parse("../../input/invalid_test_input.txt"));
    }

    @Test
    public void parseShouldParseInputFile1Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_1.txt";

        assertEquals(GardenPlotsTestInputHelper.getTestInput1GardenPlots(),
                GardenPlotsParser.parse(validInputFileName));
    }

    @Test
    public void parseShouldParseInputFile2Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_2.txt";

        assertEquals(GardenPlotsTestInputHelper.getTestInput2GardenPlots(),
                GardenPlotsParser.parse(validInputFileName));
    }

    @Test
    public void parseShouldParseInputFile3Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_3.txt";

        assertEquals(GardenPlotsTestInputHelper.getTestInput3GardenPlots(),
                GardenPlotsParser.parse(validInputFileName));
    }

    @AfterEach
    public void tearDown() {
    }
}
