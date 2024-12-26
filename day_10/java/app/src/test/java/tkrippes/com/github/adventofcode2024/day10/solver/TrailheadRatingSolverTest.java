package tkrippes.com.github.adventofcode2024.day10.solver;

import tkrippes.com.github.adventofcode2024.day10.TopographicMap;
import tkrippes.com.github.adventofcode2024.day10.TopographicMapTestInputHelper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrailheadRatingSolverTest {
    private TopographicMap testInput6Map;
    private TopographicMap testInput3Map;
    private TopographicMap testInput7Map;
    private TopographicMap testInput5Map;

    @BeforeEach
    public void setUp() {
        testInput6Map = TopographicMapTestInputHelper.getTestInput6TopographicMap();
        testInput3Map = TopographicMapTestInputHelper.getTestInput3TopographicMap();
        testInput7Map = TopographicMapTestInputHelper.getTestInput7TopographicMap();
        testInput5Map = TopographicMapTestInputHelper.getTestInput5TopographicMap();
    }

    @Test
    public void solveForTestInput6ShouldReturnCorrectScore() {
        assertEquals(3, TrailheadRatingSolver.solve(testInput6Map));
    }

    @Test
    public void solveForTestInput3ShouldReturnCorrectScore() {
        assertEquals(13, TrailheadRatingSolver.solve(testInput3Map));
    }

    @Test
    public void solveForTestInput7ShouldReturnCorrectScore() {
        assertEquals(227, TrailheadRatingSolver.solve(testInput7Map));
    }

    @Test
    public void solveForTestInput5ShouldReturnCorrectScore() {
        assertEquals(81, TrailheadRatingSolver.solve(testInput5Map));
    }

    @AfterEach
    public void tearDown() {
    }
}
