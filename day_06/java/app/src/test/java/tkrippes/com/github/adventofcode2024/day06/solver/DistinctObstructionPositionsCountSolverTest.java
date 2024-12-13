package tkrippes.com.github.adventofcode2024.day06.solver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tkrippes.com.github.adventofcode2024.day06.map.Guard;
import tkrippes.com.github.adventofcode2024.day06.map.LabMap;
import tkrippes.com.github.adventofcode2024.day06.map.Position;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistinctObstructionPositionsCountSolverTest {
    private DistinctObstructionPositionsCountSolver solver;

    @BeforeEach
    public void setUp() {
        solver = new DistinctObstructionPositionsCountSolver();
    }

    @Test
    public void getNextRightObstaclePositionReturnsEmptyForNoObstacleWhenGuardIsFacingUp() {
        Map<Position, Boolean> obstacleMap = new HashMap<>();
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                obstacleMap.put(new Position(row, column), false);
            }
        }

        assertEquals(Optional.empty(), solver.getNextRightObstaclePosition(new LabMap(obstacleMap,
                new Guard(new Position(2, 2), Guard.Orientation.UP))));
    }

    @Test
    public void getNextRightObstaclePositionReturnsEmptyForNoObstacleWhenGuardIsFacingRight() {
        Map<Position, Boolean> obstacleMap = new HashMap<>();
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                obstacleMap.put(new Position(row, column), false);
            }
        }

        assertEquals(Optional.empty(), solver.getNextRightObstaclePosition(new LabMap(obstacleMap,
                new Guard(new Position(2, 2), Guard.Orientation.RIGHT))));
    }

    @Test
    public void getNextRightObstaclePositionReturnsEmptyForNoObstacleWhenGuardIsFacingDown() {
        Map<Position, Boolean> obstacleMap = new HashMap<>();
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                obstacleMap.put(new Position(row, column), false);
            }
        }

        assertEquals(Optional.empty(), solver.getNextRightObstaclePosition(new LabMap(obstacleMap,
                new Guard(new Position(2, 2), Guard.Orientation.DOWN))));
    }

    @Test
    public void getNextRightObstaclePositionReturnsEmptyForNoObstacleWhenGuardIsFacingLeft() {
        Map<Position, Boolean> obstacleMap = new HashMap<>();
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                obstacleMap.put(new Position(row, column), false);
            }
        }

        assertEquals(Optional.empty(), solver.getNextRightObstaclePosition(new LabMap(obstacleMap,
                new Guard(new Position(2, 2), Guard.Orientation.LEFT))));
    }

    @Test
    public void getNextRightObstaclePositionReturnsObstaclePositionForObstacleWhenGuardIsFacingUp() {
        Map<Position, Boolean> obstacleMap = new HashMap<>();
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                obstacleMap.put(new Position(row, column), false);
            }
        }

        obstacleMap.put(new Position(2, 4), true);

        assertEquals(Optional.of(new Position(2, 4)), solver.getNextRightObstaclePosition(new LabMap(obstacleMap,
                new Guard(new Position(2, 2), Guard.Orientation.UP))));
    }

    @Test
    public void getNextRightObstaclePositionReturnsObstaclePositionForObstacleWhenGuardIsFacingRight() {
        Map<Position, Boolean> obstacleMap = new HashMap<>();
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                obstacleMap.put(new Position(row, column), false);
            }
        }

        obstacleMap.put(new Position(3, 2), true);

        assertEquals(Optional.of(new Position(3, 2)), solver.getNextRightObstaclePosition(new LabMap(obstacleMap,
                new Guard(new Position(2, 2), Guard.Orientation.RIGHT))));
    }

    @Test
    public void getNextRightObstaclePositionReturnsObstaclePositionForObstacleWhenGuardIsFacingDown() {
        Map<Position, Boolean> obstacleMap = new HashMap<>();
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                obstacleMap.put(new Position(row, column), false);
            }
        }

        obstacleMap.put(new Position(2, 0), true);

        assertEquals(Optional.of(new Position(2, 0)), solver.getNextRightObstaclePosition(new LabMap(obstacleMap,
                new Guard(new Position(2, 2), Guard.Orientation.DOWN))));
    }

    @Test
    public void getNextRightObstaclePositionReturnsObstaclePositionForObstacleWhenGuardIsFacingLeft() {
        Map<Position, Boolean> obstacleMap = new HashMap<>();
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                obstacleMap.put(new Position(row, column), false);
            }
        }

        obstacleMap.put(new Position(1, 2), true);

        assertEquals(Optional.of(new Position(1, 2)), solver.getNextRightObstaclePosition(new LabMap(obstacleMap,
                new Guard(new Position(2, 2), Guard.Orientation.LEFT))));
    }

//    @Test
//    public void solveShouldReturnTheCorrectResultForTestInputFileContent() {
//        Map<Position, Boolean> obstacleMap = new HashMap<>();
//        for (int row = 0; row < 10; row++) {
//            for (int column = 0; column < 10; column++) {
//                obstacleMap.put(new Position(row, column), false);
//            }
//        }
//
//        obstacleMap.put(new Position(0, 4), true);
//        obstacleMap.put(new Position(1, 9), true);
//        obstacleMap.put(new Position(3, 2), true);
//        obstacleMap.put(new Position(4, 7), true);
//        obstacleMap.put(new Position(6, 1), true);
//        obstacleMap.put(new Position(7, 8), true);
//        obstacleMap.put(new Position(8, 0), true);
//        obstacleMap.put(new Position(9, 6), true);
//
//        LabMap map = new LabMap(obstacleMap, new Guard(new Position(6, 4)));
//
//        assertEquals(6, solver.solve(map));
//    }

    @AfterEach
    public void tearDown() {
    }
}
