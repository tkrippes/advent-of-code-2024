package tkrippes.com.github.adventofcode2024.day05;

import java.util.List;

public record ManualPrintingInstructions(List<PageOrderingRule> rules,
                                         List<PageUpdate> updates) {
    public record PageOrderingRule(int pageToBePrintedBefore, int pageToBePrintedAfter) {
    }

    public record PageUpdate(List<Integer> pages) {
        public int getMiddlePage() {
            return pages.get(pages.size() / 2);
        }
    }
}
