package tkrippes.com.github.adventofcode2024.day06.solver;

import tkrippes.com.github.adventofcode2024.day06.map.LabMap;
import tkrippes.com.github.adventofcode2024.day06.map.Position;

import java.util.HashSet;
import java.util.Set;

public class DistinctGuardPositionsCountSolver implements LabMapSolver {
    public int solve(LabMap map) {
        Set<Position> distinctGuardPositions = new HashSet<>();
        distinctGuardPositions.add(map.guard().getPosition());
        // TODO check if this can be reused in an abstract base class
        // TODO template method using abstract method getting called in loop
        while (map.obstacleMap().containsKey(map.guard().getNextPosition())) {
            if (map.obstacleMap().get(map.guard().getNextPosition())) {
                map.guard().turnRight();
                continue;
            }

            map.guard().move();
            distinctGuardPositions.add(map.guard().getPosition());
        }

        return distinctGuardPositions.size();
    }
}
