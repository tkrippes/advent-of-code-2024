package tkrippes.com.github.adventofcode2024.day12.solver;

import tkrippes.com.github.adventofcode2024.day12.GardenPlotsTestInputHelper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriceSolverV2Test {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void solveV2ForTestInput1ShouldReturnCorrectScore() {
        assertEquals(80, PriceSolverV2.solve(GardenPlotsTestInputHelper.getTestInput1GardenPlots()));
    }

    @Test
    public void solveV2ForTestInput2ShouldReturnCorrectScore() {
        assertEquals(436, PriceSolverV2.solve(GardenPlotsTestInputHelper.getTestInput2GardenPlots()));
    }

    @Test
    public void solveV2ForTestInput3ShouldReturnCorrectScore() {
        assertEquals(1206, PriceSolverV2.solve(GardenPlotsTestInputHelper.getTestInput3GardenPlots()));
    }

    @Test
    public void solveV2ForTestInput4ShouldReturnCorrectScore() {
        assertEquals(236, PriceSolverV2.solve(GardenPlotsTestInputHelper.getTestInput4GardenPlots()));
    }

    @Test
    public void solveV2ForTestInput5ShouldReturnCorrectScore() {
        assertEquals(368, PriceSolverV2.solve(GardenPlotsTestInputHelper.getTestInput5GardenPlots()));
    }

    @AfterEach
    public void tearDown() {
    }
}
