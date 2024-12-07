package tkrippes.com.github.adventofcode2024.day04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
