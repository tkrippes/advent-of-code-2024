package tkrippes.com.github.adventofcode2024.day07.parser;

import tkrippes.com.github.adventofcode2024.day07.Equation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EquationsParserTest {
    private EquationsParser parser;

    @BeforeEach
    public void setUp() {
        parser = new EquationsParser();
    }

    @Test
    public void parseThrowsForInvalidInputFileName() {
        assertThrows(FileNotFoundException.class, () -> parser.parse("../../input/invalid_test_input.txt"));
    }

    @Test
    public void parseShouldParseInputFileCorrectly() throws IOException {
        String validInputFileName = "../../input/test_input.txt";
        List<Equation> expectedEquations = new ArrayList<>();

        expectedEquations.add(new Equation(190, List.of(10, 19)));
        expectedEquations.add(new Equation(3267, List.of(81, 40, 27)));
        expectedEquations.add(new Equation(83, List.of(17, 5)));
        expectedEquations.add(new Equation(156, List.of(15, 6)));
        expectedEquations.add(new Equation(7290, List.of(6, 8, 6, 15)));
        expectedEquations.add(new Equation(161011, List.of(16, 10, 13)));
        expectedEquations.add(new Equation(192, List.of(17, 8, 14)));
        expectedEquations.add(new Equation(21037, List.of(9, 7, 18, 13)));
        expectedEquations.add(new Equation(292, List.of(11, 6, 16, 20)));

        assertEquals(expectedEquations, parser.parse(validInputFileName));
    }

    @AfterEach
    public void tearDown() {
    }
}
