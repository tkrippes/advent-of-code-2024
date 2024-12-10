package tkrippes.com.github.adventofcode2024.day04.solver;

import tkrippes.com.github.adventofcode2024.day04.WordSearch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchCrossSolverTest {
    private WordSearchCrossSolver solver;
    private WordSearch wordSearch;

    @Before
    public void setUp() {
        solver = new WordSearchCrossSolver();
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
    public void solveShouldReturnZeroWhenWordSearchAndWordMatch() {
        wordSearch.add("Test");
        assertEquals(0, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnZeroIfOnlyPrimaryDiagonalMatchesWord() {
        wordSearch.add("TABC");
        wordSearch.add("DeFG");
        wordSearch.add("HIsJ");
        wordSearch.add("KLMt");
        assertEquals(0, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnZeroIfOnlyPrimaryDiagonalMatchesReversedWord() {
        wordSearch.add("tABC");
        wordSearch.add("DsEF");
        wordSearch.add("GHeI");
        wordSearch.add("JKLT");
        assertEquals(0, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnZeroIfOnlySecondaryDiagonalMatchesWord() {
        wordSearch.add("ABCT");
        wordSearch.add("DEeF");
        wordSearch.add("GsHI");
        wordSearch.add("tKLM");
        assertEquals(0, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnZeroIfOnlySecondaryDiagonalMatchesReversedWord() {
        wordSearch.add("ABCt");
        wordSearch.add("DEsF");
        wordSearch.add("GeHI");
        wordSearch.add("TKLM");
        assertEquals(0, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnONeIfPrimaryDiagonalMatchesWordAndSecondaryDiagonalMatchesWord() {
        wordSearch.add("TABT");
        wordSearch.add("DeeG");
        wordSearch.add("HssJ");
        wordSearch.add("tLMt");
        assertEquals(1, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnONeIfPrimaryDiagonalMatchesWordAndSecondaryDiagonalMatchesWordReversed() {
        wordSearch.add("TABt");
        wordSearch.add("DesG");
        wordSearch.add("HesJ");
        wordSearch.add("TLMt");
        assertEquals(1, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnONeIfPrimaryDiagonalMatchesWordReversedAndSecondaryDiagonalMatchesWord() {
        wordSearch.add("tABT");
        wordSearch.add("DseF");
        wordSearch.add("GseI");
        wordSearch.add("tKLT");
        assertEquals(1, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldReturnONeIfPrimaryDiagonalMatchesWordReversedAndSecondaryDiagonalMatchesWordReversed() {
        wordSearch.add("tABt");
        wordSearch.add("DssF");
        wordSearch.add("GeeI");
        wordSearch.add("TKLT");
        assertEquals(1, solver.solve(wordSearch, "Test"));
    }

    @Test
    public void solveShouldSolveTestInputFileContentCorrectly() {
        wordSearch.add("MMMSXXMASM");
        wordSearch.add("MSAMXMSMSA");
        wordSearch.add("AMXSXMAAMM");
        wordSearch.add("MSAMASMSMX");
        wordSearch.add("XMASAMXAMM");
        wordSearch.add("XXAMMXXAMA");
        wordSearch.add("SMSMSASXSS");
        wordSearch.add("SAXAMASAAA");
        wordSearch.add("MAMMMXMMMM");
        wordSearch.add("MXMXAXMASX");
        assertEquals(9, solver.solve(wordSearch, "MAS"));
    }

    @After
    public void tearDown() {

    }
}
