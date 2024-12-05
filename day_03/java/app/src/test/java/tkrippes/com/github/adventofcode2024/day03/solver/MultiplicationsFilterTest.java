package tkrippes.com.github.adventofcode2024.day03.solver;

import tkrippes.com.github.adventofcode2024.day03.Multiplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class MultiplicationsFilterTest {
    private MultiplicationsFilter filter;

    @Before
    public void setUp() {
        filter = new MultiplicationsFilter();
    }

    @Test
    public void multiplicationsWithNoFilterShouldNotBeFiltered() {
        Map<Integer, Multiplication> multiplicationsMap = Map.of(0, new Multiplication(1, 2), 5, new Multiplication(2, 3),
                10, new Multiplication(3, 4));
        Map<Integer, Boolean> filterMap = Map.of();
        assertEquals(multiplicationsMap.values().stream().toList(), filter.filter(multiplicationsMap, filterMap));
    }

    @Test
    public void multiplicationsWithDontAtBeginningShouldAllBeFiltered() {
        Map<Integer, Multiplication> multiplicationsMap = Map.of(5, new Multiplication(1, 2), 10, new Multiplication(2, 3),
                15, new Multiplication(3, 4));
        Map<Integer, Boolean> filterMap = Map.of(0, true);
        assertTrue(filter.filter(multiplicationsMap, filterMap).isEmpty());
    }

    @Test
    public void multiplicationsWithDontAtEndShouldNotBeFiltered() {
        Map<Integer, Multiplication> multiplicationsMap = Map.of(5, new Multiplication(1, 2), 10, new Multiplication(2, 3),
                15, new Multiplication(3, 4));
        Map<Integer, Boolean> filterMap = Map.of(20, true);
        assertEquals(multiplicationsMap.values().stream().toList(), filter.filter(multiplicationsMap, filterMap));
    }

    @Test
    public void multiplicationsWithOnlyDosShouldNotBeFiltered() {
        Map<Integer, Multiplication> multiplicationsMap = Map.of(5, new Multiplication(1, 2), 10, new Multiplication(2, 3),
                15, new Multiplication(3, 4));
        Map<Integer, Boolean> filterMap = Map.of(0, false, 2, false, 7, false, 12, false);
        assertEquals(multiplicationsMap.values().stream().toList(), filter.filter(multiplicationsMap, filterMap));
    }

    @Test
    public void multiplicationsShouldBeFilteredCorrectly() {
        Map<Integer, Multiplication> multiplicationsMap = Map.of(5, new Multiplication(1, 2), 10, new Multiplication(2, 3),
                15, new Multiplication(3, 4), 20, new Multiplication(4, 5), 25, new Multiplication(5, 6),
                30, new Multiplication(6, 7), 35, new Multiplication(7, 8));
        Map<Integer, Boolean> filterMap = Map.of(2, true, 7, false, 12, true,
                17, true, 22, false, 27, false, 32, true);
        assertEquals(List.of(new Multiplication(2, 3), new Multiplication(5, 6), new Multiplication(6, 7)),
                filter.filter(new TreeMap<>(multiplicationsMap), new TreeMap<>(filterMap)));
    }

    @After
    public void tearDown() {

    }
}
