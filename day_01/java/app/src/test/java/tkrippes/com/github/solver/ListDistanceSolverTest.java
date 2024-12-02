package tkrippes.com.github.solver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDistanceSolverTest {
    private ListDistanceSolver solver;
    private final ArrayList<Integer> firstList = new ArrayList<>(List.of(3, 4, 2, 1, 3, 3));
    private final ArrayList<Integer> secondList = new ArrayList<>(List.of(4, 3, 5, 3, 9, 3));

    @Before
    public void setUp() {
        solver = new ListDistanceSolver();
    }

    @Test
    public void firstListIsSortedCorrectlyWithoutModifyingInitialList() {
        List<Integer> sortedFirstList = solver.sort(firstList);
        assertEquals(List.of(1, 2, 3, 3, 3, 4), sortedFirstList);
        assertEquals(List.of(3, 4, 2, 1, 3, 3), firstList);
    }

    @Test
    public void secondListIsSortedCorrectlyWithoutModifyingInitialList() {
        List<Integer> sortedSecondList = solver.sort(secondList);
        assertEquals(List.of(3, 3, 3, 4, 5, 9), sortedSecondList);
        assertEquals(List.of(4, 3, 5, 3, 9, 3), secondList);
    }

    @Test
    public void distanceBetweenTwoEqualNumbersIsCorrect() {
        int distance = solver.distance(3, 3);
        assertEquals(0, distance);
    }

    @Test
    public void distanceBetweenBiggerAndSmallerNumberIsCorrect() {
        int distance = solver.distance(4, 2);
        assertEquals(2, distance);
    }

    @Test
    public void distanceBetweenSmallerAndBiggerNumberIsCorrect() {
        int distance = solver.distance(5, 8);
        assertEquals(3, distance);
    }

    @Test
    public void sumOfFistListIsCorrect() {
        int sum = solver.sum(firstList);
        assertEquals(16, sum);
    }

    @Test
    public void sumOfSecondListIsCorrect() {
        int sum = solver.sum(secondList);
        assertEquals(27, sum);
    }

    @After
    public void tearDown() {
    }
}
