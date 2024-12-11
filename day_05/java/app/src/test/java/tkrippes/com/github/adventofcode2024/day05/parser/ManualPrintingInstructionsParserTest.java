package tkrippes.com.github.adventofcode2024.day05.parser;

import tkrippes.com.github.adventofcode2024.day05.ManualPrintingInstructions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

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
    public void parseThrowsOnEmptyPageOrderingRule() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule(""));
    }

    @Test
    public void parseThrowsOnSingleNumberPageOrderingRule() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("25"));
    }

    @Test
    public void parseThrowsOnMissingNumbersPageOrderingRule() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("|"));
    }

    @Test
    public void parseThrowsOnMissingFirstNumberPageOrderingRule() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("|26"));
    }

    @Test
    public void parseThrowsOnMissingSecondNumberPageOrderingRule() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("25|"));
    }

    @Test
    public void parseThrowsOnNonNumbersPageOrderingRule() {
        Assertions.assertThrows(NumberFormatException.class, () -> parser.parsePageOrderingRule("AB|CD"));
    }

    @Test
    public void parseThrowsOnThreeNumbersPageOrderingRule() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("25|26|27"));
    }

    @Test
    public void parseThrowsOnTwoNumbersIncludingSpacesPageOrderingRule() {
        Assertions.assertThrows(NumberFormatException.class, () -> parser.parsePageOrderingRule("25 | 26"));
    }

    @Test
    public void parseTwoNumbersPageOrderingRule() {
        assertEquals(new ManualPrintingInstructions.PageOrderingRule(25, 26),
                parser.parsePageOrderingRule("25|26"));
    }

    @Test
    public void parseThrowsOnEmptyPagesToProduce() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePagesToProduce(""));
    }

    @Test
    public void parseThrowsOnMissingNumbersPagesToProduce() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePagesToProduce(","));
    }

    @Test
    public void parseThrowsOnMissingFirstNumberPagesToProduce() {
        Assertions.assertThrows(NumberFormatException.class, () -> parser.parsePagesToProduce(",26"));
    }

    @Test
    public void parseThrowsOnNonNumbersPagesToProduce() {
        Assertions.assertThrows(NumberFormatException.class, () -> parser.parsePagesToProduce("AB,CD"));
    }

    @Test
    public void parseThrowsOnTwoNumbersIncludingSpacesPagesToProduce() {
        Assertions.assertThrows(NumberFormatException.class, () -> parser.parsePagesToProduce("25, 26"));
    }

    @Test
    public void parseSingleNumberPagesToProduce() {
        assertEquals(new ManualPrintingInstructions.PagesToProduce(List.of(25)),
                parser.parsePagesToProduce("25"));
    }

    @Test
    public void parseTwoNumbersPagesToProduce() {
        assertEquals(new ManualPrintingInstructions.PagesToProduce(List.of(25, 26)),
                parser.parsePagesToProduce("25,26"));
    }

    @Test
    public void parseOmitsEmptyNumberPagesToProduceAtTheEnd() {
        assertEquals(new ManualPrintingInstructions.PagesToProduce(List.of(25, 26)),
                parser.parsePagesToProduce("25,26,"));
    }

    @Test
    public void parseTenNumbersPagesToProduce() {
        assertEquals(new ManualPrintingInstructions.PagesToProduce(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
                parser.parsePagesToProduce("1,2,3,4,5,6,7,8,9,10"));
    }

    @AfterEach
    public void tearDown() {
    }
}
