package tkrippes.com.github.solver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDistanceSolverTest {
    private final ArrayList<Integer> firstList = new ArrayList<>(List.of(3, 4, 2, 1, 3, 3));
    private final ArrayList<Integer> secondList = new ArrayList<>(List.of(4, 3, 5, 3, 9, 3));

    @Before
    public void setUp() {
    }

    @Test
    public void firstListIsSortedCorrectlyWithoutModifyingInitialList() {
        ListDistanceSolver solver = new ListDistanceSolver();
        List<Integer> sortedFirstList = solver.sort(firstList);
        assertEquals(sortedFirstList, List.of(1, 2, 3, 3, 3, 4));
        assertEquals(firstList, List.of(3, 4, 2, 1, 3, 3));
    }

    @Test
    public void secondListIsSortedCorrectlyWithoutModifyingInitialList() {
        ListDistanceSolver solver = new ListDistanceSolver();
        List<Integer> sortedSecondList = solver.sort(secondList);
        assertEquals(sortedSecondList, List.of(3, 3, 3, 4, 5, 9));
        assertEquals(secondList, List.of(4, 3, 5, 3, 9, 3));
    }

    @After
    public void tearDown() {
    }
}
