package tkrippes.com.github.adventofcode2024.day03.parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FiltersParserTest {
    private FiltersParser parser;

    @Before
    public void setUp() {
        parser = new FiltersParser();
    }

    @Test(expected = FileNotFoundException.class)
    public void parseFiltersThrowsForInvalidInputFileName() throws IOException {
        String invalidInputFileName = "../../input/invalid_test_input.txt";
        parser.parse(invalidInputFileName);
    }

    @Test
    public void parseFiltersCorrectly() {
        Map<Integer, Boolean> parsedFiltersMap = parser.parseFilters("do()do(dont()don't()don't()blado()");
        assertEquals(Map.of(0, true, 13, false, 20, false, 30, true), parsedFiltersMap);
    }

    @Test
    public void parseFiltersTestInputFile2Correctly() throws IOException {
        String validInputFileName = "../../input/test_input_2.txt";

        Map<Integer, Boolean> parsedFilters = parser.parse(validInputFileName);
        assertEquals(Map.of(20, false, 59, true), parsedFilters);
    }

    @After
    public void tearDown() {
    }
}
