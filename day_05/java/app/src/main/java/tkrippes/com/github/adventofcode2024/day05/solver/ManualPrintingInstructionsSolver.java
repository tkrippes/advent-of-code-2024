package tkrippes.com.github.adventofcode2024.day05.solver;

import tkrippes.com.github.adventofcode2024.day05.ManualPrintingInstructions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManualPrintingInstructionsSolver {
    Map<Integer, Map<Integer, Boolean>> createOrderingMap(List<ManualPrintingInstructions.PageOrderingRule> rules) {
        Map<Integer, Map<Integer, Boolean>> orderingMap = new HashMap<>();

        for (ManualPrintingInstructions.PageOrderingRule rule : rules) {
            orderingMap.putIfAbsent(rule.pageToPrintedBefore(), new HashMap<>());
            orderingMap.get(rule.pageToPrintedBefore()).put(rule.pageToPrintedAfter(), true);

            orderingMap.putIfAbsent(rule.pageToPrintedAfter(), new HashMap<>());
            orderingMap.get(rule.pageToPrintedAfter()).put(rule.pageToPrintedBefore(), false);
        }

        return orderingMap;
    }
}
