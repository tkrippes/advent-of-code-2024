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

            Map<Integer, Boolean> orderingMapForPage = orderingMap.get(page);
            for (int j = 0; j < i; j++) {
                int pageBefore = pages.get(j);
                if (!orderingMapForPage.containsKey(pageBefore)) {
                    throw new IllegalArgumentException("Page " + page + " does not have page before " + pageBefore + " in the ordering map");
                }

                if (orderingMapForPage.get(pageBefore)) {
                    return false;
                }
            }

            for (int j = i + 1; j < pages.size(); j++) {
                int pageAfter = pages.get(j);
                if (!orderingMapForPage.containsKey(pageAfter)) {
                    throw new IllegalArgumentException("Page " + page + " does not have page after " + pageAfter + " in the ordering map");
                }

                if (!orderingMapForPage.get(pageAfter)) {
                    return false;
                }
            }
        }

        return true;
    }
}
