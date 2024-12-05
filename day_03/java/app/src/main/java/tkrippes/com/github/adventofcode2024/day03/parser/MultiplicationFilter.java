package tkrippes.com.github.adventofcode2024.day03.parser;

import tkrippes.com.github.adventofcode2024.day03.Multiplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class MultiplicationFilter {
    public List<Multiplication> filter(Map<Integer, Multiplication> multiplicationsMap, Map<Integer, Boolean> shouldParseMap) {
        if (shouldParseMap.isEmpty()) {
            return multiplicationsMap.values().stream().toList();
        }

        List<Multiplication> multiplications = new ArrayList<>();

        boolean shouldParse = true;
        var shouldParseIterator = shouldParseMap.entrySet().iterator();
        var shouldParseEntry = shouldParseIterator.next();

        for (var multiplicationEntry : multiplicationsMap.entrySet()) {
            int multiplicationPosition = multiplicationEntry.getKey();
            int shouldParsePosition = shouldParseEntry.getKey();

            while (multiplicationPosition > shouldParsePosition) {
                shouldParse = shouldParseEntry.getValue();

                if (!shouldParseIterator.hasNext()) {
                    break;
                }

                shouldParseEntry = shouldParseIterator.next();
                shouldParsePosition = shouldParseEntry.getKey();
            }

            if (shouldParse) {
                multiplications.add(multiplicationEntry.getValue());
            }
        }

        return multiplications;
    }
}