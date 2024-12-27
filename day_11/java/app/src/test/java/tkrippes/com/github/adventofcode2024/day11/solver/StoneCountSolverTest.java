package tkrippes.com.github.adventofcode2024.day11.solver;

import tkrippes.com.github.adventofcode2024.day11.PlutonianPebble;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StoneCountSolverTest {
    private final List<PlutonianPebble> initialStones = List.of(new PlutonianPebble(125), new PlutonianPebble(17));

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void solveShouldReturnCorrectStoneCount() {
        assertEquals(55312, StoneCountSolver.solve(initialStones, 25));
    }

    @Test
    public void blinkOnceShouldReturnCorrectStones() {
        assertEquals(List.of(new PlutonianPebble(253000), new PlutonianPebble(1), new PlutonianPebble(7)),
                StoneCountSolver.blink(initialStones));
    }

    @Test
    public void blinkTwiceShouldReturnCorrectStones() {
        List<PlutonianPebble> expectedStones = List.of(
                new PlutonianPebble(253),
                new PlutonianPebble(0),
                new PlutonianPebble(2024),
                new PlutonianPebble(14168)
        );

        assertEquals(expectedStones, getPlutonianPebbles(2));
    }

    @Test
    public void blinkThreeTimesShouldReturnCorrectStones() {
        List<PlutonianPebble> expectedStones = List.of(
                new PlutonianPebble(512072),
                new PlutonianPebble(1),
                new PlutonianPebble(20),
                new PlutonianPebble(24),
                new PlutonianPebble(28676032)
        );

        assertEquals(expectedStones, getPlutonianPebbles(3));
    }

    @Test
    public void blinkFourTimesShouldReturnCorrectStones() {
        List<PlutonianPebble> expectedStones = List.of(
                new PlutonianPebble(512),
                new PlutonianPebble(72),
                new PlutonianPebble(2024),
                new PlutonianPebble(2),
                new PlutonianPebble(0),
                new PlutonianPebble(2),
                new PlutonianPebble(4),
                new PlutonianPebble(2867),
                new PlutonianPebble(6032)
        );

        assertEquals(expectedStones, getPlutonianPebbles(4));
    }

    @Test
    public void blinkFiveTimesShouldReturnCorrectStones() {
        List<PlutonianPebble> expectedStones = List.of(
                new PlutonianPebble(1036288),
                new PlutonianPebble(7),
                new PlutonianPebble(2),
                new PlutonianPebble(20),
                new PlutonianPebble(24),
                new PlutonianPebble(4048),
                new PlutonianPebble(1),
                new PlutonianPebble(4048),
                new PlutonianPebble(8096),
                new PlutonianPebble(28),
                new PlutonianPebble(67),
                new PlutonianPebble(60),
                new PlutonianPebble(32)
        );

        assertEquals(expectedStones, getPlutonianPebbles(5));
    }

    @Test
    public void blinkSixTimesShouldReturnCorrectStones() {
        List<PlutonianPebble> expectedStones = List.of(
                new PlutonianPebble(2097446912),
                new PlutonianPebble(14168),
                new PlutonianPebble(4048),
                new PlutonianPebble(2),
                new PlutonianPebble(0),
                new PlutonianPebble(2),
                new PlutonianPebble(4),
                new PlutonianPebble(40),
                new PlutonianPebble(48),
                new PlutonianPebble(2024),
                new PlutonianPebble(40),
                new PlutonianPebble(48),
                new PlutonianPebble(80),
                new PlutonianPebble(96),
                new PlutonianPebble(2),
                new PlutonianPebble(8),
                new PlutonianPebble(6),
                new PlutonianPebble(7),
                new PlutonianPebble(6),
                new PlutonianPebble(0),
                new PlutonianPebble(3),
                new PlutonianPebble(2)
        );

        assertEquals(expectedStones, getPlutonianPebbles(6));
    }

    private List<PlutonianPebble> getPlutonianPebbles(int numberOfBlinks) {
        List<PlutonianPebble> finalStones = new ArrayList<>(initialStones);
        for (int i = 0; i < numberOfBlinks; i++) {
            finalStones = StoneCountSolver.blink(finalStones);
        }

        return finalStones;
    }

    @AfterEach
    public void tearDown() {
    }
}
