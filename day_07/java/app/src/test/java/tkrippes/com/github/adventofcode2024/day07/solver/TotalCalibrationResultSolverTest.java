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
        assertTrue(solver.isEquationSolvable(new Equation(190, List.of(10, 19))));
        assertTrue(solver.isEquationSolvable(new Equation(3267, List.of(81, 40, 27))));
        assertFalse(solver.isEquationSolvable(new Equation(83, List.of(17, 5))));
        assertFalse(solver.isEquationSolvable(new Equation(156, List.of(15, 6))));
        assertFalse(solver.isEquationSolvable(new Equation(7290, List.of(6, 8, 6, 15))));
        assertFalse(solver.isEquationSolvable(new Equation(161011, List.of(16, 10, 13))));
        assertFalse(solver.isEquationSolvable(new Equation(192, List.of(17, 8, 14))));
        assertFalse(solver.isEquationSolvable(new Equation(21037, List.of(9, 7, 18, 13))));
        assertTrue(solver.isEquationSolvable(new Equation(292, List.of(11, 6, 16, 20))));
    }

    @Test
    void solveForTestInputShouldReturnCorrectly() {
        List<Equation> equations = List.of(
                new Equation(190, List.of(10, 19)),
                new Equation(3267, List.of(81, 40, 27)),
                new Equation(83, List.of(17, 5)),
                new Equation(156, List.of(15, 6)),
                new Equation(7290, List.of(6, 8, 6, 15)),
                new Equation(161011, List.of(16, 10, 13)),
                new Equation(192, List.of(17, 8, 14)),
                new Equation(21037, List.of(9, 7, 18, 13)),
                new Equation(292, List.of(11, 6, 16, 20))
        );

        assertEquals(3749, solver.solve(equations));
    }

    @AfterEach
    void tearDown() {
    }
}
