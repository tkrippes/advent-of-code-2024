package tkrippes.com.github.adventofcode2024.day06.solver;

import tkrippes.com.github.adventofcode2024.day06.map.LabMap;


public class VisitedGuardPositionsCountSolver extends LabMapSolver {
    public int solve(LabMap map) {
        return getVisitedGuardPositions(map.obstacleMap(), map.guard()).size();
    }
}
