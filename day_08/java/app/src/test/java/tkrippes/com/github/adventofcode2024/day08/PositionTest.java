package tkrippes.com.github.adventofcode2024.day08;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    private Position firstPosition;
    private Position secondPosition;

    @BeforeEach
    public void setUp() {
        firstPosition = new Position(5, 8);
        secondPosition = new Position(7, 2);
    }

    @Test
    public void addShouldReturnCorrectPosition() {
        assertEquals(new Position(12, 10), firstPosition.add(secondPosition));
    }

    @Test
    public void subtractShouldReturnCorrectPosition() {
        assertEquals(new Position(-2, 6), firstPosition.subtract(secondPosition));
    }

    @Test
    public void getPositionsPairCombinationsShouldBeEmptyForOnePosition() {
        assertTrue(Position.getPositionsPairCombinations(Set.of(new Position(1, 1))).isEmpty());
    }

    @Test
    public void getPositionsPairCombinationsShouldReturnAllCombinationsForTwoPositions() {
        assertEquals(Set.of(Set.of(new Position(1, 1), new Position(2, 2))),
                Position.getPositionsPairCombinations(Set.of(new Position(1, 1),
                        new Position(2, 2))));
    }

    @Test
    public void getPositionsPairCombinationsShouldReturnAllCombinationsForThreePositions() {
        assertEquals(Set.of(
                        Set.of(new Position(1, 1), new Position(2, 2)),
                        Set.of(new Position(1, 1), new Position(3, 3)),
                        Set.of(new Position(2, 2), new Position(3, 3))),
                Position.getPositionsPairCombinations(Set.of(new Position(1, 1),
                        new Position(2, 2), new Position(3, 3))));
    }

    @Test
    public void getPositionsPairCombinationsShouldReturnAllCombinationsForFourPositions() {
        assertEquals(Set.of(
                        Set.of(new Position(1, 1), new Position(2, 2)),
                        Set.of(new Position(1, 1), new Position(3, 3)),
                        Set.of(new Position(1, 1), new Position(4, 4)),
                        Set.of(new Position(2, 2), new Position(3, 3)),
                        Set.of(new Position(2, 2), new Position(4, 4)),
                        Set.of(new Position(3, 3), new Position(4, 4))),
                Position.getPositionsPairCombinations(Set.of(new Position(1, 1),
                        new Position(2, 2), new Position(3, 3), new Position(4, 4))));
    }

    @AfterEach
    public void tearDown() {
    }
}
