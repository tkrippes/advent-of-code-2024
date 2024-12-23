package tkrippes.com.github.adventofcode2024.day10.Main.parser;

import tkrippes.com.github.adventofcode2024.day10.Main.Position;
import tkrippes.com.github.adventofcode2024.day10.Main.TopographicMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TopographicMapParserTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void parseThrowsForInvalidInputFileName() {
        assertThrows(FileNotFoundException.class, () -> TopographicMapParser.parse("../../input/invalid_test_input" +
                ".txt"));
    }

    @Test
    public void parseShouldParseInputFile1Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_1.txt";

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
        TopographicMap expectedTopographicMap = new TopographicMap(heightMap, 4, 4);

        assertEquals(expectedTopographicMap, TopographicMapParser.parse(validInputFileName));
    }

    @Test
    public void parseShouldParseInputFile5Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_5.txt";

        Map<Position, Integer> heightMap = new HashMap<>();
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
        TopographicMap expectedTopographicMap = new TopographicMap(heightMap, 8, 8);

        assertEquals(expectedTopographicMap, TopographicMapParser.parse(validInputFileName));
    }

    @AfterEach
    public void tearDown() {
    }
}
