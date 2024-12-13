package tkrippes.com.github.adventofcode2024.day06.solver;

import tkrippes.com.github.adventofcode2024.day06.map.Guard;
import tkrippes.com.github.adventofcode2024.day06.map.LabMap;
import tkrippes.com.github.adventofcode2024.day06.map.Position;

import java.util.*;

public class DistinctObstructionPositionsCountSolver implements LabMapSolver {
    public int solve(LabMap map) {
        Map<Position, Set<Guard.Orientation>> obstaclesBumpedIntoMap = new HashMap<>();
        Set<Position> distinctObstructionPositions = new HashSet<>();
        distinctObstructionPositions.add(map.guard().getPosition());
        while (map.obstacleMap().containsKey(map.guard().getNextPosition())) {
            if (map.obstacleMap().get(map.guard().getNextPosition())) {
                obstaclesBumpedIntoMap.putIfAbsent(map.guard().getNextPosition(), new HashSet<>());
                obstaclesBumpedIntoMap.get(map.guard().getNextPosition()).add(map.guard().getOrientation());

                map.guard().turnRight();
                continue;
            }

            map.guard().move();
            // TODO
            Optional<Position> nextObstacle = getNextRightObstaclePosition(map);
            if (nextObstacle.isEmpty()) {
                System.err.println("No next obstacle found for guard position: " + map.guard().getPosition() + " and " +
                        "orientation: " + map.guard().getOrientation());
            } else {
                System.err.println("Next obstacle found for guard position: " + map.guard().getPosition() + " and " +
                        "orientation: " + map.guard().getOrientation() + " is: " + nextObstacle.get());
            }

            distinctObstructionPositions.add(map.guard().getPosition());
        }

        return distinctObstructionPositions.size();
    }

    Optional<Position> getNextRightObstaclePosition(LabMap map) {
        Guard guard = new Guard(map.guard().getPosition(), map.guard().getOrientation());
        guard.turnRight();

        while (map.obstacleMap().containsKey(guard.getNextPosition())) {
            if (map.obstacleMap().get(guard.getNextPosition())) {
                return Optional.of(guard.getNextPosition());
            }

            guard.move();
        }

        return Optional.empty();
    }
}