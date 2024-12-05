package tkrippes.com.github.adventofcode2024.day03.solver;

import tkrippes.com.github.adventofcode2024.day03.Multiplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MultiplicationsSolverTest {
    private MultiplicationsSolver solver;

    @Before
    public void setUp() {
        solver = new MultiplicationsSolver();
    }

    @Test
    public void solutionShouldBeCorrect() {
        int solution = solver.solve(List.of(new Multiplication(2, 4), new Multiplication(5, 5),
                new Multiplication(11, 8), new Multiplication(8, 5)));
        assertEquals(161, solution);
    }

    @After
    public void tearDown() {
    }
}
