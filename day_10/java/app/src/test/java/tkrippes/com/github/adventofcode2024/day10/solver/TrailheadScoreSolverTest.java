package tkrippes.com.github.adventofcode2024.day10.solver;

import tkrippes.com.github.adventofcode2024.day10.TopographicMap;
import tkrippes.com.github.adventofcode2024.day10.TopographicMapTestInputHelper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrailheadScoreSolverTest {
    private TopographicMap testInput1Map;
    private TopographicMap testInput2Map;
    private TopographicMap testInput3Map;
    private TopographicMap testInput4Map;
    private TopographicMap testInput5Map;

    @BeforeEach
    public void setUp() {
        testInput1Map = TopographicMapTestInputHelper.getTestInput1TopographicMap();
        testInput2Map = TopographicMapTestInputHelper.getTestInput2TopographicMap();
        testInput3Map = TopographicMapTestInputHelper.getTestInput3TopographicMap();
        testInput4Map = TopographicMapTestInputHelper.getTestInput4TopographicMap();
        testInput5Map = TopographicMapTestInputHelper.getTestInput5TopographicMap();
    }

    @Test
    public void solveForTestInput1ShouldReturnCorrectScore() {
        assertEquals(1, TrailheadScoreSolver.solve(testInput1Map));
    }

    @Test
    public void solveForTestInput2ShouldReturnCorrectScore() {
        assertEquals(2, TrailheadScoreSolver.solve(testInput2Map));
    }

    @Test
    public void solveForTestInput3ShouldReturnCorrectScore() {
        assertEquals(4, TrailheadScoreSolver.solve(testInput3Map));
    }

    @Test
    public void solveForTestInput4ShouldReturnCorrectScore() {
        assertEquals(3, TrailheadScoreSolver.solve(testInput4Map));
    }

    @Test
    public void solveForTestInput5ShouldReturnCorrectScore() {
        assertEquals(36, TrailheadScoreSolver.solve(testInput5Map));
    }

    @AfterEach
    public void tearDown() {
    }
}
