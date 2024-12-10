package tkrippes.com.github.adventofcode2024.day05;

import java.util.List;

public record ManualPrintingInstructions(List<PageOrderingRule> pageOrderingRules,
                                         List<PagesToProduce> pagesToProduceEachUpdate) {
    public record PageOrderingRule(int pageToPrintedBefore, int pageToPrintedAfter) {
    }

    public record PagesToProduce(List<Integer> pages) {
    }
}
