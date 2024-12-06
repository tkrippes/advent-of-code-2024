package tkrippes.com.github.adventofcode2024.day04.parser;

import tkrippes.com.github.adventofcode2024.day04.WordSearch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

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
        WordSearch parsedWordSearch = parser.parseWordSearch("");
        assertTrue(parsedWordSearch.isEmpty());
    }

    @Test
    public void parseOneLineWordSearchCorrectly() {
        WordSearch parsedWordSearch = parser.parseWordSearch("FASDFKFASD");
        WordSearch expectedWordSearch = new WordSearch();
        expectedWordSearch.add("FASDFKFASD");
        assertEquals(expectedWordSearch, parsedWordSearch);
    }

    @Test
    public void parseTwoLineSameLengthWordSearchCorrectly() {
        WordSearch parsedWordSearch = parser.parseWordSearch("FASDFKFASD\nFGDLJDSFMX");
        WordSearch expectedWordSearch = new WordSearch();
        expectedWordSearch.add("FASDFKFASD");
        expectedWordSearch.add("FGDLJDSFMX");
        assertEquals(expectedWordSearch, parsedWordSearch);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseThrowsForTwoLinesSameDifferentWordSearch() {
        parser.parseWordSearch("FASDFKFASD\nFGDLJSMX");
    }

    @Test
    public void parseThreeLineSameLengthWordSearchCorrectly() {
        WordSearch parsedWordSearch = parser.parseWordSearch("FASDFKFASD\nFGDLJDSFMX\nAFSKLFASDJ");
        WordSearch expectedWordSearch = new WordSearch();
        expectedWordSearch.add("FASDFKFASD");
        expectedWordSearch.add("FGDLJDSFMX");
        expectedWordSearch.add("AFSKLFASDJ");
        assertEquals(expectedWordSearch, parsedWordSearch);
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
        WordSearch parsedWordSearch = parser.parse(validInputFileName);

        WordSearch expectedWordSearch = new WordSearch();
        expectedWordSearch.add("MMMSXXMASM");
        expectedWordSearch.add("MSAMXMSMSA");
        expectedWordSearch.add("AMXSXMAAMM");
        expectedWordSearch.add("MSAMASMSMX");
        expectedWordSearch.add("XMASAMXAMM");
        expectedWordSearch.add("XXAMMXXAMA");
        expectedWordSearch.add("SMSMSASXSS");
        expectedWordSearch.add("SAXAMASAAA");
        expectedWordSearch.add("MAMMMXMMMM");
        expectedWordSearch.add("MXMXAXMASX");

        assertEquals(expectedWordSearch, parsedWordSearch);
    }

    @After
    public void tearDown() {
    }
}
