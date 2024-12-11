package tkrippes.com.github.adventofcode2024.day05.solver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IncorrectlyOrderedUpdatesSolver extends ManualPrintingInstructionsSolver {
    protected int calculateResult(Map<Integer, Map<Integer, Boolean>> pageOrderingMap,
                                  List<List<Integer>> updates) {
        int result = 0;
        for (List<Integer> pages : updates) {
            if (!arePagesInRightOrder(pageOrderingMap, pages)) {
                result += getMiddlePage(getCorrectUpdate(pageOrderingMap, pages));
            }
        }

        return result;
    }

    private List<Integer> getCorrectUpdate(Map<Integer, Map<Integer, Boolean>> pageOrderingMap,
                                           List<Integer> pages) {
        Map<Integer, Integer> pagePriorityMap = new HashMap<>();
        for (int pageIndex = 0; pageIndex < pages.size(); pageIndex++) {
            int page = pages.get(pageIndex);
            if (!pageOrderingMap.containsKey(page)) {
                throw new IllegalArgumentException("Page " + page + " has no entry in the ordering map");
            }

            pagePriorityMap.put(page, getPriority(page, pages, pageOrderingMap.get(page)));
        }

        return pagePriorityMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .toList();
    }

    private static int getPriority(int page, List<Integer> pages, Map<Integer, Boolean> orderingMapEntry) {
        int priority = 0;
        for (int otherPage : pages.stream().filter(p -> p != page).toList()) {
            if (!orderingMapEntry.containsKey(otherPage)) {
                throw new IllegalArgumentException("Page " + page + " does not have an entry for other page " +
                        otherPage + " in its ordering map");
            }

            if (orderingMapEntry.get(otherPage)) {
                priority++;
            }
        }

        return priority;
    }
}
