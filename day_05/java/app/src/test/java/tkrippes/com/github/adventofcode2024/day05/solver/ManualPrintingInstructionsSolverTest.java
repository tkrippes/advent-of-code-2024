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
    public void arePagesToProduceInRightOrderShouldThrowForEmptyOrderingMap() {
        assertThrows(IllegalArgumentException.class, () -> solver.arePagesToProduceInRightOrder(Map.of(),
                new ManualPrintingInstructions.PagesToProduce(List.of(25, 26))));
    }

    @Test
    public void arePagesInRightOrderShouldThrowForEmptyPagesToProduce() {
        assertThrows(IllegalArgumentException.class, () -> solver.arePagesToProduceInRightOrder(Map.of(25, Map.of(26, true),
                26, Map.of(25, false)), new ManualPrintingInstructions.PagesToProduce(List.of())));
    }

    @Test
    public void arePagesInRightOrderShouldThrowsIfPageHasNoEntryToProduceInOrderingMap() {
        assertThrows(IllegalArgumentException.class, () -> solver.arePagesToProduceInRightOrder(Map.of(25, Map.of(26, true),
                26, Map.of(25, false)), new ManualPrintingInstructions.PagesToProduce(List.of(25, 27))));
    }

    @Test
    public void arePagesInRightOrderShouldThrowsIfOtherPageHasNoEntryToProduceInOrderingMapOfPage() {
        assertThrows(IllegalArgumentException.class, () -> solver.arePagesToProduceInRightOrder(Map.of(25, Map.of(26, true, 27, true),
                26, Map.of(25, false, 27, true), 27, Map.of(25, false)), new ManualPrintingInstructions.PagesToProduce(List.of(25, 26, 27))));
    }

    @Test
    public void arePagesToProduceInRightOrderShouldReturnTrueForOnePage() {
        assertTrue(solver.arePagesToProduceInRightOrder(Map.of(25, Map.of(26, true), 26, Map.of(25, false)),
                new ManualPrintingInstructions.PagesToProduce(List.of(25))));
    }

    @Test
    public void arePagesInRightOrderShouldReturnTrueForTwoPagesToProduceInOrder() {
        assertTrue(solver.arePagesToProduceInRightOrder(Map.of(25, Map.of(26, true), 26, Map.of(25, false)),
                new ManualPrintingInstructions.PagesToProduce(List.of(25, 26))));
    }

    @Test
    public void arePagesInRightOrderShouldReturnFalseForTwoPagesToProduceInWrongOrder() {
        assertFalse(solver.arePagesToProduceInRightOrder(Map.of(25, Map.of(26, true), 26, Map.of(25, false)),
                new ManualPrintingInstructions.PagesToProduce(List.of(26, 25))));
    }

    @Test
    public void arePagesInRightOrderShouldReturnTrueForThreePagesToProduceInOrder() {
        assertTrue(solver.arePagesToProduceInRightOrder(Map.of(
                        25, Map.of(26, true, 27, true),
                        26, Map.of(25, false, 27, true),
                        27, Map.of(25, false, 26, false)),
                new ManualPrintingInstructions.PagesToProduce(List.of(25, 26, 27))));
    }

    @Test
    public void arePagesInRightOrderShouldReturnFalseForThreePagesToProduceInWrongOrder() {
        assertFalse(solver.arePagesToProduceInRightOrder(Map.of(
                        25, Map.of(26, true, 27, true),
                        26, Map.of(25, false, 27, true),
                        27, Map.of(25, false, 26, false)),
                new ManualPrintingInstructions.PagesToProduce(List.of(25, 27, 26))));
    }

    @Test
    public void arePagesToProduceInRightOrderShouldReturnTheCorrectResultsForTestInputFileContent() {
        Map<Integer, Map<Integer, Boolean>> orderingMap = Map.of(
                97, Map.of(53, true, 75, true, 13, true, 61, true, 29, true, 47, true),
                53, Map.of(97, false, 75, false, 29, true, 61, false, 13, true, 47, false),
                75, Map.of(97, false, 53, true, 29, true, 61, true, 13, true, 47, true),
                13, Map.of(97, false, 53, false, 75, false, 61, false, 29, false, 47, false),
                61, Map.of(97, false, 53, true, 75, false, 13, true, 29, true, 47, false),
                29, Map.of(97, false, 53, false, 75, false, 13, true, 61, false, 47, false),
                47, Map.of(97, false, 53, true, 75, false, 13, true, 61, true, 29, true)
        );

        assertTrue(solver.arePagesToProduceInRightOrder(orderingMap, new ManualPrintingInstructions.PagesToProduce(List.of(75, 47, 61, 53, 29))));
        assertTrue(solver.arePagesToProduceInRightOrder(orderingMap, new ManualPrintingInstructions.PagesToProduce(List.of(97, 61, 53, 29, 13))));
        assertTrue(solver.arePagesToProduceInRightOrder(orderingMap, new ManualPrintingInstructions.PagesToProduce(List.of(75, 29, 13))));
        assertFalse(solver.arePagesToProduceInRightOrder(orderingMap, new ManualPrintingInstructions.PagesToProduce(List.of(75, 97, 47, 61, 53))));
        assertFalse(solver.arePagesToProduceInRightOrder(orderingMap, new ManualPrintingInstructions.PagesToProduce(List.of(61, 13, 29))));
        assertFalse(solver.arePagesToProduceInRightOrder(orderingMap, new ManualPrintingInstructions.PagesToProduce(List.of(97, 13, 75, 29, 47))));
    }

    @Test
    public void solveShouldReturnTheCorrectResultForTestInputFileContent() {
        List<ManualPrintingInstructions.PageOrderingRule> rules = List.of(
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

        List<ManualPrintingInstructions.PagesToProduce> pages = List.of(
                new ManualPrintingInstructions.PagesToProduce(List.of(75, 47, 61, 53, 29)),
                new ManualPrintingInstructions.PagesToProduce(List.of(97, 61, 53, 29, 13)),
                new ManualPrintingInstructions.PagesToProduce(List.of(75, 29, 13)),
                new ManualPrintingInstructions.PagesToProduce(List.of(75, 97, 47, 61, 53)),
                new ManualPrintingInstructions.PagesToProduce(List.of(61, 13, 29)),
                new ManualPrintingInstructions.PagesToProduce(List.of(97, 13, 75, 29, 47)));

        assertEquals(143, solver.solve(new ManualPrintingInstructions(rules, pages)));
    }

    @AfterEach
    public void tearDown() {
    }
}
