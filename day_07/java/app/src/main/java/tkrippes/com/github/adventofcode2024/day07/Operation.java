package tkrippes.com.github.adventofcode2024.day07;

public enum Operation {
    ADDITION,
    MULTIPLICATION;

    public int apply(int operand1, int operand2) {
        return switch (this) {
            case ADDITION -> operand1 + operand2;
            case MULTIPLICATION -> operand1 * operand2;
        };
    }
}
