package tkrippes.com.github.adventofcode2024.day10.Main;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TopographicMap {
    private final int trailheadValue = 0;
    private final int trailEndValue = 9;

    private final Map<Position, Integer> heightMap;
    private final int mapWidth;
    private final int mapHeight;

    public TopographicMap(Map<Position, Integer> heightMap, int mapWidth, int mapHeight) {
        this.heightMap = heightMap;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    public Set<Position> getTrailheadPositions() {
        return heightMap.entrySet().stream()
                .filter(e -> e.getValue() == trailheadValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public Set<Position> getTrailEndPositions() {
        return heightMap.entrySet().stream()
                .filter(e -> e.getValue() == trailEndValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        TopographicMap other = (TopographicMap) obj;

        return heightMap.equals(other.heightMap) && mapWidth == other.mapWidth && mapHeight == other.mapHeight;
    }
}
