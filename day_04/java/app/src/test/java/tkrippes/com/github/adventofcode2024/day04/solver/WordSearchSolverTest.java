package tkrippes.com.github.adventofcode2024.day04.solver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tkrippes.com.github.adventofcode2024.day04.WordSearch;

import static org.junit.Assert.*;

public class WordSearchSolverTest {
    private WordSearchSolver solver;
    private WordSearch wordSearch;

    @Before
    public void setUp() {
        solver = new WordSearchSolver();
        wordSearch = new WordSearch();
    }

    @Test(expected = IllegalArgumentException.class)
    public void solveThrowsOnEmptyWord() {
        solver.solve(wordSearch, "");
    }

    @Test
    public void solveShouldReturnZeroOnEmptyWordSearch() {
        assertEquals(0, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnZeroWhenWordDoesNotExistInWordSearch() {
        wordSearch.add("Hello");
        assertEquals(0, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnOneWhenWordSearchAndWordMatch() {
        wordSearch.add("Test");
        assertEquals(1, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnThreeWhenWordSearchAndWordMatchForThreeLines() {
        wordSearch.add("Test");
        wordSearch.add("Test");
        wordSearch.add("Test");
        assertEquals(3, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnOneWhenWordSearchContainsWord() {
        wordSearch.add("AbTestDef");
        assertEquals(1, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnThreeWhenWordIsContainedInTheWordSearchLines() {
        wordSearch.add("TestTe");
        wordSearch.add("ABTest");
        wordSearch.add("TestCD");
        assertEquals(3, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnTwoIfWordIsContainTwiceInOneLine() {
        wordSearch.add("TestTest");
        assertEquals(2, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveCountCorrectlyIfWordIsContainMultipleTimesInMultipleLines() {
        wordSearch.add("AbcdTestEfgh");
        wordSearch.add("TestTestEfgh");
        wordSearch.add("TestTestTest");
        wordSearch.add("AbcdEfghIjkl");
        assertEquals(6, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnOneIfWordIsContainedInReverse() {
        wordSearch.add("ABCtseTEFG");
        assertEquals(1, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnTwoIfWordIsContainedInTwoRowsInReverse() {
        wordSearch.add("ABCtseTEFG");
        wordSearch.add("AtseTBCEFG");
        assertEquals(2, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnTwoIfWordIsContainedLeftToRightAndRightToLeft() {
        wordSearch.add("TestseT");
        assertEquals(2, solver.solve(wordSearch, "Test"));
    }

    @After
    public void tearDown() {
    }
}
