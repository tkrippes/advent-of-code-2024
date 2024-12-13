package tkrippes.com.github.adventofcode2024.day06.solver;

import tkrippes.com.github.adventofcode2024.day06.map.Guard;
import tkrippes.com.github.adventofcode2024.day06.map.LabMap;
import tkrippes.com.github.adventofcode2024.day06.map.Position;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DistinctGuardPositionsCountSolver implements LabMapSolver {
    public int solve(LabMap map) {
        Map<Position, Boolean> obstacleMap = map.obstacleMap();
        Guard guard = map.guard();
        Set<Position> distinctGuardPositions = new HashSet<>();
        distinctGuardPositions.add(guard.getPosition());

        while (obstacleMap.containsKey(guard.getNextPosition())) {
            if (obstacleMap.get(guard.getNextPosition())) {
                guard.turnRight();
                continue;
            }

            guard.move();
            distinctGuardPositions.add(guard.getPosition());
        }

        return distinctGuardPositions.size();
    }
}
