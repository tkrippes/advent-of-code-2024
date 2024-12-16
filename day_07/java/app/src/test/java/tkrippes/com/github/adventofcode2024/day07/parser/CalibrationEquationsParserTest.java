package tkrippes.com.github.adventofcode2024.day07.parser;

import tkrippes.com.github.adventofcode2024.day07.CalibrationEquation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalibrationEquationsParserTest {
    private CalibrationEquationsParser parser;

    @BeforeEach
    public void setUp() {
        parser = new CalibrationEquationsParser();
    }

    @Test
    public void parseThrowsForInvalidInputFileName() {
        assertThrows(FileNotFoundException.class, () -> parser.parse("../../input/invalid_test_input.txt"));
    }

    @Test
    public void parseShouldParseInputFileCorrectly() throws IOException {
        String validInputFileName = "../../input/test_input.txt";
        List<CalibrationEquation> expectedCalibrationEquations = new ArrayList<>();

        expectedCalibrationEquations.add(new CalibrationEquation(190, List.of(10, 19)));
        expectedCalibrationEquations.add(new CalibrationEquation(3267, List.of(81, 40, 27)));
        expectedCalibrationEquations.add(new CalibrationEquation(83, List.of(17, 5)));
        expectedCalibrationEquations.add(new CalibrationEquation(156, List.of(15, 6)));
        expectedCalibrationEquations.add(new CalibrationEquation(7290, List.of(6, 8, 6, 15)));
        expectedCalibrationEquations.add(new CalibrationEquation(161011, List.of(16, 10, 13)));
        expectedCalibrationEquations.add(new CalibrationEquation(192, List.of(17, 8, 14)));
        expectedCalibrationEquations.add(new CalibrationEquation(21037, List.of(9, 7, 18, 13)));
        expectedCalibrationEquations.add(new CalibrationEquation(292, List.of(11, 6, 16, 20)));

        assertEquals(expectedCalibrationEquations, parser.parse(validInputFileName));
    }

    @AfterEach
    public void tearDown() {
    }
}
