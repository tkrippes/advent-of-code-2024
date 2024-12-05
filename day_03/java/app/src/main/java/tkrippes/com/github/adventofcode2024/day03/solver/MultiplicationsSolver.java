package tkrippes.com.github.adventofcode2024.day03.solver;

import tkrippes.com.github.adventofcode2024.day03.Multiplication;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MultiplicationsSolver {
    private final MultiplicationsFilter filter = new MultiplicationsFilter();

    public int solve(Map<Integer, Multiplication> multiplicationsMap, Map<Integer, Boolean> filtersMap) {
        List<Multiplication> multiplications = filtersMap.isEmpty() ?
                multiplicationsMap.values().stream().toList() :
                filter.filter(new TreeMap<>(multiplicationsMap), new TreeMap<>(filtersMap));

        return multiplications.stream()
                .map(multiplication -> multiplication.firstMultiplicand() * multiplication.secondMultiplicand())
                .reduce(0, Integer::sum);
    }
}
