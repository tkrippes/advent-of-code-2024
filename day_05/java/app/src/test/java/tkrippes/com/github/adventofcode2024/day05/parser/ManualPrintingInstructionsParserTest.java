package tkrippes.com.github.adventofcode2024.day05.parser;

import tkrippes.com.github.adventofcode2024.day05.ManualPrintingInstructions;

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
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("|25"));
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
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("25 | 26"));
    }

    @Test
    public void parseOnTwoNumbersPageOrderingRuleIsCalculatedCorrectly() {
        assertEquals(new ManualPrintingInstructions.PageOrderingRule(25, 26),
                parser.parsePageOrderingRule("25|26"));
    }

    @Test
    public void parseThrowsOnEmptyPagesToProduce() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePagesToProduce(""));
    }

    @AfterEach
    public void tearDown() {
    }
}
