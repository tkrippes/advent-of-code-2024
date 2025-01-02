package tkrippes.com.github.adventofcode2024.day13.parser;

import tkrippes.com.github.adventofcode2024.day13.Direction;
import tkrippes.com.github.adventofcode2024.day13.MachineConfiguration;
import tkrippes.com.github.adventofcode2024.day13.Position;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MachineConfigurationsParserTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void parseThrowsForInvalidInputFileName() {
        assertThrows(FileNotFoundException.class, () -> MachineConfigurationsParser.parse("../." +
                "./input/invalid_test_input.txt"));
    }

    @Test
    public void parseShouldParseInputFileCorrectly() throws IOException {
        String validInputFileName = "../../input/test_input.txt";
        List<MachineConfiguration> expectedMachineConfigurations = List.of(
                new MachineConfiguration(new Direction(94, 34), new Direction(22, 67), new Position(8400, 5400)),
                new MachineConfiguration(new Direction(26, 66), new Direction(67, 21), new Position(12748, 12176)),
                new MachineConfiguration(new Direction(17, 86), new Direction(84, 37), new Position(7870, 6450)),
                new MachineConfiguration(new Direction(69, 23), new Direction(27, 71), new Position(18641, 10279)
                )
        );

        assertEquals(expectedMachineConfigurations,
                MachineConfigurationsParser.parse(validInputFileName));
    }

    @AfterEach
    public void tearDown() {
    }
}
