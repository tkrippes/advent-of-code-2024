package tkrippes.com.github.adventofcode2024.day06.solver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tkrippes.com.github.adventofcode2024.day06.map.Guard;
import tkrippes.com.github.adventofcode2024.day06.map.LabMap;
import tkrippes.com.github.adventofcode2024.day06.map.Position;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistinctObstructionPositionsCountSolverTest {
    private DistinctObstructionPositionsCountSolver solver;

    @BeforeEach
    public void setUp() {
        solver = new DistinctObstructionPositionsCountSolver();
    }

    @Test
    public void solveShouldReturnTheCorrectResultForTestInputFileContent() {
        Map<Position, Boolean> obstacleMap = new HashMap<>();
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                obstacleMap.put(new Position(row, column), false);
            }
        }

        obstacleMap.put(new Position(0, 4), true);
        obstacleMap.put(new Position(1, 9), true);
        obstacleMap.put(new Position(3, 2), true);
        obstacleMap.put(new Position(4, 7), true);
        obstacleMap.put(new Position(6, 1), true);
        obstacleMap.put(new Position(7, 8), true);
        obstacleMap.put(new Position(8, 0), true);
        obstacleMap.put(new Position(9, 6), true);

        LabMap map = new LabMap(obstacleMap, new Guard(new Position(6, 4)));

        assertEquals(6, solver.solve(map));
    }

    @AfterEach
    public void tearDown() {
    }
}
