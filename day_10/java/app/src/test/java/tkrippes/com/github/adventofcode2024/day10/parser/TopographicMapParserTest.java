package tkrippes.com.github.adventofcode2024.day10.parser;

import tkrippes.com.github.adventofcode2024.day10.TopographicMapTestInputHelper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TopographicMapParserTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void parseThrowsForInvalidInputFileName() {
        assertThrows(FileNotFoundException.class, () -> TopographicMapParser.parse("../../input/invalid_test_input" +
                ".txt"));
    }

    @Test
    public void parseShouldParseInputFile1Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_1.txt";

        assertEquals(TopographicMapTestInputHelper.getTestInput1TopographicMap(),
                TopographicMapParser.parse(validInputFileName));
    }

    @Test
    public void parseShouldParseInputFile2Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_2.txt";

        assertEquals(TopographicMapTestInputHelper.getTestInput2TopographicMap(),
                TopographicMapParser.parse(validInputFileName));
    }

    @Test
    public void parseShouldParseInputFile3Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_3.txt";

        assertEquals(TopographicMapTestInputHelper.getTestInput3TopographicMap(),
                TopographicMapParser.parse(validInputFileName));
    }

    @Test
    public void parseShouldParseInputFile4Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_4.txt";

        assertEquals(TopographicMapTestInputHelper.getTestInput4TopographicMap(),
                TopographicMapParser.parse(validInputFileName));
    }

    @Test
    public void parseShouldParseInputFile5Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_5.txt";

        assertEquals(TopographicMapTestInputHelper.getTestInput5TopographicMap(),
                TopographicMapParser.parse(validInputFileName));
    }

    @Test
    public void parseShouldParseInputFile6Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_6.txt";

        assertEquals(TopographicMapTestInputHelper.getTestInput6TopographicMap(),
                TopographicMapParser.parse(validInputFileName));
    }

    @Test
    public void parseShouldParseInputFile7Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_7.txt";

        assertEquals(TopographicMapTestInputHelper.getTestInput7TopographicMap(),
                TopographicMapParser.parse(validInputFileName));
    }

    @AfterEach
    public void tearDown() {
    }
}
