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
        int currentStep = 0;
        int numberOfUnsafeSteps = 0;

        for (int nextLevel : report.subList(1, report.size())) {
            int nextStep = nextLevel - currentLevel;
            if (isUnsafeStep(currentStep, nextStep)) {
                numberOfUnsafeSteps++;
            }

            currentLevel = nextLevel;
            currentStep = nextStep;
        }

        return numberOfUnsafeSteps <= tolerance;
    }

    private boolean isUnsafeStep(int currentStep, int nextStep) {
        final int minAllowedDifference = 1;
        final int maxAllowedDifference = 3;

        if (Math.abs(nextStep) < minAllowedDifference || Math.abs(nextStep) > maxAllowedDifference) {
            return true;
        }

        return isDirectionChanging(currentStep, nextStep);
    }

    private boolean isDirectionChanging(int currentStep, int nextStep) {
        if (nextStep == 0) {
            return true;
        }

        return haveDifferentSign(currentStep, nextStep);
    }

    private boolean haveDifferentSign(int firstNumber, int secondNumber) {
        if (firstNumber == 0 || secondNumber == 0) {
            return false;
        }

        return (firstNumber ^ secondNumber) < 0;
    }
}
