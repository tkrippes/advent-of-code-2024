package tkrippes.com.github.adventofcode2024.day08;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public record AntennaMap(Map<Position, Character> frequencyMap, int mapWidth, int mapHeight) {
    public Set<Character> getFrequencies() {
        return new HashSet<>(frequencyMap.values());
    }

    public Set<Position> getFrequencyPositions(char frequency) {
        return frequencyMap.entrySet().stream()
                .filter(frequencyEntry -> frequencyEntry.getValue() == frequency)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public boolean isInBounds(Position position) {
        return position.row() >= 0 && position.row() < mapHeight &&
                position.column() >= 0 && position.column() < mapWidth;
    }
}
