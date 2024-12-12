package tkrippes.com.github.adventofcode2024.day06.solver;

import tkrippes.com.github.adventofcode2024.day06.map.LabMap;
import tkrippes.com.github.adventofcode2024.day06.map.Position;

import java.util.HashSet;
import java.util.Set;

public class DistinctPositionsSolver {
    public int solve(LabMap map) {
        Set<Position> distinctPositions = new HashSet<>();
        distinctPositions.add(map.guard().getPosition());

        do {
            if (map.obstacleMap().get(map.guard().getNextPosition())) {
                map.guard().turnRight();
            } else {
                map.guard().move();
            }

            distinctPositions.add(map.guard().getPosition());
        } while (map.obstacleMap().containsKey(map.guard().getNextPosition()));

        return distinctPositions.size();
    }
}
