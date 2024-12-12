package tkrippes.com.github.adventofcode2024.day06.parser;

import tkrippes.com.github.adventofcode2024.day06.map.Guard;
import tkrippes.com.github.adventofcode2024.day06.map.Orientation;
import tkrippes.com.github.adventofcode2024.day06.map.Position;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LabLapMapParserTest {
    private LapMapParser parser;

    @BeforeEach
    void setUp() {
        parser = new LapMapParser();
    }

    @Test
    public void parseThrowsForInvalidInputFileName() {
        assertThrows(FileNotFoundException.class, () -> parser.parse("../../input/invalid_test_input.txt"));
    }

    @Test
    public void parseEmptyMapShouldReturnEmptyMap() {
        assertTrue(parser.parseObstacleMap("").isEmpty());
    }

    @Test
    public void parseFreeOnlyMapReturnsObstacle() {
        assertEquals(Map.of(new Position(0, 0), false), parser.parseObstacleMap("."));
    }

    @Test
    public void parseObstacleOnlyMapReturnsObstacle() {
        assertEquals(Map.of(new Position(0, 0), true), parser.parseObstacleMap("#"));
    }

    @Test
    public void parseObstacleMapShouldReturnCorrectly() {
        Map<Position, Boolean> expectedObstacleMap = new HashMap<>();
        expectedObstacleMap.put(new Position(0, 0), true);
        expectedObstacleMap.put(new Position(0, 1), true);
        expectedObstacleMap.put(new Position(0, 2), true);
        expectedObstacleMap.put(new Position(0, 3), true);
        expectedObstacleMap.put(new Position(1, 0), true);
        expectedObstacleMap.put(new Position(1, 1), false);
        expectedObstacleMap.put(new Position(1, 2), false);
        expectedObstacleMap.put(new Position(1, 3), true);
        expectedObstacleMap.put(new Position(2, 0), true);
        expectedObstacleMap.put(new Position(2, 1), false);
        expectedObstacleMap.put(new Position(2, 2), false);
        expectedObstacleMap.put(new Position(2, 3), true);
        expectedObstacleMap.put(new Position(3, 0), true);
        expectedObstacleMap.put(new Position(3, 1), true);
        expectedObstacleMap.put(new Position(3, 2), true);
        expectedObstacleMap.put(new Position(3, 3), true);

        assertEquals(expectedObstacleMap, parser.parseObstacleMap("####\n#..#\n#..#\n####"));
    }

    @Test
    public void parseGuardForEmptyMapShouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseGuard(""));
    }

    @Test
    public void parseGuardForMapWithoutGuardShouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseGuard("####\n#..#\n#..#\n####"));
    }

    @Test
    public void parseGuardForMapWithGuardShouldReturnGuard() {
        assertEquals(new Guard(new Position(2, 1), Orientation.UP), parser.parseGuard("####\n#..#\n#^.#\n####"));
    }

    @AfterEach
    void tearDown() {
    }
}
