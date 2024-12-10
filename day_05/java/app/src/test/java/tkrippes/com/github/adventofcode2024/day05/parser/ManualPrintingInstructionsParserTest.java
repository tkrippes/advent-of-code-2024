package tkrippes.com.github.adventofcode2024.day05.parser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class ManualPrintingInstructionsParserTest {
    private ManualPrintingInstructionsParser parser;

    @BeforeEach
    public void setUp() {
        parser = new ManualPrintingInstructionsParser();
    }

    @Test
    public void parseThrowsForInvalidInputFileName() {
        String invalidInputFileName = "../../input/invalid_test_input.txt";

        Assertions.assertThrows(FileNotFoundException.class, () -> parser.parse(invalidInputFileName));
    }

    @Test
    public void parseEmptyPageOrderingRuleShouldReturnEmptyResult() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule(""));
    }

    @Test
    public void parseEmptyPagesToProduceShouldReturnEmptyResult() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePagesToProduce(""));
    }

    @AfterEach
    public void tearDown() {
    }
}
