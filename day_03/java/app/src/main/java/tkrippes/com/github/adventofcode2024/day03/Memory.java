package tkrippes.com.github.adventofcode2024.day03;

import java.util.List;

public record Memory(List<Multiplication> multiplications) {
    public record Multiplication(int firstNumber, int secondNumber) {
    }
}
