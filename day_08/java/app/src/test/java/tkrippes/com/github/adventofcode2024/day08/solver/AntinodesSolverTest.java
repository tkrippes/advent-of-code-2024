package tkrippes.com.github.adventofcode2024.day08.solver;

import tkrippes.com.github.adventofcode2024.day08.AntennaMap;
import tkrippes.com.github.adventofcode2024.day08.Position;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AntinodesSolverTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void getAntinodesPositionsFromTwoOverlappingAntennasShouldReturnTheSamePosition() {
        assertEquals(Set.of(new Position(3, 3)), AntinodesSolver.getAntinodesPositions(new Position(3, 3),
                new Position(3, 3)));
    }

    @Test
    public void getAntinodesPositionsFromTwoHorizontallyAdjacentAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(3, 2), new Position(3, 5)),
                AntinodesSolver.getAntinodesPositions(new Position(3, 3),
                        new Position(3, 4)));
    }

    @Test
    public void getAntinodesPositionsFromTwoHorizontallyAdjacentReversedAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(3, 2), new Position(3, 5)),
                AntinodesSolver.getAntinodesPositions(new Position(3, 4),
                        new Position(3, 3)));
    }

    @Test
    public void getAntinodesPositionsFromTwoVerticallyAdjacentAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(2, 3), new Position(5, 3)),
                AntinodesSolver.getAntinodesPositions(new Position(3, 3),
                        new Position(4, 3)));
    }

    @Test
    public void getAntinodesPositionsFromTwoVerticallyAdjacentReversedAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(2, 3), new Position(5, 3)),
                AntinodesSolver.getAntinodesPositions(new Position(4, 3),
                        new Position(3, 3)));
    }

    @Test
    public void getAntinodesPositionsFromTwoPrimaryDiagonallyAdjacentAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(2, 2), new Position(5, 5)),
                AntinodesSolver.getAntinodesPositions(new Position(3, 3),
                        new Position(4, 4)));
    }

    @Test
    public void getAntinodesPositionsFromTwoPrimaryDiagonallyAdjacentReversedAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(2, 2), new Position(5, 5)),
                AntinodesSolver.getAntinodesPositions(new Position(4, 4),
                        new Position(3, 3)));
    }

    @Test
    public void
    getAntinodesPositionsFromTwoSecondaryDiagonallyAdjacentAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(5, 1), new Position(2, 4)),
                AntinodesSolver.getAntinodesPositions(new Position(3, 3),
                        new Position(4, 2)));
    }

    @Test
    public void
    getAntinodesPositionsFromTwoSecondaryDiagonallyAdjacentReversedAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(5, 1), new Position(2, 4)),
                AntinodesSolver.getAntinodesPositions(new Position(4, 2),
                        new Position(3, 3)));
    }

    @Test
    public void getAntinodesPositionsFromTwoAntennasWithDifferentCoordinatesShouldReturnTheTwoCorrectAntinodes() {
        assertEquals(Set.of(new Position(6, 17), new Position(12, -7)),
                AntinodesSolver.getAntinodesPositions(new Position(8, 9),
                        new Position(10, 1)));
    }

    @Test
    public void solveForTestInputShouldReturnCorrectly() {
        AntennaMap antennaMap = new AntennaMap(Map.of(
                new Position(1, 8), '0',
                new Position(2, 5), '0',
                new Position(3, 7), '0',
                new Position(4, 4), '0',
                new Position(5, 6), 'A',
                new Position(8, 8), 'A',
                new Position(9, 9), 'A'), 12, 12);

        assertEquals(14, AntinodesSolver.solve(antennaMap));
    }

    // TODO add input tests

    @AfterEach
    public void tearDown() {
    }
}
