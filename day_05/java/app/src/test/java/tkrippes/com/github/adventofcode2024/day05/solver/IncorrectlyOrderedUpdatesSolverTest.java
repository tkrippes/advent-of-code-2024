package tkrippes.com.github.adventofcode2024.day05.solver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tkrippes.com.github.adventofcode2024.day05.ManualPrintingInstructions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncorrectlyOrderedUpdatesSolverTest {
    private IncorrectlyOrderedUpdatesSolver solver;

    @BeforeEach
    public void setUp() {
        solver = new IncorrectlyOrderedUpdatesSolver();
    }

    @Test
    public void testSolve() {
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

        List<List<Integer>> updates = List.of(List.of(75, 47, 61, 53, 29), List.of(97, 61, 53, 29, 13),
                List.of(75, 29, 13), List.of(75, 97, 47, 61, 53), List.of(61, 13, 29), List.of(97, 13, 75, 29, 47));

        assertEquals(123, solver.solve(new ManualPrintingInstructions(rules, updates)));
    }

    @AfterEach
    public void tearDown() {
    }
}
