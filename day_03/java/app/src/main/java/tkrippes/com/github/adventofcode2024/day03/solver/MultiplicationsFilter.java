package tkrippes.com.github.adventofcode2024.day03.solver;

import tkrippes.com.github.adventofcode2024.day03.Multiplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class MultiplicationsFilter {
    private Iterator<Map.Entry<Integer, Boolean>> filtersIterator;
    private Map.Entry<Integer, Boolean> filtersEntry;
    private boolean shouldFilter;

    public List<Multiplication> filter(Map<Integer, Multiplication> multiplicationsMap, Map<Integer, Boolean> filtersMap) {
        if (filtersMap.isEmpty()) {
            return multiplicationsMap.values().stream().toList();
        }

        List<Multiplication> multiplications = new ArrayList<>();

        shouldFilter = true;
        filtersIterator = filtersMap.entrySet().iterator();
        filtersEntry = filtersIterator.next();

        for (var multiplicationsEntry : multiplicationsMap.entrySet()) {
            updateShouldFilter(multiplicationsEntry.getKey());

            if (shouldFilter) {
                multiplications.add(multiplicationsEntry.getValue());
            }
        }

        return multiplications;
    }

    private void updateShouldFilter(int multiplicationPosition) {
        int filterPosition = filtersEntry.getKey();

        while (multiplicationPosition > filterPosition) {
            shouldFilter = filtersEntry.getValue();

            if (!filtersIterator.hasNext()) {
                break;
            }

            filtersEntry = filtersIterator.next();
            filterPosition = filtersEntry.getKey();
        }
    }
}