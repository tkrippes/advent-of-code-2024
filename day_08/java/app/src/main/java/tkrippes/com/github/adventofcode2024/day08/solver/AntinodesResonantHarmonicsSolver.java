package tkrippes.com.github.adventofcode2024.day08.solver;

import tkrippes.com.github.adventofcode2024.day08.AntennaMap;
import tkrippes.com.github.adventofcode2024.day08.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AntinodesResonantHarmonicsSolver {
    public static int solve(AntennaMap map) {
        return (int) map.getFrequencies().stream()
                .flatMap(frequency -> Position.getPositionsPairCombinations(map.getFrequencyPositions(frequency)).stream())
                .flatMap(frequencyPositionPair -> {
                    List<Position> frequencyPositionPairList = List.copyOf(frequencyPositionPair);
                    return getAntinodePositions(map, frequencyPositionPairList.get(0),
                            frequencyPositionPairList.get(1)).stream();
                }).distinct().count();
    }

    static Set<Position> getAntinodePositions(AntennaMap map, Position antennaPosition1, Position antennaPosition2) {
        Position antenna1ToAntenna2Vector = antennaPosition2.subtract(antennaPosition1);

        Set<Position> antinodePositions = new HashSet<>();
        antinodePositions.addAll(getAntinodesPositionsWithDirection(map, antennaPosition1,
                antenna1ToAntenna2Vector.negate()));
        antinodePositions.addAll(getAntinodesPositionsWithDirection(map, antennaPosition2,
                antenna1ToAntenna2Vector));

        return antinodePositions;
    }

    private static Set<Position> getAntinodesPositionsWithDirection(AntennaMap map, Position startPosition,
                                                                    Position directionVector) {
        Set<Position> antinodesPositions = new HashSet<>();

        Position antinodePosition = startPosition;
        do {
            antinodesPositions.add(antinodePosition);
            antinodePosition = antinodePosition.add(directionVector);
        } while (map.isInBounds(antinodePosition));

        return antinodesPositions;
    }
}
