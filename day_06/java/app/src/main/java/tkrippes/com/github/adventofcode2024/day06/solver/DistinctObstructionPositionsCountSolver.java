package tkrippes.com.github.adventofcode2024.day06.solver;

import tkrippes.com.github.adventofcode2024.day06.map.Guard;
import tkrippes.com.github.adventofcode2024.day06.map.LabMap;
import tkrippes.com.github.adventofcode2024.day06.map.Position;

import java.util.*;

public class DistinctObstructionPositionsCountSolver implements LabMapSolver {
    public int solve(LabMap map) {
        Map<Position, Boolean> obstacleMap = map.obstacleMap();
        Guard guard = map.guard();

        Set<Position> visitedGuardPositions = new HashSet<>();
        visitedGuardPositions.add(guard.getPosition());
        Guard visitorGuard = new Guard(guard);
        while (obstacleMap.containsKey(visitorGuard.getNextPosition())) {
            if (obstacleMap.get(visitorGuard.getNextPosition())) {
                visitorGuard.turnRight();
                continue;
            }

            visitorGuard.move();
            visitedGuardPositions.add(visitorGuard.getPosition());
        }

        int distinctObstructionPositionsCount = 0;
        for (Position position : visitedGuardPositions) {
            Map<Position, Boolean> newObstacleMap = new HashMap<>(obstacleMap);
            newObstacleMap.put(position, true);

            if (isGuardStuckInALoop(newObstacleMap, new Guard(guard))) {
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

            if (guardAlreadyVisitedPosition(guard, distinctGuardPositionsAndOrientations)) {
                return true;
            }

            distinctGuardPositionsAndOrientations.putIfAbsent(guard.getPosition(), new HashSet<>());
            distinctGuardPositionsAndOrientations.get(guard.getPosition()).add(guard.getOrientation());
        }

        return false;
    }

    private static boolean guardAlreadyVisitedPosition(Guard guard, Map<Position,
            Set<Guard.Orientation>> distinctGuardPositionsAndOrientations) {
        Position position = guard.getPosition();
        Guard.Orientation orientation = guard.getOrientation();

        return distinctGuardPositionsAndOrientations.containsKey(position) &&
                distinctGuardPositionsAndOrientations.get(position).contains(orientation);
    }
}