package tkrippes.com.github.adventofcode2024.day10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TopographicMapTest {
    private TopographicMap testInput1Map;
    private TopographicMap testInput5Map;

    @BeforeEach
    public void setUp() {
        testInput1Map = TopographicMapTestInputHelper.getTestInput1TopographicMap();
        testInput5Map = TopographicMapTestInputHelper.getTestInput5TopographicMap();
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

    @Test
    public void getNeighboursOfInsidePosition() {
        List<Map.Entry<Position, Integer>> expectedNeighbours = List.of(Map.entry(new Position(1, 1), 2),
                Map.entry(new Position(2, 0), 8),
                Map.entry(new Position(2, 2), 6),
                Map.entry(new Position(3, 1), 8));

        assertEquals(new HashSet<>(expectedNeighbours),
                testInput1Map.getNeighbours(new Position(2, 1)));
    }

    @Test
    public void getNeighboursOfUpperBoundaryPosition() {
        List<Map.Entry<Position, Integer>> expectedNeighbours = List.of(Map.entry(new Position(0, 0), 0),
                Map.entry(new Position(0, 2), 2),
                Map.entry(new Position(1, 1), 2));

        assertEquals(new HashSet<>(expectedNeighbours),
                testInput1Map.getNeighbours(new Position(0, 1)));
    }

    @Test
    public void getNeighboursOfLeftBoundaryPosition() {
        List<Map.Entry<Position, Integer>> expectedNeighbours = List.of(Map.entry(new Position(0, 0), 0),
                Map.entry(new Position(1, 1), 2),
                Map.entry(new Position(2, 0), 8));

        assertEquals(new HashSet<>(expectedNeighbours),
                testInput1Map.getNeighbours(new Position(1, 0)));
    }

    @Test
    public void getNeighboursOfRightBoundaryPosition() {
        List<Map.Entry<Position, Integer>> expectedNeighbours = List.of(Map.entry(new Position(1, 3), 4),
                Map.entry(new Position(2, 2), 6),
                Map.entry(new Position(3, 3), 6));

        assertEquals(new HashSet<>(expectedNeighbours),
                testInput1Map.getNeighbours(new Position(2, 3)));
    }

    @Test
    public void getNeighboursOfLowerBoundaryPosition() {
        List<Map.Entry<Position, Integer>> expectedNeighbours = List.of(Map.entry(new Position(2, 1), 7),
                Map.entry(new Position(3, 0), 9),
                Map.entry(new Position(3, 2), 7));

        assertEquals(new HashSet<>(expectedNeighbours),
                testInput1Map.getNeighbours(new Position(3, 1)));
    }

    @Test
    public void getNeighboursOfUpperLeftCornerPosition() {
        List<Map.Entry<Position, Integer>> expectedNeighbours = List.of(Map.entry(new Position(0, 1), 1),
                Map.entry(new Position(1, 0), 1));

        assertEquals(new HashSet<>(expectedNeighbours),
                testInput1Map.getNeighbours(new Position(0, 0)));
    }

    @Test
    public void getNeighboursOfUpperRightCornerPosition() {
        List<Map.Entry<Position, Integer>> expectedNeighbours = List.of(Map.entry(new Position(0, 2), 2),
                Map.entry(new Position(1, 3), 4));

        assertEquals(new HashSet<>(expectedNeighbours),
                testInput1Map.getNeighbours(new Position(0, 3)));
    }

    @Test
    public void getNeighboursOfLowerLeftCornerPosition() {
        List<Map.Entry<Position, Integer>> expectedNeighbours = List.of(Map.entry(new Position(2, 0), 8),
                Map.entry(new Position(3, 1), 8));

        assertEquals(new HashSet<>(expectedNeighbours),
                testInput1Map.getNeighbours(new Position(3, 0)));
    }

    @Test
    public void getNeighboursOfLowerRightCornerPosition() {
        List<Map.Entry<Position, Integer>> expectedNeighbours = List.of(Map.entry(new Position(2, 3), 5),
                Map.entry(new Position(3, 2), 7));

        assertEquals(new HashSet<>(expectedNeighbours),
                testInput1Map.getNeighbours(new Position(3, 3)));
    }

    @AfterEach
    public void tearDown() {
    }
}
