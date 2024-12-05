package tkrippes.com.github.adventofcode2024.day03.solver;

import tkrippes.com.github.adventofcode2024.day03.Multiplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class MultiplicationsSolverTest {
    private MultiplicationsSolver solver;

    @Before
    public void setUp() {
        solver = new MultiplicationsSolver();
    }

    @Test
    public void solutionWithoutFiltersShouldBeCorrect() {
        int solution = solver.solve(Map.of(1, new Multiplication(2, 4), 29, new Multiplication(5, 5),
                53, new Multiplication(11, 8), 62, new Multiplication(8, 5)), Map.of());
        assertEquals(161, solution);
    }

    @Test
    public void solutionWithFiltersShouldBeCorrect() {
        int solution = solver.solve(Map.of(1, new Multiplication(2, 4), 28, new Multiplication(5, 5),
                        48, new Multiplication(11, 8), 64, new Multiplication(8, 5)),
                Map.of(20, true, 59, false));
        assertEquals(48, solution);
    }


    @After
    public void tearDown() {
    }
}
