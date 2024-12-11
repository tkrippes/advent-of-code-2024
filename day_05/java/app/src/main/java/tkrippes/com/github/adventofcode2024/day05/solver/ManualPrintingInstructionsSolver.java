package tkrippes.com.github.adventofcode2024.day05.solver;

import tkrippes.com.github.adventofcode2024.day05.ManualPrintingInstructions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManualPrintingInstructionsSolver {
    public int solve(ManualPrintingInstructions instructions) {
        Map<Integer, Map<Integer, Boolean>> pageOrderingMap = createPageOrderingMap(instructions.rules());

        int result = 0;
        for (ManualPrintingInstructions.PagesToProduce pages : instructions.pagesList()) {
            if (arePagesToProduceInRightOrder(pageOrderingMap, pages)) {
                result += pages.getCenterPage();
            }
        }

        return result;
    }

    Map<Integer, Map<Integer, Boolean>> createPageOrderingMap(List<ManualPrintingInstructions.PageOrderingRule> rules) {
        Map<Integer, Map<Integer, Boolean>> pageOrderingMap = new HashMap<>();

        for (ManualPrintingInstructions.PageOrderingRule rule : rules) {
            pageOrderingMap.putIfAbsent(rule.pageToPrintedBefore(), new HashMap<>());
            pageOrderingMap.get(rule.pageToPrintedBefore()).put(rule.pageToPrintedAfter(), true);

            pageOrderingMap.putIfAbsent(rule.pageToPrintedAfter(), new HashMap<>());
            pageOrderingMap.get(rule.pageToPrintedAfter()).put(rule.pageToPrintedBefore(), false);
        }

        return pageOrderingMap;
    }

    boolean arePagesToProduceInRightOrder(Map<Integer, Map<Integer, Boolean>> pageOrderingMap, ManualPrintingInstructions.PagesToProduce pagesToProduce) {
        if (pageOrderingMap.isEmpty()) {
            throw new IllegalArgumentException("Page ordering map is empty");
        }

        if (pagesToProduce.pages().isEmpty()) {
            throw new IllegalArgumentException("Pages to produce are empty");
        }

        List<Integer> pages = pagesToProduce.pages();
        for (int pageIndex = 0; pageIndex < pages.size(); pageIndex++) {
            int page = pages.get(pageIndex);
            if (!pageOrderingMap.containsKey(page)) {
                throw new IllegalArgumentException("Page " + page + " has no entry in the ordering map");
            }

            Map<Integer, Boolean> orderingMapEntry = pageOrderingMap.get(page);
            if (isAnyPageBeforeNotSortedCorrectly(pageIndex, pages, orderingMapEntry) ||
                    isAnyPageAfterNotSortedCorrectly(pageIndex, pages, orderingMapEntry)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isAnyPageAfterNotSortedCorrectly(int pageIndex, List<Integer> pages, Map<Integer, Boolean> orderingMapEntry) {
        for (int i = pageIndex + 1; i < pages.size(); i++) {
            int pageAfter = pages.get(i);
            if (!orderingMapEntry.containsKey(pageAfter)) {
                throw new IllegalArgumentException("Page " + pages.get(pageIndex) + " does not have an entry for page after " + pageAfter + " in its ordering map");
            }

            if (!orderingMapEntry.get(pageAfter)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAnyPageBeforeNotSortedCorrectly(int pageIndex, List<Integer> pages, Map<Integer, Boolean> orderingMapForPage) {
        for (int i = 0; i < pageIndex; i++) {
            int pageBefore = pages.get(i);
            if (!orderingMapForPage.containsKey(pageBefore)) {
                throw new IllegalArgumentException("Page " + pages.get(pageIndex) + " does not have an entry for page before " + pageBefore + " in its ordering map");
            }

            if (orderingMapForPage.get(pageBefore)) {
                return true;
            }
        }
        return false;
    }
}
