package tkrippes.com.github.adventofcode2024.day03.parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tkrippes.com.github.adventofcode2024.day03.Memory;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.*;

public class MemoryParserTest {
    private MemoryParser parser;
    private final String invalidInputFileName = "../../input/invalid_test_input.txt";
    private final String validInputFileName = "../../input/test_input.txt";

    @Before
    public void setUp() {
        parser = new MemoryParser();
    }

    @Test(expected = FileNotFoundException.class)
    public void parserThrowsForInvalidInputFileName() throws FileNotFoundException {
        parser.parse(invalidInputFileName);
    }

    @Test
    public void parserParsesValidSingleDigitMultiplicationCorrectly() {
        List<Memory.Multiplication> parsedMultiplications = parser.parseMultiplications("mul(3,6)");
        assertEquals(List.of(new Memory.Multiplication(3, 6)), parsedMultiplications);
    }

    @Test
    public void parserParsesValidDoubleDigitMultiplicationCorrectly() {
        List<Memory.Multiplication> parsedMultiplications = parser.parseMultiplications("mul(33,66)");
        assertEquals(List.of(new Memory.Multiplication(33, 66)), parsedMultiplications);
    }

    @Test
    public void parserParsesValidTripleDigitMultiplicationCorrectly() {
        List<Memory.Multiplication> parsedMultiplications = parser.parseMultiplications("mul(333,666)");
        assertEquals(List.of(new Memory.Multiplication(333, 666)), parsedMultiplications);
    }

    @Test
    public void parserDoesNotParseValidQuadrupleDigitMultiplication() {
        List<Memory.Multiplication> parsedMultiplications = parser.parseMultiplications("mul(3333,66666)");
        assertTrue(parsedMultiplications.isEmpty());
    }

    @Test
    public void parserParsesValidMultipleMultiplicationCorrectly() {
        List<Memory.Multiplication> parsedMultiplications = parser.parseMultiplications("mul(3,666)mul(33,6)mul(333,66)");
        assertEquals(List.of(new Memory.Multiplication(3, 666), new Memory.Multiplication(33, 6), new Memory.Multiplication(333, 66)), parsedMultiplications);
    }

    @Test
    public void parserDoesNotParseInvalidMultiplications() {
        List<Memory.Multiplication> parsedMultiplications = parser.parseMultiplications("mul(4*");
        assertTrue(parsedMultiplications.isEmpty());
        parsedMultiplications = parser.parseMultiplications("mul(6,9!");
        assertTrue(parsedMultiplications.isEmpty());
        parsedMultiplications = parser.parseMultiplications("?(12,34)");
        assertTrue(parsedMultiplications.isEmpty());
        parsedMultiplications = parser.parseMultiplications("mul ( 2 , 4 )");
        assertTrue(parsedMultiplications.isEmpty());
    }

    @After
    public void tearDown() {
    }
}
