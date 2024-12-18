package tkrippes.com.github.adventofcode2024.day08.solver;

import tkrippes.com.github.adventofcode2024.day08.Position;

import java.util.HashSet;
import java.util.Set;

public class AntinodesSolver {
    static Set<Position> getAntinodesPositions(Position antennaPosition1, Position antennaPosition2) {
        Position vectorFromAntenna1ToAntenna2 = antennaPosition2.subtract(antennaPosition1);

        Set<Position> antinodesPositions = new HashSet<>();
        antinodesPositions.add(antennaPosition1.subtract(vectorFromAntenna1ToAntenna2));
        antinodesPositions.add(antennaPosition2.add(vectorFromAntenna1ToAntenna2));

        return antinodesPositions;
    }
}
