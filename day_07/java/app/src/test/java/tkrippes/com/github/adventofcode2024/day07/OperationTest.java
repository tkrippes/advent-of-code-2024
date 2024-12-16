package tkrippes.com.github.adventofcode2024.day07;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @AfterEach
    public void tearDown() {
    }
}
