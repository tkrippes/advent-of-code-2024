package tkrippes.com.github.adventofcode2024.day07.solver;

import tkrippes.com.github.adventofcode2024.day07.Equation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TotalCalibrationResultSolverTest {
    private TotalCalibrationResultSolver solver;

    @BeforeEach
    void setUp() {
        solver = new TotalCalibrationResultSolver();
    }

    @Test
    void isEquationSolvableForTestInputsShouldReturnCorrectly() {
        assertTrue(solver.isEquationSolvable(new Equation(190, List.of(10L, 19L))));
        assertTrue(solver.isEquationSolvable(new Equation(3267, List.of(81L, 40L, 27L))));
        assertFalse(solver.isEquationSolvable(new Equation(83, List.of(17L, 5L))));
        assertFalse(solver.isEquationSolvable(new Equation(156, List.of(15L, 6L))));
        assertFalse(solver.isEquationSolvable(new Equation(7290, List.of(6L, 8L, 6L, 15L))));
        assertFalse(solver.isEquationSolvable(new Equation(161011, List.of(16L, 10L, 13L))));
        assertFalse(solver.isEquationSolvable(new Equation(192, List.of(17L, 8L, 14L))));
        assertFalse(solver.isEquationSolvable(new Equation(21037, List.of(9L, 7L, 18L, 13L))));
        assertTrue(solver.isEquationSolvable(new Equation(292, List.of(11L, 6L, 16L, 20L))));
    }

    @Test
    void isEquationSolvableForTestInputsShouldReturnCorrectlyIncludingConcatenation() {
        assertTrue(solver.isEquationSolvable(new Equation(190, List.of(10L, 19L)), true));
        assertTrue(solver.isEquationSolvable(new Equation(3267, List.of(81L, 40L, 27L)), true));
        assertFalse(solver.isEquationSolvable(new Equation(83, List.of(17L, 5L)), true));
        assertTrue(solver.isEquationSolvable(new Equation(156, List.of(15L, 6L)), true));
        assertTrue(solver.isEquationSolvable(new Equation(7290, List.of(6L, 8L, 6L, 15L)), true));
        assertFalse(solver.isEquationSolvable(new Equation(161011, List.of(16L, 10L, 13L)), true));
        assertTrue(solver.isEquationSolvable(new Equation(192, List.of(17L, 8L, 14L)), true));
        assertFalse(solver.isEquationSolvable(new Equation(21037, List.of(9L, 7L, 18L, 13L)), true));
        assertTrue(solver.isEquationSolvable(new Equation(292, List.of(11L, 6L, 16L, 20L)), true));
    }

    @Test
    void solveForTestInputShouldReturnCorrectly() {
        List<Equation> equations = List.of(
                new Equation(190, List.of(10L, 19L)),
                new Equation(3267, List.of(81L, 40L, 27L)),
                new Equation(83, List.of(17L, 5L)),
                new Equation(156, List.of(15L, 6L)),
                new Equation(7290, List.of(6L, 8L, 6L, 15L)),
                new Equation(161011, List.of(16L, 10L, 13L)),
                new Equation(192, List.of(17L, 8L, 14L)),
                new Equation(21037, List.of(9L, 7L, 18L, 13L)),
                new Equation(292, List.of(11L, 6L, 16L, 20L))
        );

        assertEquals(3749, solver.solve(equations));
    }

    @Test
    void solveForTestInputShouldReturnCorrectlyIncludingConcatenation() {
        List<Equation> equations = List.of(
                new Equation(190, List.of(10L, 19L)),
                new Equation(3267, List.of(81L, 40L, 27L)),
                new Equation(83, List.of(17L, 5L)),
                new Equation(156, List.of(15L, 6L)),
                new Equation(7290, List.of(6L, 8L, 6L, 15L)),
                new Equation(161011, List.of(16L, 10L, 13L)),
                new Equation(192, List.of(17L, 8L, 14L)),
                new Equation(21037, List.of(9L, 7L, 18L, 13L)),
                new Equation(292, List.of(11L, 6L, 16L, 20L))
        );

        assertEquals(11387, solver.solve(equations, true));
    }

    @AfterEach
    void tearDown() {
    }
}
