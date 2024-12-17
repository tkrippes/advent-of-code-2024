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

        expectedEquations.add(new Equation(190, List.of(10L, 19L)));
        expectedEquations.add(new Equation(3267, List.of(81L, 40L, 27L)));
        expectedEquations.add(new Equation(83, List.of(17L, 5L)));
        expectedEquations.add(new Equation(156, List.of(15L, 6L)));
        expectedEquations.add(new Equation(7290, List.of(6L, 8L, 6L, 15L)));
        expectedEquations.add(new Equation(161011, List.of(16L, 10L, 13L)));
        expectedEquations.add(new Equation(192, List.of(17L, 8L, 14L)));
        expectedEquations.add(new Equation(21037, List.of(9L, 7L, 18L, 13L)));
        expectedEquations.add(new Equation(292, List.of(11L, 6L, 16L, 20L)));

        assertEquals(expectedEquations, parser.parse(validInputFileName));
    }

    @AfterEach
    public void tearDown() {
    }
}
