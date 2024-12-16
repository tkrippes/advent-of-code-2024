package tkrippes.com.github.adventofcode2024.day07;

import java.util.ArrayList;
import java.util.List;

public enum Operation {
    ADDITION,
    MULTIPLICATION;

    public long apply(long operand1, long operand2) {
        return switch (this) {
            case ADDITION -> operand1 + operand2;
            case MULTIPLICATION -> operand1 * operand2;
        };
    }

    public static List<List<Operation>> getAllPossiblePermutations(int numberOfOperations) {
        List<List<Operation>> permutations = new ArrayList<>();
        List<Operation> operations = List.of(Operation.values());
        generatePermutations(new ArrayList<>(), numberOfOperations, operations, permutations);

        return permutations;
    }

    private static void generatePermutations(List<Operation> currentPermutation, int numberOfOperations,
                                             List<Operation> operations,
                                             List<List<Operation>> permutations) {
        if (currentPermutation.size() == numberOfOperations) {
            permutations.add(new ArrayList<>(currentPermutation));

            return;
        }

        for (Operation operation : operations) {
            currentPermutation.add(operation);
            generatePermutations(currentPermutation, numberOfOperations, operations, permutations);
            currentPermutation.removeLast();
        }
    }
}
