package tkrippes.com.github.adventofcode2024.day08;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Position(int row, int column) {
    public Position add(Position otherPosition) {
        return new Position(row + otherPosition.row(), column + otherPosition.column());
    }

    public Position subtract(Position otherPosition) {
        return new Position(row - otherPosition.row(), column - otherPosition.column());
    }

    public Position negate() {
        return new Position(-row, -column);
    }

    public static Set<Set<Position>> getPositionsPairCombinations(Set<Position> positions) {
        List<Position> positionsList = List.copyOf(positions);
        Set<Set<Position>> positionsPairCombinations = new HashSet<>();
        for (int i = 0; i < positionsList.size(); i++) {
            for (int j = i + 1; j < positionsList.size(); j++) {
                positionsPairCombinations.add(Set.of(positionsList.get(i), positionsList.get(j)));
            }
        }

        return positionsPairCombinations;
    }
}
