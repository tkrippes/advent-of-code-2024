package tkrippes.com.github.adventofcode2024.day06.map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuardTest {
    private Guard guard;

    @BeforeEach
    public void setUp() {
        guard = new Guard(new Position(10, 10));
    }

    @Test
    public void getDefaultPositionAndOrientationsReturnCorrectly() {
        assertEquals(new Position(10, 10), guard.getPosition());
        assertEquals(Guard.Orientation.UP, guard.getOrientation());
    }

    @Test
    public void turnRightOnceChangesGuardCorrectly() {
        guard.turnRight();

        assertEquals(new Position(10, 10), guard.getPosition());
        assertEquals(Guard.Orientation.RIGHT, guard.getOrientation());
    }

    @Test
    public void turnRightTwiceChangesGuardCorrectly() {
        guard.turnRight();
        guard.turnRight();

        assertEquals(new Position(10, 10), guard.getPosition());
        assertEquals(Guard.Orientation.DOWN, guard.getOrientation());
    }

    @Test
    public void turnRightThreeTimesChangesGuardCorrectly() {
        guard.turnRight();
        guard.turnRight();
        guard.turnRight();

        assertEquals(new Position(10, 10), guard.getPosition());
        assertEquals(Guard.Orientation.LEFT, guard.getOrientation());
    }

    @Test
    public void turnRightFourTimesChangesGuardCorrectly() {
        guard.turnRight();
        guard.turnRight();
        guard.turnRight();
        guard.turnRight();

        assertEquals(new Position(10, 10), guard.getPosition());
        assertEquals(Guard.Orientation.UP, guard.getOrientation());
    }

    @Test
    public void moveUpChangesGuardCorrectly() {
        guard.move();

        assertEquals(new Position(9, 10), guard.getPosition());
        assertEquals(Guard.Orientation.UP, guard.getOrientation());
    }

    @Test
    public void moveRightChangesGuardCorrectly() {
        guard.turnRight();
        guard.move();

        assertEquals(new Position(10, 11), guard.getPosition());
        assertEquals(Guard.Orientation.RIGHT, guard.getOrientation());
    }

    @Test
    public void moveDownChangesGuardCorrectly() {
        guard.turnRight();
        guard.turnRight();
        guard.move();

        assertEquals(new Position(11, 10), guard.getPosition());
        assertEquals(Guard.Orientation.DOWN, guard.getOrientation());
    }

    @Test
    public void moveLeftChangesGuardCorrectly() {
        guard.turnRight();
        guard.turnRight();
        guard.turnRight();
        guard.move();

        assertEquals(new Position(10, 9), guard.getPosition());
        assertEquals(Guard.Orientation.LEFT, guard.getOrientation());
    }

    @Test
    public void getNextPositionUpReturnsCorrectly() {
        assertEquals(new Position(9, 10), guard.getNextPosition());
    }

    @Test
    public void getNextPositionRightReturnsCorrectly() {
        guard.turnRight();

        assertEquals(new Position(10, 11), guard.getNextPosition());
    }

    @Test
    public void getNextPositionDownReturnsCorrectly() {
        guard.turnRight();
        guard.turnRight();

        assertEquals(new Position(11, 10), guard.getNextPosition());
    }

    @Test
    public void getNextPositionLeftReturnsCorrectly() {
        guard.turnRight();
        guard.turnRight();
        guard.turnRight();

        assertEquals(new Position(10, 9), guard.getNextPosition());
    }

    @AfterEach
    public void tearDown() {
    }
}
