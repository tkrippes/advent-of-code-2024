package tkrippes.com.github.adventofcode2024.day04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WordSearchTest {
    private WordSearch wordSearch;

    @Before
    public void setUp() {
        wordSearch = new WordSearch();
    }

    @Test(expected = IllegalArgumentException.class)
    public void wordSearchThrowsWhenAddingCharacterRowsOfDifferentLengths() {
        wordSearch.add("ABC");
        wordSearch.add("DEFG");
    }

    @Test
    public void defaultWordSearchReturnsEmptyRows() {
        assertTrue(wordSearch.getRows().isEmpty());
    }

    @Test
    public void wordSearchGetRowShouldReturnRowsCorrectly() {
        wordSearch.add("ABCD");
        wordSearch.add("EFGH");
        wordSearch.add("IJKL");
        assertEquals(List.of("ABCD", "EFGH", "IJKL"), wordSearch.getRows());
    }

    @Test
    public void defaultWordSearchReturnsEmptyColumns() {
        assertTrue(wordSearch.getColumns().isEmpty());
    }

    @Test
    public void wordSearchGetColumnShouldReturnColumnsCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        assertEquals(List.of("ADGJ", "BEHK", "CFIL"), wordSearch.getColumns());
    }

    @Test
    public void defaultWordSearchReturnsEmptyPrimaryDiagonals() {
        assertTrue(wordSearch.getPrimaryDiagonals().isEmpty());
    }

    @Test
    public void singleCharacterWordSearchShouldReturnPrimaryDiagonalsCorrectly() {
        wordSearch.add("A");
        assertEquals(List.of("A"), wordSearch.getPrimaryDiagonals());
    }

    @Test
    public void twoCharactersHorizontalWordSearchShouldReturnPrimaryDiagonalsCorrectly() {
        wordSearch.add("AB");
        assertEquals(List.of("B", "A"), wordSearch.getPrimaryDiagonals());
    }

    @Test
    public void twoCharactersVerticalWordSearchShouldReturnPrimaryDiagonalsCorrectly() {
        wordSearch.add("A");
        wordSearch.add("B");
        assertEquals(List.of("A", "B"), wordSearch.getPrimaryDiagonals());
    }

    @Test
    public void twoByTwoWordSearchShouldReturnPrimaryDiagonalsCorrectly() {
        wordSearch.add("AB");
        wordSearch.add("CD");
        assertEquals(List.of("B", "AD", "C"), wordSearch.getPrimaryDiagonals());
    }

    @Test
    public void twoByThreeWordSearchShouldReturnPrimaryDiagonalsCorrectly() {
        wordSearch.add("AB");
        wordSearch.add("CD");
        wordSearch.add("EF");
        assertEquals(List.of("B", "AD", "CF", "E"), wordSearch.getPrimaryDiagonals());
    }

    @Test
    public void threeByTwoWordSearchShouldReturnPrimaryDiagonalsCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        assertEquals(List.of("C", "BF", "AE", "D"), wordSearch.getPrimaryDiagonals());
    }

    @Test
    public void threeByThreeWordSearchShouldReturnPrimaryDiagonalsCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        assertEquals(List.of("C", "BF", "AEI", "DH", "G"), wordSearch.getPrimaryDiagonals());
    }

    @Test
    public void defaultWordSearchReturnsEmptySecondaryDiagonals() {
        assertTrue(wordSearch.getSecondaryDiagonals().isEmpty());
    }

    @Test
    public void singleCharacterWordSearchShouldReturnSecondaryDiagonalsCorrectly() {
        wordSearch.add("A");
        assertEquals(List.of("A"), wordSearch.getSecondaryDiagonals());
    }

    @Test
    public void twoCharactersHorizontalWordSearchShouldReturnSecondaryDiagonalsCorrectly() {
        wordSearch.add("AB");
        assertEquals(List.of("A", "B"), wordSearch.getSecondaryDiagonals());
    }

    @Test
    public void twoCharactersVerticalWordSearchShouldReturnSecondaryDiagonalsCorrectly() {
        wordSearch.add("A");
        wordSearch.add("B");
        assertEquals(List.of("A", "B"), wordSearch.getSecondaryDiagonals());
    }

    @Test
    public void twoByTwoWordSearchShouldReturnSecondaryDiagonalsCorrectly() {
        wordSearch.add("AB");
        wordSearch.add("CD");
        assertEquals(List.of("A", "BC", "D"), wordSearch.getSecondaryDiagonals());
    }

    @Test
    public void twoByThreeWordSearchShouldReturnSecondaryDiagonalsCorrectly() {
        wordSearch.add("AB");
        wordSearch.add("CD");
        wordSearch.add("EF");
        assertEquals(List.of("A", "BC", "DE", "F"), wordSearch.getSecondaryDiagonals());
    }

    @Test
    public void threeByTwoWordSearchShouldReturnSecondaryDiagonalsCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        assertEquals(List.of("A", "BD", "CE", "F"), wordSearch.getSecondaryDiagonals());
    }

    @Test
    public void threeByThreeWordSearchShouldReturnSecondaryDiagonalsCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        assertEquals(List.of("A", "BD", "CEG", "FH", "I"), wordSearch.getSecondaryDiagonals());
    }

    @Test
    public void defaultWordSearchReturnsEmptyWindowsWithSizesDifferentFromZero() {
        assertTrue(wordSearch.getWordSearchWindows(2, 2).isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void defaultWordSearchGetEmptyWindowsThrowsWithSizesEqualToZero() {
        assertTrue(wordSearch.getWordSearchWindows(0, 0).isEmpty());
    }

    @Test
    public void wordSearchGetWordSearchWindowsShouldReturnSameWordSearchForOnlyOneCharcterAndSizesEqualToOne() {
        wordSearch.add("A");
        assertEquals(List.of(wordSearch), wordSearch.getWordSearchWindows(1, 1));
    }

    @Test
    public void wordSearchGetWordSearchWindowsShouldReturnEmptyListForOnlyOneCharcterAndSizesGreaterThanOne() {
        wordSearch.add("A");
        assertEquals(List.of(), wordSearch.getWordSearchWindows(2, 2));
    }

    @Test
    public void wordSearchGetWordSearchWindowsShouldReturnAllCharactersIndividuallyForSizesEqualToOne() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");

        List<WordSearch> expectedWordSearches = new ArrayList<>();
        for (int i = 0; i < wordSearch.rowCount() * wordSearch.columnCount(); i++) {
            WordSearch expectedWordSearch = new WordSearch();
            char expectedCharacter = (char) ('A' + i);
            expectedWordSearch.add(String.valueOf(expectedCharacter));
            expectedWordSearches.add(expectedWordSearch);
        }

        assertEquals(expectedWordSearches, wordSearch.getWordSearchWindows(1, 1));
    }

    @Test
    public void wordSearchGetWordSearchWindowsShouldCalculateCorrectlyForSquaredWordSearchesAndSquaredWindows() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");

        List<WordSearch> expectedWordSearches = new ArrayList<>();
        WordSearch expectedWordSearch = new WordSearch();
        expectedWordSearch.add("AB");
        expectedWordSearch.add("DE");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("BC");
        expectedWordSearch.add("EF");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("DE");
        expectedWordSearch.add("GH");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("EF");
        expectedWordSearch.add("HI");
        expectedWordSearches.add(expectedWordSearch);

        assertEquals(expectedWordSearches, wordSearch.getWordSearchWindows(2, 2));
    }

    @Test
    public void wordSearchGetWordSearchWindowsShouldCalculateCorrectlyForSquaredWordSearchesAndNonSquaredWindows() {
        wordSearch.add("ABCD");
        wordSearch.add("EFGH");
        wordSearch.add("IJKL");
        wordSearch.add("MNOP");

        List<WordSearch> expectedWordSearches = new ArrayList<>();

        WordSearch expectedWordSearch = new WordSearch();
        expectedWordSearch.add("AB");
        expectedWordSearch.add("EF");
        expectedWordSearch.add("IJ");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("BC");
        expectedWordSearch.add("FG");
        expectedWordSearch.add("JK");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("CD");
        expectedWordSearch.add("GH");
        expectedWordSearch.add("KL");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("EF");
        expectedWordSearch.add("IJ");
        expectedWordSearch.add("MN");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("FG");
        expectedWordSearch.add("JK");
        expectedWordSearch.add("NO");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("GH");
        expectedWordSearch.add("KL");
        expectedWordSearch.add("OP");
        expectedWordSearches.add(expectedWordSearch);

        assertEquals(expectedWordSearches, wordSearch.getWordSearchWindows(3, 2));
    }

    @Test
    public void wordSearchGetWordSearchWindowsShouldCalculateCorrectlyForNonSquaredWordSearchesAndSquaredWindows() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");

        List<WordSearch> expectedWordSearches = new ArrayList<>();

        WordSearch expectedWordSearch = new WordSearch();
        expectedWordSearch.add("AB");
        expectedWordSearch.add("DE");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("BC");
        expectedWordSearch.add("EF");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("DE");
        expectedWordSearch.add("GH");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("EF");
        expectedWordSearch.add("HI");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("GH");
        expectedWordSearch.add("JK");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("HI");
        expectedWordSearch.add("KL");
        expectedWordSearches.add(expectedWordSearch);

        assertEquals(expectedWordSearches, wordSearch.getWordSearchWindows(2, 2));
    }

    @Test
    public void wordSearchGetWordSearchWindowsShouldCalculateCorrectlyForNonSquaredWordSearchesAndNonSquaredWindows() {
        wordSearch.add("ABCD");
        wordSearch.add("EFGH");
        wordSearch.add("IJKL");

        List<WordSearch> expectedWordSearches = new ArrayList<>();

        WordSearch expectedWordSearch = new WordSearch();
        expectedWordSearch.add("ABC");
        expectedWordSearch.add("EFG");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("BCD");
        expectedWordSearch.add("FGH");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("EFG");
        expectedWordSearch.add("IJK");
        expectedWordSearches.add(expectedWordSearch);

        expectedWordSearch = new WordSearch();
        expectedWordSearch.add("FGH");
        expectedWordSearch.add("JKL");
        expectedWordSearches.add(expectedWordSearch);

        assertEquals(expectedWordSearches, wordSearch.getWordSearchWindows(2, 3));
    }

    @Test
    public void defaultWordSearchIsEmpty() {
        assertTrue(wordSearch.isEmpty());
    }

    @Test
    public void wordSearchIndicatesIsEmptyCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        assertFalse(wordSearch.isEmpty());
    }

    @Test
    public void defaultWordSearchHasZeroRows() {
        assertEquals(0, wordSearch.rowCount());
    }

    @Test
    public void wordSearchCalculatesRowsCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        assertEquals(4, wordSearch.rowCount());
    }

    @Test
    public void defaultWordSearchHasZeroColumns() {
        assertEquals(0, wordSearch.columnCount());
    }

    @Test
    public void wordSearchCalculatesColumnsCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        assertEquals(3, wordSearch.columnCount());
    }

    @Test
    public void defaultWordSearchHasZeroDiagonals() {
        assertEquals(0, wordSearch.diagonalCount());
    }

    @Test
    public void wordSearchCalculatesDiagonalsOfSquareCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        assertEquals(5, wordSearch.diagonalCount());
    }

    @Test
    public void wordSearchCalculatesDiagonalsOfNonSquareCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        assertEquals(6, wordSearch.diagonalCount());
    }

    @After
    public void tearDown() {

    }
}
