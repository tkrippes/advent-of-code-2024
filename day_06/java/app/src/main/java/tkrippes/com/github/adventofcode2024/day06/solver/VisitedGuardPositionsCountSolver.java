package tkrippes.com.github.adventofcode2024.day06.solver;

import tkrippes.com.github.adventofcode2024.day06.map.Guard;
import tkrippes.com.github.adventofcode2024.day06.map.LabMap;
import tkrippes.com.github.adventofcode2024.day06.map.Position;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VisitedGuardPositionsCountSolver implements LabMapSolver {
    public int solve(LabMap map) {
        Map<Position, Boolean> obstacleMap = map.obstacleMap();
        Guard guard = map.guard();
        Set<Position> visitedGuardPositions = new HashSet<>();
        visitedGuardPositions.add(guard.getPosition());

        while (obstacleMap.containsKey(guard.getNextPosition())) {
            if (obstacleMap.get(guard.getNextPosition())) {
                guard.turnRight();
                continue;
            }

            guard.move();
            visitedGuardPositions.add(guard.getPosition());
        }

        return visitedGuardPositions.size();
    }
}
