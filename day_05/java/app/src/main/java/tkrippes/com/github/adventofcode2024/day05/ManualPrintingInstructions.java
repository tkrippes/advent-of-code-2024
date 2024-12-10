package tkrippes.com.github.adventofcode2024.day05;

import java.util.List;

public record ManualPrintingInstructions(List<PageOrderingRule> pageOrderingRules, List<Integer> pagesToBePrinted) {
    public record PageOrderingRule(int pageToPrintedBefore, int pageToPrintedAfter) {
    }
}
