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
    public void defaultWordSearchHasZeroWidth() {
        assertEquals(0, wordSearch.width());
    }

    @Test
    public void wordSearchCalculatesWidthCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        assertEquals(3, wordSearch.width());
    }

    @Test
    public void defaultWordSearchHasZeroHeight() {
        assertEquals(0, wordSearch.height());
    }

    @Test
    public void wordSearchCalculatesHeightCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        assertEquals(4, wordSearch.height());
    }

    @Test
    public void wordSearchAddsCharacterLineCorrectly() {
        wordSearch.add("ABC");
        assertEquals(List.of("ABC"), wordSearch.wordSearch);
    }

    @Test
    public void wordSearchAddsCharacterLinesOfSameHeightCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.add("JKL");
        assertEquals(List.of("ABC", "DEF",
                "GHI", "JKL"), wordSearch.wordSearch);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wordSearchThrowsWhenAddingCharacterLinesOfDifferentLengths() {
        wordSearch.add("ABC");
        wordSearch.add("DEFG");
    }

    @Test
    public void wordSearchGetLineShouldReturnLineCorrectly() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        assertEquals("ABC", wordSearch.getLine(0));
        assertEquals("DEF", wordSearch.getLine(1));
        assertEquals("GHI", wordSearch.getLine(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenAccessingLineOfEmptyWordSearch() {
        wordSearch.getLine(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenAccessingLineAtNegativeIndex() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.getLine(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenAccessingLineAtInexistentIndex() {
        wordSearch.add("ABC");
        wordSearch.add("DEF");
        wordSearch.add("GHI");
        wordSearch.getLine(3);
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
