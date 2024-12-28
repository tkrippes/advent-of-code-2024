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

    @AfterEach
    public void tearDown() {
    }
}
