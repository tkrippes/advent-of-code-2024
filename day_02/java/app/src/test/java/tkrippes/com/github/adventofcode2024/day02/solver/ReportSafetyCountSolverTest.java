package tkrippes.com.github.adventofcode2024.day02.solver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReportSafetyCountSolverTest {
    private ReportSafetyCountSolver solver;

    private final List<Integer> tooShortReport = new ArrayList<>(List.of(3));
    private final List<Integer> decreasingReport = new ArrayList<>(List.of(7, 6, 4, 2, 1));
    private final List<Integer> increasingReport = new ArrayList<>(List.of(1, 3, 6, 7, 9));
    private final List<Integer> increasingTooMuchReport = new ArrayList<>(List.of(1, 2, 7, 8, 9));
    private final List<Integer> decreasingTooMuchReport = new ArrayList<>(List.of(9, 7, 6, 2, 1));
    private final List<Integer> decreasingOneEqualReport = new ArrayList<>(List.of(8, 6, 4, 4, 1));
    private final List<Integer> increasingDecreasingReport = new ArrayList<>(List.of(1, 3, 2, 4, 5));

    @Before
    public void setUp() {
        solver = new ReportSafetyCountSolver();
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneLevelReportSafetyCheckShouldThrow() {
        solver.isSafe(tooShortReport, 0);
    }

    @Test
    public void decreasingSafeReportShouldBeSafe() {
        assertTrue(solver.isSafe(decreasingReport, 0));
        assertTrue(solver.isSafe(decreasingReport, 1));
    }

    @Test
    public void increasingSafeReportShouldBeSafe() {
        assertTrue(solver.isSafe(increasingReport, 0));
        assertTrue(solver.isSafe(increasingReport, 1));
    }

    @Test
    public void increasingTooMuchUnsafeReportShouldBeUnsafe() {
        assertFalse(solver.isSafe(increasingTooMuchReport, 0));
        assertFalse(solver.isSafe(increasingTooMuchReport, 1));
    }

    @Test
    public void decreasingTooMuchUnsafeReportShouldBeUnsafe() {
        assertFalse(solver.isSafe(decreasingTooMuchReport, 0));
        assertFalse(solver.isSafe(decreasingTooMuchReport, 1));
    }

    @Test
    public void decreasingNotEnoughUnsafeReportShouldBeUnsafeForToleranceZero() {
        assertFalse(solver.isSafe(decreasingOneEqualReport, 0));
        assertTrue(solver.isSafe(decreasingOneEqualReport, 1));
    }

    @Test
    public void increasingDecreasingUnsafeReportShouldBeUnsafeForToleranceZero() {
        assertFalse(solver.isSafe(increasingDecreasingReport, 0));
        assertTrue(solver.isSafe(increasingDecreasingReport, 1));
    }

    @Test
    public void numberOfSafeReportsShouldBeCorrect() {
        int solution = solver.solve(new ArrayList<>(List.of(decreasingReport, increasingReport,
                increasingTooMuchReport, decreasingTooMuchReport,
                decreasingOneEqualReport, increasingDecreasingReport)), 0);
        assertEquals(2, solution);

        solution = solver.solve(new ArrayList<>(List.of(decreasingReport, increasingReport,
                increasingTooMuchReport, decreasingTooMuchReport,
                decreasingOneEqualReport, increasingDecreasingReport)), 1);
        assertEquals(4, solution);
    }

    @After
    public void tearDown() {
    }
}
