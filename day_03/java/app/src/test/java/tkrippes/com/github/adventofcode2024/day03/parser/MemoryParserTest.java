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
    public void parserParsesValidSingleMultiplicationCorrectly() {
        List<Memory.Multiplication> parsedMultiplications = parser.parseMultiplications("mul(3,6)");
        assertEquals(List.of(new Memory.Multiplication(3, 6)), parsedMultiplications);
    }

    @After
    public void tearDown() {
    }
}
