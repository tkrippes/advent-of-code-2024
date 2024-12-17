package tkrippes.com.github.adventofcode2024.day08;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public record AntennaMap(Map<Position, Character> map, int width, int height) {
    public Set<Character> getAntennaFrequencies() {
        return new HashSet<>(map.values());
    }

    public Set<Position> getAntennaFrequencyPositions(char antennaFrequency) {
        return map.entrySet().stream()
                .filter(frequency -> frequency.getValue() == antennaFrequency)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}
