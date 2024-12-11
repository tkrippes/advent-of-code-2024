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
    public void parseManualPrintingInstructionsThrowsOnEmptyInputs() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parseManualPrintingInstructions(List.of()));
    }

    @Test
    public void parseManualPrintingInstructionsThrowsOnMissingEmptyLine() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parseManualPrintingInstructions(List.of("25|26", "25,26")));
    }

    @Test
    public void parseManualPrintingInstructionsThrowsOnMissingRules() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parseManualPrintingInstructions(List.of("", "25,26")));
    }

    @Test
    public void parseManualPrintingInstructionsThrowsOnMissingPages() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parseManualPrintingInstructions(List.of("25|26", "")));
    }

    @Test
    public void parseManualPrintingInstructionsReturnsManualCorrectly() {
        List<ManualPrintingInstructions.PageOrderingRule> expectedRules = List.of(
                new ManualPrintingInstructions.PageOrderingRule(25, 26),
                new ManualPrintingInstructions.PageOrderingRule(26, 27),
                new ManualPrintingInstructions.PageOrderingRule(27, 28),
                new ManualPrintingInstructions.PageOrderingRule(28, 29),
                new ManualPrintingInstructions.PageOrderingRule(29, 30));

        List<ManualPrintingInstructions.PagesToProduce> expectedPages = List.of(
                new ManualPrintingInstructions.PagesToProduce(List.of(25, 26, 27)),
                new ManualPrintingInstructions.PagesToProduce(List.of(25, 27, 29)),
                new ManualPrintingInstructions.PagesToProduce(List.of(30, 28, 26)),
                new ManualPrintingInstructions.PagesToProduce(List.of(25, 28, 27, 30, 29, 26)));

        assertEquals(new ManualPrintingInstructions(expectedRules, expectedPages),
                parser.parseManualPrintingInstructions(List.of("25|26", "26|27", "27|28", "28|29", "29|30", "",
                        "25,26,27", "25,27,29", "30,28,26", "25,28,27,30,29,26")));
    }

    @Test
    public void parsePageOrderingRuleThrowsOnEmptyRule() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule(""));
    }

    @Test
    public void parsePageOrderingRuleThrowsOnSingleNumberRule() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("25"));
    }

    @Test
    public void parsePageOrderingRuleThrowsOnMissingNumbersRule() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("|"));
    }

    @Test
    public void parsePageOrderingRuleThrowsOnMissingFirstNumberRule() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("|26"));
    }

    @Test
    public void parsePageOrderingRuleThrowsOnMissingSecondNumberRule() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("25|"));
    }

    @Test
    public void parsePageOrderingRuleThrowsOnNonNumbersRule() {
        Assertions.assertThrows(NumberFormatException.class, () -> parser.parsePageOrderingRule("AB|CD"));
    }

    @Test
    public void parsePageOrderingRuleThrowsOnThreeNumbersRule() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("25|26|27"));
    }

    @Test
    public void parsePageOrderingRuleThrowsOnTwoNumbersIncludingSpacesRule() {
        Assertions.assertThrows(NumberFormatException.class, () -> parser.parsePageOrderingRule("25 | 26"));
    }

    @Test
    public void parsePageOrderingRuleTwoNumbersRuleCalculatesRuleCorrectly() {
        assertEquals(new ManualPrintingInstructions.PageOrderingRule(25, 26),
                parser.parsePageOrderingRule("25|26"));
    }

    @Test
    public void parsePagesToProduceThrowsOnEmptyPages() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePagesToProduce(""));
    }

    @Test
    public void parsePagesToProduceThrowsOnMissingNumbersPages() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parsePagesToProduce(","));
    }

    @Test
    public void parsePagesToProduceThrowsOnMissingFirstNumberPages() {
        Assertions.assertThrows(NumberFormatException.class, () -> parser.parsePagesToProduce(",26"));
    }

    @Test
    public void parsePagesToProduceThrowsOnNonNumbersPages() {
        Assertions.assertThrows(NumberFormatException.class, () -> parser.parsePagesToProduce("AB,CD"));
    }

    @Test
    public void parsePagesToProduceThrowsOnTwoNumbersIncludingSpacesPages() {
        Assertions.assertThrows(NumberFormatException.class, () -> parser.parsePagesToProduce("25, 26"));
    }

    @Test
    public void parsePagesToProduceSingleNumberPagesReturnsCorrectly() {
        assertEquals(new ManualPrintingInstructions.PagesToProduce(List.of(25)),
                parser.parsePagesToProduce("25"));
    }

    @Test
    public void parsePagesToProduceTwoNumbersPagesReturnsCorrectly() {
        assertEquals(new ManualPrintingInstructions.PagesToProduce(List.of(25, 26)),
                parser.parsePagesToProduce("25,26"));
    }

    @Test
    public void parsePagesToProduceOmitsEmptyNumberPagesToProduceAtTheEnd() {
        assertEquals(new ManualPrintingInstructions.PagesToProduce(List.of(25, 26)),
                parser.parsePagesToProduce("25,26,"));
    }

    @Test
    public void parsePagesToProduceTenNumbersPagesReturnCorrectly() {
        assertEquals(new ManualPrintingInstructions.PagesToProduce(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
                parser.parsePagesToProduce("1,2,3,4,5,6,7,8,9,10"));
    }

    @Test
    public void parseThrowsForInvalidInputFileName() {
        String invalidInputFileName = "../../input/invalid_test_input.txt";

        Assertions.assertThrows(FileNotFoundException.class, () -> parser.parse(invalidInputFileName));
    }

    // TODO add test for real input file

    @AfterEach
    public void tearDown() {
    }
}
