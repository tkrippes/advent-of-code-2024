package tkrippes.com.github.adventofcode2024.day05.solver;

import tkrippes.com.github.adventofcode2024.day05.ManualPrintingInstructions;

import java.util.List;
import java.util.Map;

public class CorrectlyOrderedUpdatesSolver extends ManualPrintingInstructionsSolver {
    protected int calculateResult(Map<Integer, Map<Integer, Boolean>> pageOrderingMap,
                                  List<ManualPrintingInstructions.PageUpdate> updates) {
        int result = 0;
        for (ManualPrintingInstructions.PageUpdate update : updates) {
            if (isPageUpdateInRightOrder(pageOrderingMap, update)) {
                result += update.getMiddlePage();
            }
        }

        return result;
    }
}
