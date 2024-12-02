package tkrippes.com.github.solver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SimilarityScoreSolverTest {
    private SimilarityScoreSolver solver;
    private final ArrayList<Integer> firstList = new ArrayList<>(List.of(3, 4, 2, 1, 3, 3));
    private final ArrayList<Integer> secondList = new ArrayList<>(List.of(4, 3, 5, 3, 9, 3));

    @Before
    public void setUp() {
        solver = new SimilarityScoreSolver();
    }

    @Test(expected = IllegalArgumentException.class)
    public void solveTwoListOfDifferentSizesThrow() {
        solver.solve(List.of(1, 2, 3), List.of(4, 5));
    }

    @Test
    public void solutionShouldBeCorrect() {
        int solution = solver.solve(firstList, secondList);
        assertEquals(31, solution);
    }

    @After
    public void tearDown() {
    }
}
