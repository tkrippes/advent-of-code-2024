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
        wordSearch.add(List.of('A', 'B', 'C'));
        wordSearch.add(List.of('D', 'E', 'F'));
        wordSearch.add(List.of('G', 'H', 'I'));
        wordSearch.add(List.of('J', 'K', 'L'));
        assertFalse(wordSearch.isEmpty());
    }

    @Test
    public void defaultWordSearchHasZeroWidth() {
        assertEquals(0, wordSearch.width());
    }

    @Test
    public void wordSearchCalculatesWidthCorrectly() {
        wordSearch.add(List.of('A', 'B', 'C'));
        wordSearch.add(List.of('D', 'E', 'F'));
        wordSearch.add(List.of('G', 'H', 'I'));
        wordSearch.add(List.of('J', 'K', 'L'));
        assertEquals(3, wordSearch.width());
    }

    @Test
    public void defaultWordSearchHasZeroHeight() {
        assertEquals(0, wordSearch.height());
    }

    @Test
    public void wordSearchCalculatesHeightCorrectly() {
        wordSearch.add(List.of('A', 'B', 'C'));
        wordSearch.add(List.of('D', 'E', 'F'));
        wordSearch.add(List.of('G', 'H', 'I'));
        wordSearch.add(List.of('J', 'K', 'L'));
        assertEquals(4, wordSearch.height());
    }

    @Test
    public void wordSearchAddsCharacterLineCorrectly() {
        wordSearch.add(List.of('A', 'B', 'C'));
        assertEquals(List.of(List.of('A', 'B', 'C')), wordSearch.wordSearch);
    }

    @Test
    public void wordSearchAddsCharacterLinesOfSameHeightCorrectly() {
        wordSearch.add(List.of('A', 'B', 'C'));
        wordSearch.add(List.of('D', 'E', 'F'));
        wordSearch.add(List.of('G', 'H', 'I'));
        wordSearch.add(List.of('J', 'K', 'L'));
        assertEquals(List.of(List.of('A', 'B', 'C'), List.of('D', 'E', 'F'),
                List.of('G', 'H', 'I'), List.of('J', 'K', 'L')), wordSearch.wordSearch);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wordSearchThrowsWhenAddingCharacterLinesOfDifferentLengths() {
        wordSearch.add(List.of('A', 'B', 'C'));
        wordSearch.add(List.of('D', 'E', 'F', 'G'));
    }

    @Test
    public void wordSearchGetCharacterShouldReturnRightCharactersCorrectly() {
        wordSearch.add(List.of('A', 'B', 'C'));
        wordSearch.add(List.of('D', 'E', 'F'));
        wordSearch.add(List.of('G', 'H', 'I'));
        wordSearch.add(List.of('J', 'K', 'L'));
        assertEquals('A', wordSearch.getCharacter(0, 0));
        assertEquals('F', wordSearch.getCharacter(2, 1));
        assertEquals('J', wordSearch.getCharacter(0, 3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenAccessingCharacterOfEmptyWordSearch() {
        assertEquals('A', wordSearch.getCharacter(0, 0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenColumnIsNegative() {
        wordSearch.add(List.of('A', 'B', 'C'));
        wordSearch.add(List.of('D', 'E', 'F'));
        wordSearch.add(List.of('G', 'H', 'I'));
        wordSearch.add(List.of('J', 'K', 'L'));
        assertEquals('A', wordSearch.getCharacter(-2, 0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenRowIsNegative() {
        wordSearch.add(List.of('A', 'B', 'C'));
        wordSearch.add(List.of('D', 'E', 'F'));
        wordSearch.add(List.of('G', 'H', 'I'));
        wordSearch.add(List.of('J', 'K', 'L'));
        assertEquals('A', wordSearch.getCharacter(0, -3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenColumnIsTooLarge() {
        wordSearch.add(List.of('A', 'B', 'C'));
        wordSearch.add(List.of('D', 'E', 'F'));
        wordSearch.add(List.of('G', 'H', 'I'));
        wordSearch.add(List.of('J', 'K', 'L'));
        assertEquals('A', wordSearch.getCharacter(3, 0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordSearchThrowsWhenRowIsToLarge() {
        wordSearch.add(List.of('A', 'B', 'C'));
        wordSearch.add(List.of('D', 'E', 'F'));
        wordSearch.add(List.of('G', 'H', 'I'));
        wordSearch.add(List.of('J', 'K', 'L'));
        assertEquals('A', wordSearch.getCharacter(0, 4));
    }

    @After
    public void tearDown() {

    }
}
