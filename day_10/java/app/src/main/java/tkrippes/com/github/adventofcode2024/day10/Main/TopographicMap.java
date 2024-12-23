package tkrippes.com.github.adventofcode2024.day10.Main;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TopographicMap {
    private final int trailheadValue = 0;
    private final int trailEndValue = 9;
    private final Map<Position, Integer> map;

    public TopographicMap(Map<Position, Integer> map) {
        this.map = map;
    }

    public Set<Position> getTrailheadPositions() {
        return map.entrySet().stream()
                .filter(e -> e.getValue() == trailheadValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public Set<Position> getTrailEndPositions() {
        return map.entrySet().stream()
                .filter(e -> e.getValue() == trailEndValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}
