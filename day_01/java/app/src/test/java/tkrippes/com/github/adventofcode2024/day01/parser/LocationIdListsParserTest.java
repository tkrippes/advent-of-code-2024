package tkrippes.com.github.adventofcode2024.day01.parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class LocationIdListsParserTest {
    private LocationIdListsParser parser;
    private final String invalidInputFileName = "../../input/invalid_test_input.txt";
    private final String validInputFileName = "../../input/test_input.txt";

    @Before
    public void setUp() {
        parser = new LocationIdListsParser();
    }

    @Test(expected = FileNotFoundException.class)
    public void parsedListsNullForInvalidInputFileName() throws IOException {
        parser.parse(invalidInputFileName);
    }

    @Test
    public void parsedListsContainTheSameNumberOfElements() throws IOException {
        List<List<Integer>> parsedLists = parser.parse(validInputFileName);
        assertEquals(2, parsedLists.size());
        assertEquals(parsedLists.get(0).size(), parsedLists.get(1).size());
    }

    @Test
    public void parsedListsContainTheCorrectElements() throws IOException {
        List<List<Integer>> parsedLists = parser.parse(validInputFileName);
        assertEquals(List.of(3, 4, 2, 1, 3, 3), parsedLists.get(0));
        assertEquals(List.of(4, 3, 5, 3, 9, 3), parsedLists.get(1));
    }

    @After
    public void tearDown() {
    }
}
