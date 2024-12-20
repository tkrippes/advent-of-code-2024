package tkrippes.com.github.adventofcode2024.day09.solver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilesystemChecksumSolverTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void calculateChecksumForTestInputShouldReturnCorrectChecksum() {
        assertEquals(1928, FilesystemChecksumSolver.calculateChecksum("0099811188827773336446555566.............."));
    }

    @AfterEach
    public void tearDown() {
    }
}
