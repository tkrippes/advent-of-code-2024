package tkrippes.com.github.adventofcode2024.day10.Main.solver;

import tkrippes.com.github.adventofcode2024.day10.Main.Position;
import tkrippes.com.github.adventofcode2024.day10.Main.TopographicMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TrailheadScoreSolverTest {
    private TopographicMap testInput1Map;
    private TopographicMap testInput5Map;

    @BeforeEach
    public void setUp() {
        Map<Position, Integer> heightMap = new HashMap<>();
        heightMap.put(new Position(0, 0), 0);
        heightMap.put(new Position(0, 1), 1);
        heightMap.put(new Position(0, 2), 2);
        heightMap.put(new Position(0, 3), 3);
        heightMap.put(new Position(1, 0), 1);
        heightMap.put(new Position(1, 1), 2);
        heightMap.put(new Position(1, 2), 3);
        heightMap.put(new Position(1, 3), 4);
        heightMap.put(new Position(2, 0), 8);
        heightMap.put(new Position(2, 1), 7);
        heightMap.put(new Position(2, 2), 6);
        heightMap.put(new Position(2, 3), 5);
        heightMap.put(new Position(3, 0), 9);
        heightMap.put(new Position(3, 1), 8);
        heightMap.put(new Position(3, 2), 7);
        heightMap.put(new Position(3, 3), 6);
        testInput1Map = new TopographicMap(heightMap, 4, 4);

        heightMap = new HashMap<>();
        heightMap.put(new Position(0, 0), 8);
        heightMap.put(new Position(0, 1), 9);
        heightMap.put(new Position(0, 2), 0);
        heightMap.put(new Position(0, 3), 1);
        heightMap.put(new Position(0, 4), 0);
        heightMap.put(new Position(0, 5), 1);
        heightMap.put(new Position(0, 6), 2);
        heightMap.put(new Position(0, 7), 3);
        heightMap.put(new Position(1, 0), 7);
        heightMap.put(new Position(1, 1), 8);
        heightMap.put(new Position(1, 2), 1);
        heightMap.put(new Position(1, 3), 2);
        heightMap.put(new Position(1, 4), 1);
        heightMap.put(new Position(1, 5), 8);
        heightMap.put(new Position(1, 6), 7);
        heightMap.put(new Position(1, 7), 4);
        heightMap.put(new Position(2, 0), 8);
        heightMap.put(new Position(2, 1), 7);
        heightMap.put(new Position(2, 2), 4);
        heightMap.put(new Position(2, 3), 3);
        heightMap.put(new Position(2, 4), 0);
        heightMap.put(new Position(2, 5), 9);
        heightMap.put(new Position(2, 6), 6);
        heightMap.put(new Position(2, 7), 5);
        heightMap.put(new Position(3, 0), 9);
        heightMap.put(new Position(3, 1), 6);
        heightMap.put(new Position(3, 2), 5);
        heightMap.put(new Position(3, 3), 4);
        heightMap.put(new Position(3, 4), 9);
        heightMap.put(new Position(3, 5), 8);
        heightMap.put(new Position(3, 6), 7);
        heightMap.put(new Position(3, 7), 4);
        heightMap.put(new Position(4, 0), 4);
        heightMap.put(new Position(4, 1), 5);
        heightMap.put(new Position(4, 2), 6);
        heightMap.put(new Position(4, 3), 7);
        heightMap.put(new Position(4, 4), 8);
        heightMap.put(new Position(4, 5), 9);
        heightMap.put(new Position(4, 6), 0);
        heightMap.put(new Position(4, 7), 3);
        heightMap.put(new Position(5, 0), 3);
        heightMap.put(new Position(5, 1), 2);
        heightMap.put(new Position(5, 2), 0);
        heightMap.put(new Position(5, 3), 1);
        heightMap.put(new Position(5, 4), 9);
        heightMap.put(new Position(5, 5), 0);
        heightMap.put(new Position(5, 6), 1);
        heightMap.put(new Position(5, 7), 2);
        heightMap.put(new Position(6, 0), 0);
        heightMap.put(new Position(6, 1), 1);
        heightMap.put(new Position(6, 2), 3);
        heightMap.put(new Position(6, 3), 2);
        heightMap.put(new Position(6, 4), 9);
        heightMap.put(new Position(6, 5), 8);
        heightMap.put(new Position(6, 6), 0);
        heightMap.put(new Position(6, 7), 1);
        heightMap.put(new Position(7, 0), 1);
        heightMap.put(new Position(7, 1), 0);
        heightMap.put(new Position(7, 2), 4);
        heightMap.put(new Position(7, 3), 5);
        heightMap.put(new Position(7, 4), 6);
        heightMap.put(new Position(7, 5), 7);
        heightMap.put(new Position(7, 6), 3);
        heightMap.put(new Position(7, 7), 2);
        testInput5Map = new TopographicMap(heightMap, 8, 8);
    }

    @Test
    public void solveForTestInput1ShouldReturnCorrectScore() {
        assertEquals(1, TrailheadScoreSolver.solve(testInput1Map));
    }

    @Test
    public void solveForTestInput5ShouldReturnCorrectScore() {
        assertEquals(36, TrailheadScoreSolver.solve(testInput5Map));
    }

    @AfterEach
    public void tearDown() {
    }
}
