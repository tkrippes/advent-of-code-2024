package tkrippes.com.github.adventofcode2024.day11.solver;

import tkrippes.com.github.adventofcode2024.day11.PlutonianPebble;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StoneCountSolverTest {
    private final List<PlutonianPebble> initialStones = List.of(new PlutonianPebble(125), new PlutonianPebble(17));

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void solveForOneBlinkShouldReturnCorrectStoneCount() {
        assertEquals(3, StoneCountSolver.solve(initialStones, 1));
    }

    @Test
    public void solveForTwoBlinksShouldReturnCorrectStoneCount() {
        assertEquals(4, StoneCountSolver.solve(initialStones, 2));
    }

    @Test
    public void solveForThreeBlinksShouldReturnCorrectStoneCount() {
        assertEquals(5, StoneCountSolver.solve(initialStones, 3));
    }

    @Test
    public void solveForFourBlinksShouldReturnCorrectStoneCount() {
        assertEquals(9, StoneCountSolver.solve(initialStones, 4));
    }

    @Test
    public void solveForFiveBlinksShouldReturnCorrectStoneCount() {
        assertEquals(13, StoneCountSolver.solve(initialStones, 5));
    }

    @Test
    public void solveForSixBlinksShouldReturnCorrectStoneCount() {
        assertEquals(22, StoneCountSolver.solve(initialStones, 6));
    }

    @Test
    public void solveForTwentyFiveBlinksShouldReturnCorrectStoneCount() {
        assertEquals(55312, StoneCountSolver.solve(initialStones, 25));
    }

    @AfterEach
    public void tearDown() {
    }
}
