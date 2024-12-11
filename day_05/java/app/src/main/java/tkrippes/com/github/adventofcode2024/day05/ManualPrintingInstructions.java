package tkrippes.com.github.adventofcode2024.day05;

import java.util.List;

public record ManualPrintingInstructions(List<PageOrderingRule> rules,
                                         List<PagesToProduce> pagesList) {
    public record PageOrderingRule(int pageToPrintedBefore, int pageToPrintedAfter) {
    }

    public record PagesToProduce(List<Integer> pages) {
        public int getCenterPage() {
            return pages.get(pages.size() / 2);
        }
    }
}
