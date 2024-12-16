package tkrippes.com.github.adventofcode2024.day07;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OperationTest {
    private Operation additionOperation;
    private Operation multiplicationOperation;

    @BeforeEach
    public void setUp() {
        additionOperation = Operation.ADDITION;
        multiplicationOperation = Operation.MULTIPLICATION;
    }

    @Test
    public void applyShouldReturnCorrectResultForAddition() {
        assertEquals(5, additionOperation.apply(2, 3));
    }

    @Test
    public void applyShouldReturnCorrectResultForMultiplication() {
        assertEquals(6, multiplicationOperation.apply(2, 3));
    }

    @Test
    public void getAllPossiblePermutationsShouldReturnCorrectPermutationsForTwoOperations() {
        List<List<Operation>> expectedPermutations = List.of(
                List.of(Operation.ADDITION, Operation.ADDITION),
                List.of(Operation.ADDITION, Operation.MULTIPLICATION),
                List.of(Operation.MULTIPLICATION, Operation.ADDITION),
                List.of(Operation.MULTIPLICATION, Operation.MULTIPLICATION));

        assertEquals(expectedPermutations, additionOperation.getAllPossiblePermutations(2));
    }

    @Test
    public void getAllPossiblePermutationsShouldReturnCorrectPermutationsForThreeOperations() {
        List<List<Operation>> expectedPermutations = List.of(
                List.of(Operation.ADDITION, Operation.ADDITION, Operation.ADDITION),
                List.of(Operation.ADDITION, Operation.ADDITION, Operation.MULTIPLICATION),
                List.of(Operation.ADDITION, Operation.MULTIPLICATION, Operation.ADDITION),
                List.of(Operation.ADDITION, Operation.MULTIPLICATION, Operation.MULTIPLICATION),
                List.of(Operation.MULTIPLICATION, Operation.ADDITION, Operation.ADDITION),
                List.of(Operation.MULTIPLICATION, Operation.ADDITION, Operation.MULTIPLICATION),
                List.of(Operation.MULTIPLICATION, Operation.MULTIPLICATION, Operation.ADDITION),
                List.of(Operation.MULTIPLICATION, Operation.MULTIPLICATION, Operation.MULTIPLICATION));

        assertEquals(expectedPermutations, additionOperation.getAllPossiblePermutations(3));
    }

    @AfterEach
    public void tearDown() {
    }
}
