package tkrippes.com.github.adventofcode2024.day08.solver;

import tkrippes.com.github.adventofcode2024.day08.AntennaMap;
import tkrippes.com.github.adventofcode2024.day08.Position;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AntinodesResonantHarmonicsSolverTest {
    @BeforeEach
    public void setUp() {
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

        assertEquals(34, AntinodesResonantHarmonicsSolver.solve(antennaMap));
    }

    @AfterEach
    public void tearDown() {
    }
}
