package tkrippes.com.github.adventofcode2024.day12.solver;

import tkrippes.com.github.adventofcode2024.day12.GardenPlotsTestInputHelper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriceSolverV1Test {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void solveForTestInput1ShouldReturnCorrectScore() {
        assertEquals(140, PriceSolverV1.solve(GardenPlotsTestInputHelper.getTestInput1GardenPlots()));
    }

    @Test
    public void solveForTestInput2ShouldReturnCorrectScore() {
        assertEquals(772, PriceSolverV1.solve(GardenPlotsTestInputHelper.getTestInput2GardenPlots()));
    }

    @Test
    public void solveForTestInput3ShouldReturnCorrectScore() {
        assertEquals(1930, PriceSolverV1.solve(GardenPlotsTestInputHelper.getTestInput3GardenPlots()));
    }

    @AfterEach
    public void tearDown() {
    }
}
