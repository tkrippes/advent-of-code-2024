package tkrippes.com.github.adventofcode2024.day10;

import java.util.HashMap;
import java.util.Map;

public class TopographicMapTestInputHelper {
    public static TopographicMap getTestInput1TopographicMap() {
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

        return new TopographicMap(heightMap);
    }

    public static TopographicMap getTestInput2TopographicMap() {
        Map<Position, Integer> heightMap = new HashMap<>();
        heightMap.put(new Position(0, 3), 0);
        heightMap.put(new Position(1, 3), 1);
        heightMap.put(new Position(2, 3), 2);
        heightMap.put(new Position(3, 0), 6);
        heightMap.put(new Position(3, 1), 5);
        heightMap.put(new Position(3, 2), 4);
        heightMap.put(new Position(3, 3), 3);
        heightMap.put(new Position(3, 4), 4);
        heightMap.put(new Position(3, 5), 5);
        heightMap.put(new Position(3, 6), 6);
        heightMap.put(new Position(4, 0), 7);
        heightMap.put(new Position(4, 6), 7);
        heightMap.put(new Position(5, 0), 8);
        heightMap.put(new Position(5, 6), 8);
        heightMap.put(new Position(6, 0), 9);
        heightMap.put(new Position(6, 6), 9);

        return new TopographicMap(heightMap);
    }

    public static TopographicMap getTestInput3TopographicMap() {
        Map<Position, Integer> heightMap = new HashMap<>();
        heightMap.put(new Position(0, 2), 9);
        heightMap.put(new Position(0, 3), 0);
        heightMap.put(new Position(0, 6), 9);
        heightMap.put(new Position(1, 3), 1);
        heightMap.put(new Position(1, 5), 9);
        heightMap.put(new Position(1, 6), 8);
        heightMap.put(new Position(2, 3), 2);
        heightMap.put(new Position(2, 6), 7);
        heightMap.put(new Position(3, 0), 6);
        heightMap.put(new Position(3, 1), 5);
        heightMap.put(new Position(3, 2), 4);
        heightMap.put(new Position(3, 3), 3);
        heightMap.put(new Position(3, 4), 4);
        heightMap.put(new Position(3, 5), 5);
        heightMap.put(new Position(3, 6), 6);
        heightMap.put(new Position(4, 0), 7);
        heightMap.put(new Position(4, 1), 6);
        heightMap.put(new Position(4, 2), 5);
        heightMap.put(new Position(4, 4), 9);
        heightMap.put(new Position(4, 5), 8);
        heightMap.put(new Position(4, 6), 7);
        heightMap.put(new Position(5, 0), 8);
        heightMap.put(new Position(5, 1), 7);
        heightMap.put(new Position(5, 2), 6);
        heightMap.put(new Position(6, 0), 9);
        heightMap.put(new Position(6, 1), 8);
        heightMap.put(new Position(6, 2), 7);

        return new TopographicMap(heightMap);
    }

    public static TopographicMap getTestInput4TopographicMap() {
        Map<Position, Integer> heightMap = new HashMap<>();
        heightMap.put(new Position(0, 0), 1);
        heightMap.put(new Position(0, 1), 0);
        heightMap.put(new Position(0, 4), 9);
        heightMap.put(new Position(1, 0), 2);
        heightMap.put(new Position(1, 4), 8);
        heightMap.put(new Position(2, 0), 3);
        heightMap.put(new Position(2, 4), 7);
        heightMap.put(new Position(3, 0), 4);
        heightMap.put(new Position(3, 1), 5);
        heightMap.put(new Position(3, 2), 6);
        heightMap.put(new Position(3, 3), 7);
        heightMap.put(new Position(3, 4), 6);
        heightMap.put(new Position(3, 5), 5);
        heightMap.put(new Position(3, 6), 4);
        heightMap.put(new Position(4, 3), 8);
        heightMap.put(new Position(4, 6), 3);
        heightMap.put(new Position(5, 3), 9);
        heightMap.put(new Position(5, 6), 2);
        heightMap.put(new Position(6, 5), 0);
        heightMap.put(new Position(6, 6), 1);

        return new TopographicMap(heightMap);
    }

    public static TopographicMap getTestInput5TopographicMap() {
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

        return new TopographicMap(heightMap);
    }

    public static TopographicMap getTestInput6TopographicMap() {
        Map<Position, Integer> heightMap = new HashMap<>();
        heightMap.put(new Position(0, 5), 0);
        heightMap.put(new Position(1, 2), 4);
        heightMap.put(new Position(1, 3), 3);
        heightMap.put(new Position(1, 4), 2);
        heightMap.put(new Position(1, 5), 1);
        heightMap.put(new Position(2, 2), 5);
        heightMap.put(new Position(2, 5), 2);
        heightMap.put(new Position(3, 2), 6);
        heightMap.put(new Position(3, 3), 5);
        heightMap.put(new Position(3, 4), 4);
        heightMap.put(new Position(3, 5), 3);
        heightMap.put(new Position(4, 2), 7);
        heightMap.put(new Position(4, 5), 4);
        heightMap.put(new Position(5, 2), 8);
        heightMap.put(new Position(5, 3), 7);
        heightMap.put(new Position(5, 4), 6);
        heightMap.put(new Position(5, 5), 5);
        heightMap.put(new Position(6, 2), 9);

        return new TopographicMap(heightMap);
    }

    public static TopographicMap getTestInput7TopographicMap() {
        Map<Position, Integer> heightMap = new HashMap<>();
        heightMap.put(new Position(0, 0), 0);
        heightMap.put(new Position(0, 1), 1);
        heightMap.put(new Position(0, 2), 2);
        heightMap.put(new Position(0, 3), 3);
        heightMap.put(new Position(0, 4), 4);
        heightMap.put(new Position(0, 5), 5);
        heightMap.put(new Position(1, 0), 1);
        heightMap.put(new Position(1, 1), 2);
        heightMap.put(new Position(1, 2), 3);
        heightMap.put(new Position(1, 3), 4);
        heightMap.put(new Position(1, 4), 5);
        heightMap.put(new Position(1, 5), 6);
        heightMap.put(new Position(2, 0), 2);
        heightMap.put(new Position(2, 1), 3);
        heightMap.put(new Position(2, 2), 4);
        heightMap.put(new Position(2, 3), 5);
        heightMap.put(new Position(2, 4), 6);
        heightMap.put(new Position(2, 5), 7);
        heightMap.put(new Position(3, 0), 3);
        heightMap.put(new Position(3, 1), 4);
        heightMap.put(new Position(3, 2), 5);
        heightMap.put(new Position(3, 3), 6);
        heightMap.put(new Position(3, 4), 7);
        heightMap.put(new Position(3, 5), 8);
        heightMap.put(new Position(4, 0), 4);
        heightMap.put(new Position(4, 2), 6);
        heightMap.put(new Position(4, 3), 7);
        heightMap.put(new Position(4, 4), 8);
        heightMap.put(new Position(4, 5), 9);
        heightMap.put(new Position(5, 0), 5);
        heightMap.put(new Position(5, 1), 6);
        heightMap.put(new Position(5, 2), 7);
        heightMap.put(new Position(5, 3), 8);
        heightMap.put(new Position(5, 4), 9);

        return new TopographicMap(heightMap);
    }
}
