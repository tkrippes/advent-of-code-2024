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
    public void solveShouldReturnTwoIfWordsAreContainedHorizontallyInBothDirections() {
        wordSearch.add("TestseT");
        assertEquals(2, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnOneIfWordIsContainedVertically() {
        wordSearch.add("T");
        wordSearch.add("e");
        wordSearch.add("s");
        wordSearch.add("t");
        assertEquals(1, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnTwoIfWordIsContainedTwoTimesVertically() {
        wordSearch.add("TFa");
        wordSearch.add("eFb");
        wordSearch.add("soT");
        wordSearch.add("tue");
        wordSearch.add("ars");
        wordSearch.add("bFt");
        assertEquals(2, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnTwoIfWordIsContainedTwoTimesVerticallyInSameColumn() {
        wordSearch.add("T");
        wordSearch.add("e");
        wordSearch.add("s");
        wordSearch.add("t");
        wordSearch.add("T");
        wordSearch.add("e");
        wordSearch.add("s");
        wordSearch.add("t");
        assertEquals(2, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnOneIfWordIsContainedVerticallyReversed() {
        wordSearch.add("t");
        wordSearch.add("s");
        wordSearch.add("e");
        wordSearch.add("T");
        assertEquals(1, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnTwoIfWordIsContainedTwoTimesVerticallyReversed() {
        wordSearch.add("bFt");
        wordSearch.add("aFs");
        wordSearch.add("toe");
        wordSearch.add("suT");
        wordSearch.add("era");
        wordSearch.add("TFb");
        assertEquals(2, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnTwoIfWordIsContainedTwoTimesVerticallyReversedInSameColumn() {
        wordSearch.add("t");
        wordSearch.add("s");
        wordSearch.add("e");
        wordSearch.add("T");
        wordSearch.add("t");
        wordSearch.add("s");
        wordSearch.add("e");
        wordSearch.add("T");
        assertEquals(2, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnTwoIfWordsAreContainedVerticallyInBothDirections() {
        wordSearch.add("T");
        wordSearch.add("e");
        wordSearch.add("s");
        wordSearch.add("t");
        wordSearch.add("s");
        wordSearch.add("e");
        wordSearch.add("T");
        assertEquals(2, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnTwoIfWordsAreContainedHorizontallyAndVerticallyInBothDirections() {
        wordSearch.add("TestseT");
        wordSearch.add("eabcdee");
        wordSearch.add("sabcdes");
        wordSearch.add("tseTest");
        wordSearch.add("sabcdes");
        wordSearch.add("eabcdee");
        wordSearch.add("TestseT");
        assertEquals(10, solver.solve(wordSearch, "Test"));
    }

    @After
    public void tearDown() {
    }
}
