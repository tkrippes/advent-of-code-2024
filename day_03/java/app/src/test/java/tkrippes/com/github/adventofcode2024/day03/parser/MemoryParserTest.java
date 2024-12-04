package tkrippes.com.github.adventofcode2024.day03.parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tkrippes.com.github.adventofcode2024.day03.Memory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MemoryParserTest {
    private MemoryParser parser;

    @Before
    public void setUp() {
        parser = new MemoryParser();
    }

    @Test(expected = FileNotFoundException.class)
    public void parserThrowsForInvalidInputFileName() throws IOException {
        String invalidInputFileName = "../../input/invalid_test_input.txt";
        parser.parse(invalidInputFileName);
    }

    @Test
    public void parserParsesValidSingleDigitMultiplicationCorrectly() {
        Map<Integer, Memory.Multiplication> parsedMultiplications = parser.parseMultiplications("mul(3,6)");
        assertEquals(Map.of(0, new Memory.Multiplication(3, 6)), parsedMultiplications);
    }

    @Test
    public void parserParsesValidDoubleDigitMultiplicationCorrectly() {
        Map<Integer, Memory.Multiplication> parsedMultiplications = parser.parseMultiplications("mul(33,66)");
        assertEquals(Map.of(0, new Memory.Multiplication(33, 66)), parsedMultiplications);
    }

    @Test
    public void parserParsesValidTripleDigitMultiplicationCorrectly() {
        Map<Integer, Memory.Multiplication> parsedMultiplications = parser.parseMultiplications("mul(333,666)");
        assertEquals(Map.of(0, new Memory.Multiplication(333, 666)), parsedMultiplications);
    }

    @Test
    public void parserDoesNotParseValidQuadrupleDigitMultiplication() {
        Map<Integer, Memory.Multiplication> parsedMultiplications = parser.parseMultiplications("mul(3333,66666)");
        assertTrue(parsedMultiplications.isEmpty());
    }

    @Test
    public void parserParsesValidMultipleMultiplicationCorrectly() {
        Map<Integer, Memory.Multiplication> parsedMultiplications = parser.parseMultiplications("mul(3,666)mul(33,6)" +
                "mul(333,66)");
        assertEquals(Map.of(0, new Memory.Multiplication(3, 666), 10, new Memory.Multiplication(33, 6),
                19, new Memory.Multiplication(333, 66)), parsedMultiplications);
    }

    @Test
    public void parserDoesNotParseInvalidMultiplications() {
        Map<Integer, Memory.Multiplication> parsedMultiplications = parser.parseMultiplications("mul(4*");
        assertTrue(parsedMultiplications.isEmpty());
        parsedMultiplications = parser.parseMultiplications("mul(6,9!");
        assertTrue(parsedMultiplications.isEmpty());
        parsedMultiplications = parser.parseMultiplications("?(12,34)");
        assertTrue(parsedMultiplications.isEmpty());
        parsedMultiplications = parser.parseMultiplications("mul ( 2 , 4 )");
        assertTrue(parsedMultiplications.isEmpty());
    }

    @Test
    public void parserParsesDosAndDontsCorrectly() {
        Map<Integer, Boolean> parsedDosAndDonts = parser.parseDosAndDonts("do()do(dont(dont()dont()blado()");
        assertEquals(Map.of(0, true, 12, false, 18, false, 27, true), parsedDosAndDonts);
    }

    @Test
    public void parserParsesTestInputFileCorrectly() throws IOException {
        String validInputFileName = "../../input/test_input.txt";

        Memory parsedMemory = parser.parse(validInputFileName);
        assertEquals(new Memory(List.of(new Memory.Multiplication(2, 4), new Memory.Multiplication(5, 5),
                new Memory.Multiplication(11, 8), new Memory.Multiplication(8, 5))), parsedMemory);
    }

    @After
    public void tearDown() {
    }
}
