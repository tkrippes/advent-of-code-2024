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
    public void parseInstructionsThrowsOnEmptyInputs() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseInstructions(List.of()));
    }

    @Test
    public void parseInstructionsThrowsOnMissingEmptyLine() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseInstructions(List.of("25|26",
                "25,26")));
    }

    @Test
    public void parseInstructionsThrowsOnMissingRules() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseInstructions(List.of("",
                "25,26")));
    }

    @Test
    public void parseInstructionsThrowsOnMissingPages() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseInstructions(List.of("25|26",
                "")));
    }

    @Test
    public void parseInstructionsReturnsInstructionsCorrectly() {
        List<ManualPrintingInstructions.PageOrderingRule> expectedRules = List.of(
                new ManualPrintingInstructions.PageOrderingRule(25, 26),
                new ManualPrintingInstructions.PageOrderingRule(26, 27),
                new ManualPrintingInstructions.PageOrderingRule(27, 28),
                new ManualPrintingInstructions.PageOrderingRule(28, 29),
                new ManualPrintingInstructions.PageOrderingRule(29, 30));

        List<ManualPrintingInstructions.PageUpdate> expectedUpdates = List.of(
                new ManualPrintingInstructions.PageUpdate(List.of(25, 26, 27)),
                new ManualPrintingInstructions.PageUpdate(List.of(25, 27, 29)),
                new ManualPrintingInstructions.PageUpdate(List.of(30, 28, 26)),
                new ManualPrintingInstructions.PageUpdate(List.of(25, 28, 27, 30, 29, 26)));

        assertEquals(new ManualPrintingInstructions(expectedRules, expectedUpdates),
                parser.parseInstructions(List.of("25|26", "26|27", "27|28", "28|29", "29|30", "",
                        "25,26,27", "25,27,29", "30,28,26", "25,28,27,30,29,26")));
    }

    @Test
    public void parseRuleThrowsOnEmptyRule() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseRule(""));
    }

    @Test
    public void parseRuleThrowsOnSingleNumberRule() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseRule("25"));
    }

    @Test
    public void parseRuleThrowsOnMissingNumbersRule() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseRule("|"));
    }

    @Test
    public void parseRuleThrowsOnMissingFirstNumberRule() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseRule("|26"));
    }

    @Test
    public void parseRuleThrowsOnMissingSecondNumberRule() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseRule("25|"));
    }

    @Test
    public void parseRuleThrowsOnNonNumbersRule() {
        assertThrows(NumberFormatException.class, () -> parser.parseRule("AB|CD"));
    }

    @Test
    public void parseRuleThrowsOnThreeNumbersRule() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseRule("25|26|27"));
    }

    @Test
    public void parseRuleThrowsOnTwoNumbersIncludingSpacesRule() {
        assertThrows(NumberFormatException.class, () -> parser.parseRule("25 | 26"));
    }

    @Test
    public void parseRuleTwoNumbersRuleCalculatesRuleCorrectly() {
        assertEquals(new ManualPrintingInstructions.PageOrderingRule(25, 26),
                parser.parseRule("25|26"));
    }

    @Test
    public void parseUpdateThrowsOnEmptyPages() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseUpdate(""));
    }

    @Test
    public void parseUpdateThrowsOnMissingNumbersPages() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseUpdate(","));
    }

    @Test
    public void parseUpdateThrowsOnMissingFirstNumberPages() {
        assertThrows(NumberFormatException.class, () -> parser.parseUpdate(",26"));
    }

    @Test
    public void parseUpdateThrowsOnNonNumbersPages() {
        assertThrows(NumberFormatException.class, () -> parser.parseUpdate("AB,CD"));
    }

    @Test
    public void parseUpdateThrowsOnTwoNumbersIncludingSpacesPages() {
        assertThrows(NumberFormatException.class, () -> parser.parseUpdate("25, 26"));
    }

    @Test
    public void parseUpdateSingleNumberPagesReturnsCorrectly() {
        assertEquals(new ManualPrintingInstructions.PageUpdate(List.of(25)),
                parser.parseUpdate("25"));
    }

    @Test
    public void parseUpdateTwoNumbersPagesReturnsCorrectly() {
        assertEquals(new ManualPrintingInstructions.PageUpdate(List.of(25, 26)),
                parser.parseUpdate("25,26"));
    }

    @Test
    public void parseUpdateOmitsEmptyNumberPageUpdateAtTheEnd() {
        assertEquals(new ManualPrintingInstructions.PageUpdate(List.of(25, 26)),
                parser.parseUpdate("25,26,"));
    }

    @Test
    public void parseUpdateTenNumbersPagesReturnCorrectly() {
        assertEquals(new ManualPrintingInstructions.PageUpdate(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
                parser.parseUpdate("1,2,3,4,5,6,7,8,9,10"));
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

        List<ManualPrintingInstructions.PageUpdate> expectedUpdates = List.of(
                new ManualPrintingInstructions.PageUpdate(List.of(75, 47, 61, 53, 29)),
                new ManualPrintingInstructions.PageUpdate(List.of(97, 61, 53, 29, 13)),
                new ManualPrintingInstructions.PageUpdate(List.of(75, 29, 13)),
                new ManualPrintingInstructions.PageUpdate(List.of(75, 97, 47, 61, 53)),
                new ManualPrintingInstructions.PageUpdate(List.of(61, 13, 29)),
                new ManualPrintingInstructions.PageUpdate(List.of(97, 13, 75, 29, 47)));

        assertEquals(new ManualPrintingInstructions(expectedRules, expectedUpdates), parser.parse(validInputFileName));
    }

    @AfterEach
    public void tearDown() {
    }
}
