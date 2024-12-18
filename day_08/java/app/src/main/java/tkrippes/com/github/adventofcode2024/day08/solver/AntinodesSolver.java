package tkrippes.com.github.adventofcode2024.day08.solver;

import tkrippes.com.github.adventofcode2024.day08.AntennaMap;
import tkrippes.com.github.adventofcode2024.day08.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AntinodesSolver {
    public static int solve(AntennaMap map) {
        return (int) map.getFrequencies().stream()
                .flatMap(frequency -> Position.getPositionsPairCombinations(map.getFrequencyPositions(frequency)).stream())
                .flatMap(frequencyPositionPair -> {
                    List<Position> frequencyPositionPairList = List.copyOf(frequencyPositionPair);
                    return getAntinodesPositions(frequencyPositionPairList.get(0), frequencyPositionPairList.get(1)).stream();
                }).filter(map::isInBounds).distinct().count();
    }

    static Set<Position> getAntinodesPositions(Position antennaPosition1, Position antennaPosition2) {
        Position vectorFromAntenna1ToAntenna2 = antennaPosition2.subtract(antennaPosition1);

        Set<Position> antinodesPositions = new HashSet<>();
        antinodesPositions.add(antennaPosition1.subtract(vectorFromAntenna1ToAntenna2));
        antinodesPositions.add(antennaPosition2.add(vectorFromAntenna1ToAntenna2));

        return antinodesPositions;
    }
}
