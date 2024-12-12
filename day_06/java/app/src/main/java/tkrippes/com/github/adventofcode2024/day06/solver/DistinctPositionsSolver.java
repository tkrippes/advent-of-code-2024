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

    // TODO hints for part 2
    // create map of already "bumped into" obstacles including the information from which side (Map<Position,
    // List<Orientation>>)
    // for every move, check if turning right would lead to bumping into an already "bumped into" obstacle from the
    // correct side
    // add new obstacle (unique set, since it could result in obstacles)
    // create new solver (ObstaclePositionSolver or similar)
    // add getNextOrientation method to Guard
    // add nextObstacle method to solver (call getNextPosition until hitting an obstacle or leaving map)
}
