package tkrippes.com.github.adventofcode2024.day06.parser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class MapParserTest {
    private MapParser parser;

    @BeforeEach
    void setUp() {
        parser = new MapParser();
    }

    @Test
    public void parseThrowsForInvalidInputFileName() {
        assertThrows(FileNotFoundException.class, () -> parser.parse("../../input/invalid_test_input.txt"));
    }

    @Test
    public void parseEmptyMapShouldReturnEmptyMap() {
        assertTrue(parser.parseMap("").isEmpty());
    }

    @AfterEach
    void tearDown() {
    }
}
