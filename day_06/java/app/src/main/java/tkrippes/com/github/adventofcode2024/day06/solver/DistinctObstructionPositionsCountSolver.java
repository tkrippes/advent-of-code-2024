package tkrippes.com.github.adventofcode2024.day06.solver;

import tkrippes.com.github.adventofcode2024.day06.map.Guard;
import tkrippes.com.github.adventofcode2024.day06.map.LabMap;
import tkrippes.com.github.adventofcode2024.day06.map.Position;

import java.util.*;

public class DistinctObstructionPositionsCountSolver implements LabMapSolver {
    public int solve(LabMap map) {
        Map<Position, Boolean> obstacleMap = map.obstacleMap();
        Guard guard = map.guard();
        int distinctObstructionPositionsCount = 0;

        for (Position position : obstacleMap.keySet()) {
            Map<Position, Boolean> newObstacleMap = new HashMap<>(obstacleMap);
            newObstacleMap.put(position, true);

            if (isGuardStuckInALoop(newObstacleMap, new Guard(guard.getPosition(),
                    guard.getOrientation()))) {
                distinctObstructionPositionsCount++;
            }
        }

        return distinctObstructionPositionsCount;
    }

    boolean isGuardStuckInALoop(Map<Position, Boolean> obstacleMap, Guard guard) {
        Map<Position, Set<Guard.Orientation>> distinctGuardPositionsAndOrientations = new HashMap<>();
        while (obstacleMap.containsKey(guard.getNextPosition())) {
            if (obstacleMap.get(guard.getNextPosition())) {
                guard.turnRight();
                continue;
            }

            guard.move();

            if (distinctGuardPositionsAndOrientations.containsKey(guard.getPosition()) &&
                    distinctGuardPositionsAndOrientations.get(guard.getPosition()).contains(guard.getOrientation())) {
                return true;
            }

            distinctGuardPositionsAndOrientations.putIfAbsent(guard.getPosition(), new HashSet<>());
            distinctGuardPositionsAndOrientations.get(guard.getPosition()).add(guard.getOrientation());
        }

        return false;
    }
}