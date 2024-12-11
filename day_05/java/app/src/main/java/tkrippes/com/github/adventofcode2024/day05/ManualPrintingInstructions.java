package tkrippes.com.github.adventofcode2024.day05;

import java.util.List;

public record ManualPrintingInstructions(List<PageOrderingRule> rules,
                                         List<List<Integer>> updates) {
    public record PageOrderingRule(int pageToBePrintedBefore, int pageToBePrintedAfter) {
    }
}
