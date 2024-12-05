package tkrippes.com.github.adventofcode2024.day03.parser;

import tkrippes.com.github.adventofcode2024.day03.Multiplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class MultiplicationFilter {
    private Iterator<Map.Entry<Integer, Boolean>> shouldParseIterator;
    private Map.Entry<Integer, Boolean> shouldParseEntry;
    private boolean shouldParse;

    public List<Multiplication> filter(Map<Integer, Multiplication> multiplicationsMap, Map<Integer, Boolean> shouldParseMap) {
        if (shouldParseMap.isEmpty()) {
            return multiplicationsMap.values().stream().toList();
        }

        List<Multiplication> multiplications = new ArrayList<>();

        shouldParse = true;
        shouldParseIterator = shouldParseMap.entrySet().iterator();
        shouldParseEntry = shouldParseIterator.next();

        for (var multiplicationEntry : multiplicationsMap.entrySet()) {
            updateShouldParse(multiplicationEntry.getKey());

            if (shouldParse) {
                multiplications.add(multiplicationEntry.getValue());
            }
        }

        return multiplications;
    }

    private void updateShouldParse(int multiplicationPosition) {
        int shouldParsePosition = shouldParseEntry.getKey();

        while (multiplicationPosition > shouldParsePosition) {
            shouldParse = shouldParseEntry.getValue();

            if (!shouldParseIterator.hasNext()) {
                break;
            }

            shouldParseEntry = shouldParseIterator.next();
            shouldParsePosition = shouldParseEntry.getKey();
        }
    }
}