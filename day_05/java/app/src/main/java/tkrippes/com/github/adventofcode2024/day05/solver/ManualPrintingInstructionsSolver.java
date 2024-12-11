package tkrippes.com.github.adventofcode2024.day05.solver;

import tkrippes.com.github.adventofcode2024.day05.ManualPrintingInstructions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManualPrintingInstructionsSolver {
    Map<Integer, Map<Integer, Boolean>> createPageOrderingMap(List<ManualPrintingInstructions.PageOrderingRule> rules) {
        Map<Integer, Map<Integer, Boolean>> orderingMap = new HashMap<>();

        for (ManualPrintingInstructions.PageOrderingRule rule : rules) {
            orderingMap.putIfAbsent(rule.pageToPrintedBefore(), new HashMap<>());
            orderingMap.get(rule.pageToPrintedBefore()).put(rule.pageToPrintedAfter(), true);

            orderingMap.putIfAbsent(rule.pageToPrintedAfter(), new HashMap<>());
            orderingMap.get(rule.pageToPrintedAfter()).put(rule.pageToPrintedBefore(), false);
        }

        return orderingMap;
    }

    boolean arePagesInRightOrder(Map<Integer, Map<Integer, Boolean>> orderingMap, ManualPrintingInstructions.PagesToProduce pagesToProduce) {
        if (orderingMap.isEmpty()) {
            throw new IllegalArgumentException("Ordering map is empty");
        }

        if (pagesToProduce.pages().isEmpty()) {
            throw new IllegalArgumentException("Pages to produce is empty");
        }

        List<Integer> pages = pagesToProduce.pages();
        for (int i = 0; i < pages.size(); i++) {
            int page = pages.get(i);
            if (!orderingMap.containsKey(page)) {
                throw new IllegalArgumentException("Page " + page + " is not in the ordering map");
            }

            // TODO throw if there is a missing entry in the orderingMap.get(page)
            // TODO check if all elements before have in map false and all elements after have in map true
        }

        return true;
    }
}
