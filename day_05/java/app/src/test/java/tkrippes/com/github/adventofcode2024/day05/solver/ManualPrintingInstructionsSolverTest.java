package tkrippes.com.github.adventofcode2024.day05.solver;

import tkrippes.com.github.adventofcode2024.day05.ManualPrintingInstructions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ManualPrintingInstructionsSolverTest {
    private ManualPrintingInstructionsSolver solver;

    @BeforeEach
    public void setUp() {
        solver = new ManualPrintingInstructionsSolver();
    }

    @Test
    public void createPageOrderingMapShouldBeEmptyForEmptyRules() {
        assertTrue(solver.createPageOrderingMap(List.of()).isEmpty());
    }

    @Test
    public void createOrderingMapForOneRuleShouldReturnCorrectPageOrderingMap() {
        List<ManualPrintingInstructions.PageOrderingRule> rules = List.of(
                new ManualPrintingInstructions.PageOrderingRule(25, 26)
        );

        assertEquals(Map.of(25, Map.of(26, true), 26, Map.of(25, false)), solver.createPageOrderingMap(rules));
    }

    @Test
    public void createOrderingMapForTwoIndependentRulesShouldReturnCorrectPageOrderingMap() {
        List<ManualPrintingInstructions.PageOrderingRule> rules = List.of(
                new ManualPrintingInstructions.PageOrderingRule(25, 26),
                new ManualPrintingInstructions.PageOrderingRule(27, 28)
        );

        assertEquals(Map.of(25, Map.of(26, true), 26, Map.of(25, false),
                27, Map.of(28, true), 28, Map.of(27, false)), solver.createPageOrderingMap(rules));
    }

    @Test
    public void createOrderingMapForTwoDependentRulesShouldReturnCorrectPageOrderingMap() {
        List<ManualPrintingInstructions.PageOrderingRule> rules = List.of(
                new ManualPrintingInstructions.PageOrderingRule(25, 26),
                new ManualPrintingInstructions.PageOrderingRule(26, 27)
        );

        assertEquals(Map.of(25, Map.of(26, true), 26, Map.of(25, false, 27, true),
                27, Map.of(26, false)), solver.createPageOrderingMap(rules));
    }

    @Test
    public void createOrderingMapForThreeRulesThatHaveTheSameNumberInFrontShouldReturnCorrectPageOrderingMap() {
        List<ManualPrintingInstructions.PageOrderingRule> rules = List.of(
                new ManualPrintingInstructions.PageOrderingRule(25, 26),
                new ManualPrintingInstructions.PageOrderingRule(25, 27),
                new ManualPrintingInstructions.PageOrderingRule(25, 28)
        );

        assertEquals(Map.of(25, Map.of(26, true, 27, true, 28, true), 26, Map.of(25, false),
                27, Map.of(25, false), 28, Map.of(25, false)), solver.createPageOrderingMap(rules));
    }

    @Test
    public void createOrderingMapForThreeRulesThatHaveTheSameNumberInBackShouldReturnCorrectPageOrderingMap() {
        List<ManualPrintingInstructions.PageOrderingRule> rules = List.of(
                new ManualPrintingInstructions.PageOrderingRule(25, 28),
                new ManualPrintingInstructions.PageOrderingRule(26, 28),
                new ManualPrintingInstructions.PageOrderingRule(27, 28)
        );

        assertEquals(Map.of(25, Map.of(28, true), 26, Map.of(28, true),
                27, Map.of(28, true), 28, Map.of(25, false, 26, false, 27, false)), solver.createPageOrderingMap(rules));
    }

    @Test
    public void arePagesInRightOrderShouldThrowForEmptyOrderingMap() {
        assertThrows(IllegalArgumentException.class, () -> solver.arePagesInRightOrder(Map.of(),
                new ManualPrintingInstructions.PagesToProduce(List.of(25, 26))));
    }

    @Test
    public void arePagesInRightOrderShouldThrowForEmptyPages() {
        assertThrows(IllegalArgumentException.class, () -> solver.arePagesInRightOrder(Map.of(25, Map.of(26, true),
                26, Map.of(25, false)), new ManualPrintingInstructions.PagesToProduce(List.of())));
    }

    @Test
    public void arePagesInRightOrderShouldThrowIfPageHasNoEntryInOrderingMap() {
        assertThrows(IllegalArgumentException.class, () -> solver.arePagesInRightOrder(Map.of(25, Map.of(26, true),
                26, Map.of(25, false)), new ManualPrintingInstructions.PagesToProduce(List.of(25, 27))));
    }

    @AfterEach
    public void tearDown() {
    }
}
