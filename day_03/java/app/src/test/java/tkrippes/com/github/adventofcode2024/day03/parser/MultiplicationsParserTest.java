package tkrippes.com.github.adventofcode2024.day03.parser;

import tkrippes.com.github.adventofcode2024.day03.Multiplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;

public class MultiplicationsParserTest {
    private MultiplicationsParser parser;

    @Before
    public void setUp() {
        parser = new MultiplicationsParser();
    }

    @Test(expected = FileNotFoundException.class)
    public void parseThrowsForInvalidInputFileName() throws IOException {
        String invalidInputFileName = "../../input/invalid_test_input.txt";
        parser.parse(invalidInputFileName);
    }

    @Test
    public void parseValidSingleDigitMultiplicationCorrectly() {
        Map<Integer, Multiplication> parsedMultiplications = parser.parseMultiplications("mul(3,6)");
        assertEquals(Map.of(0, new Multiplication(3, 6)), parsedMultiplications);
    }

    @Test
    public void parseValidDoubleDigitMultiplicationCorrectly() {
        Map<Integer, Multiplication> parsedMultiplications = parser.parseMultiplications("mul(33,66)");
        assertEquals(Map.of(0, new Multiplication(33, 66)), parsedMultiplications);
    }

    @Test
    public void parseValidTripleDigitMultiplicationCorrectly() {
        Map<Integer, Multiplication> parsedMultiplications = parser.parseMultiplications("mul(333,666)");
        assertEquals(Map.of(0, new Multiplication(333, 666)), parsedMultiplications);
    }

    @Test
    public void dontParseValidQuadrupleDigitMultiplication() {
        Map<Integer, Multiplication> parsedMultiplications = parser.parseMultiplications("mul(3333,66666)");
        assertTrue(parsedMultiplications.isEmpty());
    }

    @Test
    public void parseValidMultipleMultiplicationsCorrectly() {
        Map<Integer, Multiplication> parsedMultiplications = parser.parseMultiplications("mul(3,666)mul(33,6)" +
                "mul(333,66)");
        assertEquals(Map.of(0, new Multiplication(3, 666), 10, new Multiplication(33, 6),
                19, new Multiplication(333, 66)), parsedMultiplications);
    }

    @Test
    public void dontParseInvalidMultiplications() {
        Map<Integer, Multiplication> parsedMultiplications = parser.parseMultiplications("mul(4*");
        assertTrue(parsedMultiplications.isEmpty());
        parsedMultiplications = parser.parseMultiplications("mul(6,9!");
        assertTrue(parsedMultiplications.isEmpty());
        parsedMultiplications = parser.parseMultiplications("?(12,34)");
        assertTrue(parsedMultiplications.isEmpty());
        parsedMultiplications = parser.parseMultiplications("mul ( 2 , 4 )");
        assertTrue(parsedMultiplications.isEmpty());
    }

    @Test
    public void parseMultiplicationsTestInputFileCorrectly() throws IOException {
        String validInputFileName = "../../input/test_input.txt";

        Map<Integer, Multiplication> parsedMultiplications = parser.parse(validInputFileName);
        assertEquals(Map.of(1, new Multiplication(2, 4), 29, new Multiplication(5, 5),
                53, new Multiplication(11, 8), 62, new Multiplication(8, 5)), parsedMultiplications);
    }

    @Test
    public void parseMultiplicationsTestInputFile2Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_2.txt";

        Map<Integer, Multiplication> parsedMultiplications = parser.parse(validInputFileName);
        assertEquals(Map.of(1, new Multiplication(2, 4), 28, new Multiplication(5, 5),
                48, new Multiplication(11, 8), 64, new Multiplication(8, 5)), parsedMultiplications);
    }

    @After
    public void tearDown() {
    }
}
