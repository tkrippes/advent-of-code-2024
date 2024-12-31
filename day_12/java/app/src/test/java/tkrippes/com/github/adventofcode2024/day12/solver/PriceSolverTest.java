package tkrippes.com.github.adventofcode2024.day12.solver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tkrippes.com.github.adventofcode2024.day12.GardenPlotsTestInputHelper;

import static org.junit.jupiter.api.Assertions.*;

public class PriceSolverTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void solveForTestInput1ShouldReturnCorrectScore() {
        assertEquals(140, PriceSolver.solve(GardenPlotsTestInputHelper.getTestInput1GardenPlots()));
    }

    @Test
    public void solveForTestInput2ShouldReturnCorrectScore() {
        assertEquals(772, PriceSolver.solve(GardenPlotsTestInputHelper.getTestInput2GardenPlots()));
    }

    @Test
    public void solveForTestInput3ShouldReturnCorrectScore() {
        assertEquals(1930, PriceSolver.solve(GardenPlotsTestInputHelper.getTestInput3GardenPlots()));
    }

    // TODO move tests to different file once the solver is split
    @Test
    public void solveV2ForTestInput1ShouldReturnCorrectScore() {
        assertEquals(80, PriceSolver.solveV2(GardenPlotsTestInputHelper.getTestInput1GardenPlots()));
    }

    @Test
    public void solveV2ForTestInput2ShouldReturnCorrectScore() {
        assertEquals(436, PriceSolver.solveV2(GardenPlotsTestInputHelper.getTestInput2GardenPlots()));
    }

    @Test
    public void solveV2ForTestInput3ShouldReturnCorrectScore() {
        assertEquals(1206, PriceSolver.solveV2(GardenPlotsTestInputHelper.getTestInput3GardenPlots()));
    }

    @Test
    public void solveV2ForTestInput4ShouldReturnCorrectScore() {
        assertEquals(236, PriceSolver.solveV2(GardenPlotsTestInputHelper.getTestInput4GardenPlots()));
    }

    @Test
    public void solveV2ForTestInput5ShouldReturnCorrectScore() {
        assertEquals(368, PriceSolver.solveV2(GardenPlotsTestInputHelper.getTestInput5GardenPlots()));
    }

    @AfterEach
    public void tearDown() {
    }
}
