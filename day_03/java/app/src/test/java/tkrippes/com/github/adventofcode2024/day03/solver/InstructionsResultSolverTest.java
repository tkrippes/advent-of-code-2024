package tkrippes.com.github.adventofcode2024.day03.solver;

import tkrippes.com.github.adventofcode2024.day03.Memory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InstructionsResultSolverTest {
    private InstructionsResultSolver solver;

    @Before
    public void setUp() {
        solver = new InstructionsResultSolver();
    }

    @Test
    public void solutionShouldBeCorrect() {
        int solution = solver.solve(new Memory(List.of(new Memory.Multiplication(2, 4), new Memory.Multiplication(5, 5),
                new Memory.Multiplication(11, 8), new Memory.Multiplication(8, 5))));
        assertEquals(161, solution);
    }

    @After
    public void tearDown() {
    }
}
