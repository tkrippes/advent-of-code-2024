package tkrippes.com.github.adventofcode2024.day05.solver;

import java.util.List;
import java.util.Map;

public class CorrectlyOrderedUpdatesSolver extends ManualPrintingInstructionsSolver {
    protected int calculateResult(Map<Integer, Map<Integer, Boolean>> pageOrderingMap,
                                  List<List<Integer>> updates) {
        int result = 0;
        for (List<Integer> pages : updates) {
            if (arePagesInRightOrder(pageOrderingMap, pages)) {
                result += getMiddlePage(pages);
            }
        }

        return result;
    }
}
