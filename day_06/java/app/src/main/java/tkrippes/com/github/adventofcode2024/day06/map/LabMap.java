package tkrippes.com.github.adventofcode2024.day06.map;

import java.util.Map;

public record LabMap(Map<Position, Boolean> obstacleMap, Guard guard) {
}
