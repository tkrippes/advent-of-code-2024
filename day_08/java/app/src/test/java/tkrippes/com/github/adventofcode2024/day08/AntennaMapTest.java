package tkrippes.com.github.adventofcode2024.day08;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AntennaMapTest {
    private AntennaMap map;

    @BeforeEach
    public void setUp() {
        map = new AntennaMap(Map.of(
                new Position(1, 8), '0',
                new Position(2, 5), '0',
                new Position(3, 7), '0',
                new Position(4, 4), '0',
                new Position(5, 6), 'A',
                new Position(8, 8), 'A',
                new Position(9, 9), 'A'), 12, 12);
    }

    @Test
    public void getAntennaFrequenciesShouldReturnZeroAndCapitalA() {
        assertEquals(Set.of('0', 'A'), map.getAntennaFrequencies());
    }

    @Test
    public void getAntennaFrequencyPositionsShouldReturnCorrectPositionsForZero() {
        assertEquals(Set.of(
                        new Position(1, 8),
                        new Position(2, 5),
                        new Position(3, 7),
                        new Position(4, 4)),
                map.getAntennaFrequencyPositions('0'));

    }

    @Test
    public void getAntennaFrequencyPositionsShouldReturnCorrectPositionsForCapitalA() {
        assertEquals(Set.of(
                        new Position(5, 6),
                        new Position(8, 8),
                        new Position(9, 9)),
                map.getAntennaFrequencyPositions('A'));
    }

    @AfterEach
    public void tearDown() {
    }
}
