package tkrippes.com.github.adventofcode2024.day02.parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class ReportListParserTest {
    private ReportListParser parser;
    private final String invalidInputFileName = "../../input/invalid_test_input.txt";
    private final String validInputFileName = "../../input/test_input.txt";

    @Before
    public void setUp() {
        parser = new ReportListParser();
    }

    @Test(expected = FileNotFoundException.class)
    public void parserThrowsForInvalidInputFileName() throws IOException {
        parser.parse(invalidInputFileName);
    }

    @Test
    public void parsedReportListHasCorrectLength() throws IOException {
        List<List<Integer>> parsedList = parser.parse(validInputFileName);
        assertEquals(6, parsedList.size());
    }

    @Test
    public void parsedReportListContainsCorrectReports() throws IOException {
        List<List<Integer>> parsedList = parser.parse(validInputFileName);
        assertEquals(List.of(7, 6, 4, 2, 1), parsedList.get(0));
        assertEquals(List.of(1, 2, 7, 8, 9), parsedList.get(1));
        assertEquals(List.of(9, 7, 6, 2, 1), parsedList.get(2));
        assertEquals(List.of(1, 3, 2, 4, 5), parsedList.get(3));
        assertEquals(List.of(8, 6, 4, 4, 1), parsedList.get(4));
        assertEquals(List.of(1, 3, 6, 7, 9), parsedList.get(5));
    }

    @After
    public void tearDown() {
    }
}
