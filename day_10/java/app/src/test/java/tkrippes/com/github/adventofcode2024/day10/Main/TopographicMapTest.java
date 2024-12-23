package tkrippes.com.github.adventofcode2024.day10.Main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TopographicMapTest {
    private TopographicMap testInput1Map;
    private TopographicMap testInput5Map;

    @BeforeEach
    public void setUp() {
        Map<Position, Integer> map = new HashMap<>();
        map.put(new Position(0, 0), 0);
        map.put(new Position(0, 1), 1);
        map.put(new Position(0, 2), 2);
        map.put(new Position(0, 3), 3);
        map.put(new Position(1, 0), 1);
        map.put(new Position(1, 1), 2);
        map.put(new Position(1, 2), 3);
        map.put(new Position(1, 3), 4);
        map.put(new Position(2, 0), 8);
        map.put(new Position(2, 1), 7);
        map.put(new Position(2, 2), 6);
        map.put(new Position(2, 3), 5);
        map.put(new Position(3, 0), 9);
        map.put(new Position(3, 1), 8);
        map.put(new Position(3, 2), 7);
        map.put(new Position(3, 3), 6);
        testInput1Map = new TopographicMap(map);

        map = new HashMap<>();
        map.put(new Position(0, 0), 8);
        map.put(new Position(0, 1), 9);
        map.put(new Position(0, 2), 0);
        map.put(new Position(0, 3), 1);
        map.put(new Position(0, 4), 0);
        map.put(new Position(0, 5), 1);
        map.put(new Position(0, 6), 2);
        map.put(new Position(0, 7), 3);
        map.put(new Position(1, 0), 7);
        map.put(new Position(1, 1), 8);
        map.put(new Position(1, 2), 1);
        map.put(new Position(1, 3), 2);
        map.put(new Position(1, 4), 1);
        map.put(new Position(1, 5), 8);
        map.put(new Position(1, 6), 7);
        map.put(new Position(1, 7), 4);
        map.put(new Position(2, 0), 8);
        map.put(new Position(2, 1), 7);
        map.put(new Position(2, 2), 4);
        map.put(new Position(2, 3), 3);
        map.put(new Position(2, 4), 0);
        map.put(new Position(2, 5), 9);
        map.put(new Position(2, 6), 6);
        map.put(new Position(2, 7), 5);
        map.put(new Position(3, 0), 9);
        map.put(new Position(3, 1), 6);
        map.put(new Position(3, 2), 5);
        map.put(new Position(3, 3), 4);
        map.put(new Position(3, 4), 9);
        map.put(new Position(3, 5), 8);
        map.put(new Position(3, 6), 7);
        map.put(new Position(3, 7), 4);
        map.put(new Position(4, 0), 4);
        map.put(new Position(4, 1), 5);
        map.put(new Position(4, 2), 6);
        map.put(new Position(4, 3), 7);
        map.put(new Position(4, 4), 8);
        map.put(new Position(4, 5), 9);
        map.put(new Position(4, 6), 0);
        map.put(new Position(4, 7), 3);
        map.put(new Position(5, 0), 3);
        map.put(new Position(5, 1), 2);
        map.put(new Position(5, 2), 0);
        map.put(new Position(5, 3), 1);
        map.put(new Position(5, 4), 9);
        map.put(new Position(5, 5), 0);
        map.put(new Position(5, 6), 1);
        map.put(new Position(5, 7), 2);
        map.put(new Position(6, 0), 0);
        map.put(new Position(6, 1), 1);
        map.put(new Position(6, 2), 3);
        map.put(new Position(6, 3), 2);
        map.put(new Position(6, 4), 9);
        map.put(new Position(6, 5), 8);
        map.put(new Position(6, 6), 0);
        map.put(new Position(6, 7), 1);
        map.put(new Position(7, 0), 1);
        map.put(new Position(7, 1), 0);
        map.put(new Position(7, 2), 4);
        map.put(new Position(7, 3), 5);
        map.put(new Position(7, 4), 6);
        map.put(new Position(7, 5), 7);
        map.put(new Position(7, 6), 3);
        map.put(new Position(7, 7), 2);
        testInput5Map = new TopographicMap(map);
    }

    @Test
    public void getTrailheadPositionsOfTestInput1ShouldReturnCorrectTrailHeadPositions() {
        assertEquals(Set.of(new Position(0, 0)), testInput1Map.getTrailheadPositions());
    }

    @Test
    public void getTrailheadPositionsOfTestInput5ShouldReturnCorrectTrailHeadPositions() {
        assertEquals(Set.of(
                new Position(0, 2),
                new Position(0, 4),
                new Position(2, 4),
                new Position(4, 6),
                new Position(5, 2),
                new Position(5, 5),
                new Position(6, 0),
                new Position(6, 6),
                new Position(7, 1)), testInput5Map.getTrailheadPositions());
    }

    @Test
    public void getTrailEndPositionsOfTestInput1ShouldReturnCorrectTrailEndPositions() {
        assertEquals(Set.of(new Position(3, 0)), testInput1Map.getTrailEndPositions());
    }

    @Test
    public void getTrailEndPositionsOfTestInput5ShouldReturnCorrectTrailEndPositions() {
        assertEquals(Set.of(
                new Position(0, 1),
                new Position(2, 5),
                new Position(3, 0),
                new Position(3, 4),
                new Position(4, 5),
                new Position(5, 4),
                new Position(6, 4)), testInput5Map.getTrailEndPositions());
    }

    @AfterEach
    public void tearDown() {
    }
}
