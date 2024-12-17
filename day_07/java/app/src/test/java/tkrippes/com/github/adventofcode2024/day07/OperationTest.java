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
    public void applyShouldReturnCorrectResultForConcatenation() {
        assertEquals(23, Operation.CONCATENATION.apply(2, 3));
    }

    @Test
    public void getAllPossiblePermutationsShouldReturnCorrectPermutationsForOneOperation() {
        List<List<Operation>> expectedPermutations = List.of(
                List.of(Operation.ADDITION),
                List.of(Operation.MULTIPLICATION));

        assertEquals(expectedPermutations, Operation.getAllPossiblePermutations(1, false));
    }

    @Test
    public void getAllPossiblePermutationsShouldReturnCorrectPermutationsForOneOperationIncludingConcatenation() {
        List<List<Operation>> expectedPermutations = List.of(
                List.of(Operation.ADDITION),
                List.of(Operation.MULTIPLICATION),
                List.of(Operation.CONCATENATION));

        assertEquals(expectedPermutations, Operation.getAllPossiblePermutations(1, true));
    }

    @Test
    public void getAllPossiblePermutationsShouldReturnCorrectPermutationsForTwoOperations() {
        List<List<Operation>> expectedPermutations = List.of(
                List.of(Operation.ADDITION, Operation.ADDITION),
                List.of(Operation.ADDITION, Operation.MULTIPLICATION),
                List.of(Operation.MULTIPLICATION, Operation.ADDITION),
                List.of(Operation.MULTIPLICATION, Operation.MULTIPLICATION));

        assertEquals(expectedPermutations, Operation.getAllPossiblePermutations(2, false));
    }

    @Test
    public void getAllPossiblePermutationsShouldReturnCorrectPermutationsForTwoOperationsIncludingConcatenation() {
        List<List<Operation>> expectedPermutations = List.of(
                List.of(Operation.ADDITION, Operation.ADDITION),
                List.of(Operation.ADDITION, Operation.MULTIPLICATION),
                List.of(Operation.ADDITION, Operation.CONCATENATION),
                List.of(Operation.MULTIPLICATION, Operation.ADDITION),
                List.of(Operation.MULTIPLICATION, Operation.MULTIPLICATION),
                List.of(Operation.MULTIPLICATION, Operation.CONCATENATION),
                List.of(Operation.CONCATENATION, Operation.ADDITION),
                List.of(Operation.CONCATENATION, Operation.MULTIPLICATION),
                List.of(Operation.CONCATENATION, Operation.CONCATENATION));

        assertEquals(expectedPermutations, Operation.getAllPossiblePermutations(2, true));
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

        assertEquals(expectedPermutations, Operation.getAllPossiblePermutations(3, false));
    }

    @AfterEach
    public void tearDown() {
    }
}
