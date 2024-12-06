package tkrippes.com.github.adventofcode2024.day04.parser;

import tkrippes.com.github.adventofcode2024.day04.WordSearch;

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
        WordSearch parsedWordSearch = parser.parseWordSearch("");
        assertTrue(parsedWordSearch.isEmpty());
    }

    @Test
    public void parseOneLineWordSearchCorrectly() {
        WordSearch parsedWordSearch = parser.parseWordSearch("FASDFKFASD");
        WordSearch expectedWordSearch = new WordSearch();
        expectedWordSearch.add(List.of('F', 'A', 'S', 'D', 'F', 'K', 'F', 'A', 'S', 'D'));
        assertEquals(expectedWordSearch, parsedWordSearch);
    }

    @Test
    public void parseTwoLineSameLengthWordSearchCorrectly() {
        WordSearch parsedWordSearch = parser.parseWordSearch("FASDFKFASD\nFGDLJDSFMX");
        WordSearch expectedWordSearch = new WordSearch();
        expectedWordSearch.add(List.of('F', 'A', 'S', 'D', 'F', 'K', 'F', 'A', 'S', 'D'));
        expectedWordSearch.add(List.of('F', 'G', 'D', 'L', 'J', 'D', 'S', 'F', 'M', 'X'));
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
        expectedWordSearch.add(List.of('F', 'A', 'S', 'D', 'F', 'K', 'F', 'A', 'S', 'D'));
        expectedWordSearch.add(List.of('F', 'G', 'D', 'L', 'J', 'D', 'S', 'F', 'M', 'X'));
        expectedWordSearch.add(List.of('A', 'F', 'S', 'K', 'L', 'F', 'A', 'S', 'D', 'J'));
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
        expectedWordSearch.add(List.of('M', 'M', 'M', 'S', 'X', 'X', 'M', 'A', 'S', 'M'));
        expectedWordSearch.add(List.of('M', 'S', 'A', 'M', 'X', 'M', 'S', 'M', 'S', 'A'));
        expectedWordSearch.add(List.of('A', 'M', 'X', 'S', 'X', 'M', 'A', 'A', 'M', 'M'));
        expectedWordSearch.add(List.of('M', 'S', 'A', 'M', 'A', 'S', 'M', 'S', 'M', 'X'));
        expectedWordSearch.add(List.of('X', 'M', 'A', 'S', 'A', 'M', 'X', 'A', 'M', 'M'));
        expectedWordSearch.add(List.of('X', 'X', 'A', 'M', 'M', 'X', 'X', 'A', 'M', 'A'));
        expectedWordSearch.add(List.of('S', 'M', 'S', 'M', 'S', 'A', 'S', 'X', 'S', 'S'));
        expectedWordSearch.add(List.of('S', 'A', 'X', 'A', 'M', 'A', 'S', 'A', 'A', 'A'));
        expectedWordSearch.add(List.of('M', 'A', 'M', 'M', 'M', 'X', 'M', 'M', 'M', 'M'));
        expectedWordSearch.add(List.of('M', 'X', 'M', 'X', 'A', 'X', 'M', 'A', 'S', 'X'));

        assertEquals(expectedWordSearch, parsedWordSearch);
    }

    @After
    public void tearDown() {
    }
}
