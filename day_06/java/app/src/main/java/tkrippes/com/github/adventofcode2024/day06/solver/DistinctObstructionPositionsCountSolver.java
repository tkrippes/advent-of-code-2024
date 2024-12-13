package tkrippes.com.github.adventofcode2024.day06.solver;

import tkrippes.com.github.adventofcode2024.day06.map.Guard;
import tkrippes.com.github.adventofcode2024.day06.map.LabMap;
import tkrippes.com.github.adventofcode2024.day06.map.Position;

import java.util.*;

public class DistinctObstructionPositionsCountSolver implements LabMapSolver {
    public int solve(LabMap map) {
        Set<Position> distinctObstructionPositions = new HashSet<>();
        while (map.obstacleMap().containsKey(map.guard().getNextPosition())) {
            if (map.obstacleMap().get(map.guard().getNextPosition())) {
                map.guard().turnRight();
                continue;
            }

            LabMap newMap = new LabMap(new HashMap<>(map.obstacleMap()), new Guard(map.guard().getPosition(),
                    map.guard().getOrientation()));
            newMap.obstacleMap().put(map.guard().getNextPosition(), true);
            if (isGuardStuckInALoop(newMap)) {
                distinctObstructionPositions.add(map.guard().getNextPosition());
            }

            map.guard().move();
        }

        return distinctObstructionPositions.size();
    }

    boolean isGuardStuckInALoop(LabMap map) {
        Map<Position, Set<Guard.Orientation>> distinctGuardPositionsAndOrientations = new HashMap<>();
        while (map.obstacleMap().containsKey(map.guard().getNextPosition())) {
            if (map.obstacleMap().get(map.guard().getNextPosition())) {
                map.guard().turnRight();
                continue;
            }

            map.guard().move();

            if (distinctGuardPositionsAndOrientations.containsKey(map.guard().getPosition()) &&
                    distinctGuardPositionsAndOrientations.get(map.guard().getPosition()).contains(map.guard().getOrientation())) {
                return true;
            }

            distinctGuardPositionsAndOrientations.putIfAbsent(map.guard().getPosition(), new HashSet<>());
            distinctGuardPositionsAndOrientations.get(map.guard().getPosition()).add(map.guard().getOrientation());
        }

        return false;
    }
}