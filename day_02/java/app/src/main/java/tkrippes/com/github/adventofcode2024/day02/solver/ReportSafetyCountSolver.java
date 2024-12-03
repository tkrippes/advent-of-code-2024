package tkrippes.com.github.adventofcode2024.day02.solver;

import java.util.List;

public class ReportSafetyCountSolver {
    public int solve(List<List<Integer>> reportList, int tolerance) {
        return (int) reportList.stream().filter(report -> isSafe(report, tolerance)).count();
    }

    protected boolean isSafe(List<Integer> report, int tolerance) {
        if (report.size() < 2) {
            throw new IllegalArgumentException("report must at least have 2 levels");
        }

        int currentLevel = report.getFirst();
        int initialStep = report.get(1) - report.get(0);
        int numberOfUnsafeSteps = 0;
        for (int nextLevel : report.subList(1, report.size())) {
            if (isUnsafeStep(initialStep, currentLevel, nextLevel)) {
                numberOfUnsafeSteps++;
            }

            currentLevel = nextLevel;
        }

        return numberOfUnsafeSteps <= tolerance;
    }

    private boolean isUnsafeStep(int initialStep, int currentLevel, int nextLevel) {
        final int minAllowedDifference = 1;
        final int maxAllowedDifference = 3;

        if (Math.abs(nextLevel - currentLevel) < minAllowedDifference || Math.abs(nextLevel - currentLevel) > maxAllowedDifference) {
            return true;
        }

        return isDirectionChanging(initialStep, currentLevel, nextLevel);
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
