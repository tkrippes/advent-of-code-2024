package tkrippes.com.github.adventofcode2024.day02.solver;

import java.util.List;

public class ReportSafetyCountSolver {
    // TODO make private
    public boolean isSafe(List<Integer> report) {
        if (report.size() < 2) {
            return true;
        }

        int currentLevel = report.getFirst();
        int initialStep = report.get(1) - report.get(0);
        for (int nextLevel : report.subList(1, report.size())) {
            if (isUnsafeStep(currentLevel, nextLevel)) {
                return false;
            }

            if (isDirectionChanging(initialStep, currentLevel, nextLevel)) {
                return false;
            }

            currentLevel = nextLevel;
        }

        return true;
    }

    private boolean isUnsafeStep(int currentLevel, int nextLevel) {
        final int minAllowedDifference = 1;
        final int maxAllowedDifference = 3;

        return Math.abs(nextLevel - currentLevel) < minAllowedDifference || Math.abs(nextLevel - currentLevel) > maxAllowedDifference;
    }

    private boolean isDirectionChanging(int initialStep, int currentLevel, int nextLevel) {
        if (initialStep == 0) {
            return true;
        }

        return haveDifferentSign(initialStep, nextLevel - currentLevel);
    }

    private boolean haveDifferentSign(int firstNumber, int secondNumber) {
        return (firstNumber ^ secondNumber) < 0;
    }
}
