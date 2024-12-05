package tkrippes.com.github.adventofcode2024.day04.parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class WordSearchParserTest {
    private WordSearchParser parser;

    @Before
    public void setUp() {
        parser = new WordSearchParser();
    }

    @Test(expected = FileNotFoundException.class)
    public void parseThrowsForInvalidInputFileName() throws IOException {
        String invalidInputFileName = "../../input/invalid_test_input.txt";
        parser.parse(invalidInputFileName);
    }

    @Test
    public void parseEmptyWordSearchShouldReturnEmptyResult() {
        List<List<Character>> parsedWordSearch = parser.parseWordSearch("");
        assertTrue(parsedWordSearch.isEmpty());
    }

    @Test
    public void parseOneLineWordSearchCorrectly() {
        List<List<Character>> parsedWordSearch = parser.parseWordSearch("FASDFKFASD");
        assertEquals(List.of(List.of('F', 'A', 'S', 'D', 'F', 'K', 'F', 'A', 'S', 'D')), parsedWordSearch);
    }

    @Test
    public void parseTwoLineSameLengthWordSearchCorrectly() {
        List<List<Character>> parsedWordSearch = parser.parseWordSearch("FASDFKFASD\nFGDLJDSFMX");
        assertEquals(List.of(
                        List.of('F', 'A', 'S', 'D', 'F', 'K', 'F', 'A', 'S', 'D'),
                        List.of('F', 'G', 'D', 'L', 'J', 'D', 'S', 'F', 'M', 'X')),
                parsedWordSearch);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseThrowsForTwoLinesSameDifferentWordSearch() {
        parser.parseWordSearch("FASDFKFASD\nFGDLJSMX");
    }

    @Test
    public void parseThreeLineSameLengthWordSearchCorrectly() {
        List<List<Character>> parsedWordSearch = parser.parseWordSearch("FASDFKFASD\nFGDLJDSFMX\nAFSKLFASDJ");
        assertEquals(List.of(
                        List.of('F', 'A', 'S', 'D', 'F', 'K', 'F', 'A', 'S', 'D'),
                        List.of('F', 'G', 'D', 'L', 'J', 'D', 'S', 'F', 'M', 'X'),
                        List.of('A', 'F', 'S', 'K', 'L', 'F', 'A', 'S', 'D', 'J')),
                parsedWordSearch);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseThrowsForThreeLinesSameDifferentWordSearch() {
        parser.parseWordSearch("FASDFKFASD\nFGDLJDSFMX\nASFD");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseThrowsForWordSearchWithEmptyLine() {
        parser.parseWordSearch("FASDFKFASD\n\nFGDLJDSFMX;");
    }

    @Test
    public void parseWordSearchTestInputFileCorrectly() throws IOException {
        String validInputFileName = "../../input/test_input.txt";
        List<List<Character>> parsedWordSearch = parser.parse(validInputFileName);
        assertEquals(List.of(
                        List.of('M', 'M', 'M', 'S', 'X', 'X', 'M', 'A', 'S', 'M'),
                        List.of('M', 'S', 'A', 'M', 'X', 'M', 'S', 'M', 'S', 'A'),
                        List.of('A', 'M', 'X', 'S', 'X', 'M', 'A', 'A', 'M', 'M'),
                        List.of('M', 'S', 'A', 'M', 'A', 'S', 'M', 'S', 'M', 'X'),
                        List.of('X', 'M', 'A', 'S', 'A', 'M', 'X', 'A', 'M', 'M'),
                        List.of('X', 'X', 'A', 'M', 'M', 'X', 'X', 'A', 'M', 'A'),
                        List.of('S', 'M', 'S', 'M', 'S', 'A', 'S', 'X', 'S', 'S'),
                        List.of('S', 'A', 'X', 'A', 'M', 'A', 'S', 'A', 'A', 'A'),
                        List.of('M', 'A', 'M', 'M', 'M', 'X', 'M', 'M', 'M', 'M'),
                        List.of('M', 'X', 'M', 'X', 'A', 'X', 'M', 'A', 'S', 'X')),
                parsedWordSearch);
    }

    @After
    public void tearDown() {
    }
}
