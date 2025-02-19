package tkrippes.com.github.adventofcode2024.day10;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TopographicMap {
    private final Map<Position, Integer> heightMap;

    public TopographicMap(Map<Position, Integer> heightMap) {
        this.heightMap = heightMap;
    }

    public int getHeight(Position position) {
        return heightMap.getOrDefault(position, -1);
    }

    public Set<Position> getTrailheadPositions() {
        return getPositions(0);
    }

    public Set<Position> getTrailEndPositions() {
        return getPositions(9);
    }

    private Set<Position> getPositions(int height) {
        return heightMap.entrySet().stream()
                .filter(e -> e.getValue() == height)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public Set<Map.Entry<Position, Integer>> getNeighbours(Position position) {
        Position upperNeighbourPosition = new Position(position.row() - 1, position.column());
        Position leftNeighbourPosition = new Position(position.row(), position.column() - 1);
        Position rightNeighbourPosition = new Position(position.row(), position.column() + 1);
        Position lowerNeighbourPosition = new Position(position.row() + 1, position.column());

        return heightMap.entrySet().stream().filter(e -> {
            Position neighbourPosition = e.getKey();

            return neighbourPosition.equals(upperNeighbourPosition) || neighbourPosition.equals(leftNeighbourPosition) ||
                    neighbourPosition.equals(rightNeighbourPosition) || neighbourPosition.equals(lowerNeighbourPosition);
        }).collect(Collectors.toSet());
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

        return heightMap.equals(other.heightMap);
    }
}
