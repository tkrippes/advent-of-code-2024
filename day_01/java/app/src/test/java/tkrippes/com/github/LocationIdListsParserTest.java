package tkrippes.com.github;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LocationIdListsParserTest {
    private LocationIdListsParser parser;
    private final String invalidInputFileName = "../../input/invalid_test_input.txt";
    private final String validInputFileName = "../../input/test_input.txt";

    @Before
    public void setUp() throws Exception {
        parser = new LocationIdListsParser();
    }

    @Test
    public void parsedListsNullForInvalidInputFileName() {
        List<List<Integer>> parsedLists = parser.parse(invalidInputFileName);
        assertNull(parsedLists);
    }

    @Test
    public void parsedListsContainTheSameNumberOfElements() {
        List<List<Integer>> parsedLists = parser.parse(validInputFileName);
        assertEquals(2, parsedLists.size());
        assertEquals(parsedLists.get(0).size(), parsedLists.get(1).size());
    }

    @Test
    public void parsedListsContainTheCorrectElements() {
        List<List<Integer>> parsedLists = parser.parse(validInputFileName);
        assertEquals(List.of(3, 4, 2, 1, 3, 3), parsedLists.get(0));
        assertEquals(List.of(4, 3, 5, 3, 9, 3), parsedLists.get(1));
    }

    @After
    public void tearDown() throws Exception {
    }
}
