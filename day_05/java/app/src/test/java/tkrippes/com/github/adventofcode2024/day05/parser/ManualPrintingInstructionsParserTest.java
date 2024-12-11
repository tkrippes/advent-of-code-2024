package tkrippes.com.github.adventofcode2024.day05.parser;

import tkrippes.com.github.adventofcode2024.day05.ManualPrintingInstructions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
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
        assertThrows(IllegalArgumentException.class, () -> parser.parseManualPrintingInstructions(List.of()));
    }

    @Test
    public void parseManualPrintingInstructionsThrowsOnMissingEmptyLine() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseManualPrintingInstructions(List.of("25|26", "25,26")));
    }

    @Test
    public void parseManualPrintingInstructionsThrowsOnMissingRules() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseManualPrintingInstructions(List.of("", "25,26")));
    }

    @Test
    public void parseManualPrintingInstructionsThrowsOnMissingPages() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseManualPrintingInstructions(List.of("25|26", "")));
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
        assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule(""));
    }

    @Test
    public void parsePageOrderingRuleThrowsOnSingleNumberRule() {
        assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("25"));
    }

    @Test
    public void parsePageOrderingRuleThrowsOnMissingNumbersRule() {
        assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("|"));
    }

    @Test
    public void parsePageOrderingRuleThrowsOnMissingFirstNumberRule() {
        assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("|26"));
    }

    @Test
    public void parsePageOrderingRuleThrowsOnMissingSecondNumberRule() {
        assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("25|"));
    }

    @Test
    public void parsePageOrderingRuleThrowsOnNonNumbersRule() {
        assertThrows(NumberFormatException.class, () -> parser.parsePageOrderingRule("AB|CD"));
    }

    @Test
    public void parsePageOrderingRuleThrowsOnThreeNumbersRule() {
        assertThrows(IllegalArgumentException.class, () -> parser.parsePageOrderingRule("25|26|27"));
    }

    @Test
    public void parsePageOrderingRuleThrowsOnTwoNumbersIncludingSpacesRule() {
        assertThrows(NumberFormatException.class, () -> parser.parsePageOrderingRule("25 | 26"));
    }

    @Test
    public void parsePageOrderingRuleTwoNumbersRuleCalculatesRuleCorrectly() {
        assertEquals(new ManualPrintingInstructions.PageOrderingRule(25, 26),
                parser.parsePageOrderingRule("25|26"));
    }

    @Test
    public void parsePagesToProduceThrowsOnEmptyPages() {
        assertThrows(IllegalArgumentException.class, () -> parser.parsePagesToProduce(""));
    }

    @Test
    public void parsePagesToProduceThrowsOnMissingNumbersPages() {
        assertThrows(IllegalArgumentException.class, () -> parser.parsePagesToProduce(","));
    }

    @Test
    public void parsePagesToProduceThrowsOnMissingFirstNumberPages() {
        assertThrows(NumberFormatException.class, () -> parser.parsePagesToProduce(",26"));
    }

    @Test
    public void parsePagesToProduceThrowsOnNonNumbersPages() {
        assertThrows(NumberFormatException.class, () -> parser.parsePagesToProduce("AB,CD"));
    }

    @Test
    public void parsePagesToProduceThrowsOnTwoNumbersIncludingSpacesPages() {
        assertThrows(NumberFormatException.class, () -> parser.parsePagesToProduce("25, 26"));
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

        assertThrows(FileNotFoundException.class, () -> parser.parse(invalidInputFileName));
    }

    @Test
    public void parseShouldParseInputFileCorrectly() throws IOException {
        String validInputFileName = "../../input/test_input.txt";

        List<ManualPrintingInstructions.PageOrderingRule> expectedRules = List.of(
                new ManualPrintingInstructions.PageOrderingRule(47, 53),
                new ManualPrintingInstructions.PageOrderingRule(97, 13),
                new ManualPrintingInstructions.PageOrderingRule(97, 61),
                new ManualPrintingInstructions.PageOrderingRule(97, 47),
                new ManualPrintingInstructions.PageOrderingRule(75, 29),
                new ManualPrintingInstructions.PageOrderingRule(61, 13),
                new ManualPrintingInstructions.PageOrderingRule(75, 53),
                new ManualPrintingInstructions.PageOrderingRule(29, 13),
                new ManualPrintingInstructions.PageOrderingRule(97, 29),
                new ManualPrintingInstructions.PageOrderingRule(53, 29),
                new ManualPrintingInstructions.PageOrderingRule(61, 53),
                new ManualPrintingInstructions.PageOrderingRule(97, 53),
                new ManualPrintingInstructions.PageOrderingRule(61, 29),
                new ManualPrintingInstructions.PageOrderingRule(47, 13),
                new ManualPrintingInstructions.PageOrderingRule(75, 47),
                new ManualPrintingInstructions.PageOrderingRule(97, 75),
                new ManualPrintingInstructions.PageOrderingRule(47, 61),
                new ManualPrintingInstructions.PageOrderingRule(75, 61),
                new ManualPrintingInstructions.PageOrderingRule(47, 29),
                new ManualPrintingInstructions.PageOrderingRule(75, 13),
                new ManualPrintingInstructions.PageOrderingRule(53, 13));

        List<ManualPrintingInstructions.PagesToProduce> expectedPages = List.of(
                new ManualPrintingInstructions.PagesToProduce(List.of(75, 47, 61, 53, 29)),
                new ManualPrintingInstructions.PagesToProduce(List.of(97, 61, 53, 29, 13)),
                new ManualPrintingInstructions.PagesToProduce(List.of(75, 29, 13)),
                new ManualPrintingInstructions.PagesToProduce(List.of(75, 97, 47, 61, 53)),
                new ManualPrintingInstructions.PagesToProduce(List.of(61, 13, 29)),
                new ManualPrintingInstructions.PagesToProduce(List.of(97, 13, 75, 29, 47)));

        assertEquals(new ManualPrintingInstructions(expectedRules, expectedPages), parser.parse(validInputFileName));
    }

    @AfterEach
    public void tearDown() {
    }
}
