package tkrippes.com.github.adventofcode2024.day08.solver;

import tkrippes.com.github.adventofcode2024.day08.Position;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AntinodesSolverTest {
    private AntinodesSolver solver;

    @BeforeEach
    public void setUp() {
        solver = new AntinodesSolver();
    }

    @Test
    public void getAntinodesPositionsFromTwoOverlappingAntennasShouldReturnTheSamePosition() {
        assertEquals(Set.of(new Position(3, 3)), solver.getAntinodesPositions(new Position(3, 3), new Position(3, 3)));
    }

    @Test
    public void getAntinodesPositionsFromTwoHorizontallyAdjacentAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(3, 2), new Position(3, 5)), solver.getAntinodesPositions(new Position(3, 3),
                new Position(3, 4)));
    }

    @Test
    public void getAntinodesPositionsFromTwoHorizontallyAdjacentReversedAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(3, 2), new Position(3, 5)), solver.getAntinodesPositions(new Position(3, 4),
                new Position(3, 3)));
    }

    @Test
    public void getAntinodesPositionsFromTwoVerticallyAdjacentAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(2, 3), new Position(5, 3)), solver.getAntinodesPositions(new Position(3, 3),
                new Position(4, 3)));
    }

    @Test
    public void getAntinodesPositionsFromTwoVerticallyAdjacentReversedAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(2, 3), new Position(5, 3)), solver.getAntinodesPositions(new Position(4, 3),
                new Position(3, 3)));
    }

    @Test
    public void getAntinodesPositionsFromTwoPrimaryDiagonallyAdjacentAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(2, 2), new Position(5, 5)), solver.getAntinodesPositions(new Position(3, 3),
                new Position(4, 4)));
    }

    @Test
    public void getAntinodesPositionsFromTwoPrimaryDiagonallyAdjacentReversedAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(2, 2), new Position(5, 5)), solver.getAntinodesPositions(new Position(4, 4),
                new Position(3, 3)));
    }

    @Test
    public void
    getAntinodesPositionsFromTwoSecondaryDiagonallyAdjacentAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(5, 1), new Position(2, 4)), solver.getAntinodesPositions(new Position(3, 3),
                new Position(4, 2)));
    }

    @Test
    public void
    getAntinodesPositionsFromTwoSecondaryDiagonallyAdjacentReversedAntennasShouldReturnTwoAntinodesAdjacentToThem() {
        assertEquals(Set.of(new Position(5, 1), new Position(2, 4)), solver.getAntinodesPositions(new Position(4, 2),
                new Position(3, 3)));
    }

    // TODO add more "random" tests
    // TODO add input tests

    @AfterEach
    public void tearDown() {
    }
}
