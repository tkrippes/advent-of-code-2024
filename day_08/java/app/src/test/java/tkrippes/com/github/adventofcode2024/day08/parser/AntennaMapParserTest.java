package tkrippes.com.github.adventofcode2024.day08.parser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tkrippes.com.github.adventofcode2024.day08.AntennaMap;
import tkrippes.com.github.adventofcode2024.day08.Position;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AntennaMapParserTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void parseThrowsForInvalidInputFileName() {
        assertThrows(FileNotFoundException.class, () -> AntennaMapParser.parse("../../input/invalid_test_input.txt"));
    }

    @Test
    public void parseShouldParseInputFileCorrectly() throws IOException {
        String validInputFileName = "../../input/test_input.txt";

        AntennaMap expectedAntennaMap = new AntennaMap(Map.of(
                new Position(1, 8), '0',
                new Position(2, 5), '0',
                new Position(3, 7), '0',
                new Position(4, 4), '0',
                new Position(5, 6), 'A',
                new Position(8, 8), 'A',
                new Position(9, 9), 'A'), 12, 12);

        assertEquals(expectedAntennaMap, AntennaMapParser.parse(validInputFileName));
    }

    @AfterEach
    public void tearDown() {
    }
}
