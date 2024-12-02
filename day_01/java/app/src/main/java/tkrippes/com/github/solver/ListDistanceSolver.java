package tkrippes.com.github.solver;

import java.util.List;
import java.util.stream.Collectors;

public class ListDistanceSolver {
    // TODO change to private later
    public List<Integer> sort(List<Integer> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }

    // TODO change to private later
    public int distance(int firstNumber, int secondNumber) {
        return Math.abs(firstNumber - secondNumber);
    }
}
