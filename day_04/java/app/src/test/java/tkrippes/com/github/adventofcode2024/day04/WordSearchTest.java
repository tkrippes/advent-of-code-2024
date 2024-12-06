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
    public void defaultWordSearchHasZeroColumns() {
        assertEquals(0, wordSearch.columns());
    }

    @Test
    public void wordSearchCalculatesColumnsCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        assertEquals(3, wordSearch.columns());
    }

    @Test
    public void defaultWordSearchHasZeroRows() {
        assertEquals(0, wordSearch.rows());
    }

    @Test
    public void wordSearchCalculatesRowsCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        assertEquals(4, wordSearch.rows());
    }

    @Test
    public void defaultWordSearchHasZeroDiagonals() {
        assertEquals(0, wordSearch.diagonals());
    }

    @Test
    public void wordSearchCalculatesDiagonalsOfSquareCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        assertEquals(5, wordSearch.diagonals());
    }

    @Test
    public void wordSearchCalculatesDiagonalsOfNonSquareCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        assertEquals(6, wordSearch.diagonals());
    }

    @Test
    public void wordSearchAddsCharactersCorrectly() {
        wordSearch.add("ABC");
        assertEquals(List.of("ABC"), wordSearch.wordSearch);
    }

    @Test
    public void wordSearchAddsCharacterRowsOfSameHeightCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        assertEquals(List.of("ABC", "DEF", "GHI", "JKL"), wordSearch.wordSearch);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wordSearchThrowsWhenAddingCharacterRowsOfDifferentLengths() {
        wordSearch.add("ABC");
        wordSearch.add("DEFG");
    }

    @Test
    public void wordSearchGetRowShouldReturnRowsCorrectly() {
        wordSearch.add("ABCD");
        wordSearch.add("EFGH");
        wordSearch.add("IJKL");
        assertEquals("ABCD", wordSearch.getRow(0));
        assertEquals("EFGH", wordSearch.getRow(1));
        assertEquals("IJKL", wordSearch.getRow(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenAccessingRowOfEmptyWordSearch() {
        wordSearch.getRow(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenAccessingRowAtNegativeIndex() {
        wordSearch.add("ABCD");
        wordSearch.add("EFGH");
        wordSearch.add("IJKL");
        wordSearch.getRow(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenAccessingRowAtInexistentIndex() {
        wordSearch.add("ABCD");
        wordSearch.add("EFGH");
        wordSearch.add("IJKL");
        wordSearch.getRow(3);
    }

    @Test
    public void wordSearchGetColumnShouldReturnColumnsCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        assertEquals("ADGJ", wordSearch.getColumn(0));
        assertEquals("BEHK", wordSearch.getColumn(1));
        assertEquals("CFIL", wordSearch.getColumn(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenAccessingColumnOfEmptyWordSearch() {
        wordSearch.getColumn(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenAccessingColumnAtNegativeIndex() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        wordSearch.getColumn(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenAccessingColumnAtInexistentIndex() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        wordSearch.getColumn(3);
    }

    @Test
    public void wordSearchGetCharacterShouldReturnCharactersCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        assertEquals('A', wordSearch.getCharacter(0, 0));
        assertEquals('F', wordSearch.getCharacter(2, 1));
        assertEquals('J', wordSearch.getCharacter(0, 3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenAccessingCharacterOfEmptyWordSearch() {
        wordSearch.getCharacter(0, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenColumnIsNegative() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        wordSearch.getCharacter(-2, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenRowIsNegative() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        wordSearch.getCharacter(0, -3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenColumnIsTooLarge() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        wordSearch.getCharacter(3, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenRowIsToLarge() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        wordSearch.getCharacter(0, 4);
    }

    @After
    public void tearDown() {

    }
}
