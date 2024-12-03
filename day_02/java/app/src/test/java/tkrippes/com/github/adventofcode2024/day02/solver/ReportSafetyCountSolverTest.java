package tkrippes.com.github.adventofcode2024.day02.solver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReportSafetyCountSolverTest {
    private ReportSafetyCountSolver solver;

    private final List<Integer> decreasingSafeReport = new ArrayList<>(List.of(7, 6, 4, 2, 1));
    private final List<Integer> increasingSafeReport = new ArrayList<>(List.of(1, 3, 6, 7, 9));
    private final List<Integer> increasingTooMuchUnsafeReport = new ArrayList<>(List.of(1, 2, 7, 8, 9));
    private final List<Integer> decreasingTooMuchUnsafeReport = new ArrayList<>(List.of(9, 7, 6, 2, 1));
    private final List<Integer> decreasingNotEnoughUnsafeReport = new ArrayList<>(List.of(8, 6, 4, 4, 1));
    private final List<Integer> increasingDecreasingUnsafeReport = new ArrayList<>(List.of(1, 3, 2, 4, 5));

    @Before
    public void setUp() {
        solver = new ReportSafetyCountSolver();
    }

    @Test
    public void decreasingSafeReportShouldBeSafe() {
        assertTrue(solver.isSafe(decreasingSafeReport));
    }

    @Test
    public void increasingSafeReportShouldBeSafe() {
        assertTrue(solver.isSafe(increasingSafeReport));
    }

    @Test
    public void increasingTooMuchUnsafeReportShouldBeUnsafe() {
        assertFalse(solver.isSafe(increasingTooMuchUnsafeReport));
    }

    @Test
    public void decreasingTooMuchUnsafeReportShouldBeUnsafe() {
        assertFalse(solver.isSafe(decreasingTooMuchUnsafeReport));
    }

    @Test
    public void decreasingNotEnoughUnsafeReportShouldBeUnsafe() {
        assertFalse(solver.isSafe(decreasingNotEnoughUnsafeReport));
    }

    @Test
    public void increasingDecreasingUnsafeReportShouldBeUnsafe() {
        assertFalse(solver.isSafe(increasingDecreasingUnsafeReport));
    }

    @Test
    public void numberOfSafeReportsShouldBeCorrect() {
        int solution = solver.solve(new ArrayList<>(List.of(decreasingSafeReport, increasingSafeReport,
                increasingTooMuchUnsafeReport, decreasingTooMuchUnsafeReport,
                decreasingNotEnoughUnsafeReport, increasingDecreasingUnsafeReport)));
        assertEquals(2, solution);
    }

    @After
    public void tearDown() {
    }
}
