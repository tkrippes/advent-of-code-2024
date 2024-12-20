package tkrippes.com.github.adventofcode2024.day09.solver;

import tkrippes.com.github.adventofcode2024.day09.DiskMap;
import tkrippes.com.github.adventofcode2024.day09.disk.File;
import tkrippes.com.github.adventofcode2024.day09.disk.FreeSpace;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FilesystemChecksumSolverTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void solveForTestInputShouldReturnCorrectChecksum() {
        DiskMap map = new DiskMap(List.of(
                new File(2, 0), new FreeSpace(3), new File(3, 1), new FreeSpace(3),
                new File(1, 2), new FreeSpace(3), new File(3, 3), new FreeSpace(1),
                new File(2, 4), new FreeSpace(1), new File(4, 5), new FreeSpace(1),
                new File(4, 6), new FreeSpace(1), new File(3, 7), new FreeSpace(1),
                new File(4, 8), new FreeSpace(0), new File(2, 9)));

        assertEquals(1928, FilesystemChecksumSolver.solve(map));
    }

    @Test
    public void getCompactedFilesystemForTestInputShouldReturnCorrectFilesystem() {
        DiskMap map = new DiskMap(List.of(
                new File(2, 0), new FreeSpace(3), new File(3, 1), new FreeSpace(3),
                new File(1, 2), new FreeSpace(3), new File(3, 3), new FreeSpace(1),
                new File(2, 4), new FreeSpace(1), new File(4, 5), new FreeSpace(1),
                new File(4, 6), new FreeSpace(1), new File(3, 7), new FreeSpace(1),
                new File(4, 8), new FreeSpace(0), new File(2, 9)));

        assertEquals("0099811188827773336446555566..............",
                FilesystemChecksumSolver.getCompactedFilesystem(map));
    }

    @Test
    public void calculateChecksumForTestInputShouldReturnCorrectChecksum() {
        assertEquals(1928, FilesystemChecksumSolver.calculateChecksum("0099811188827773336446555566.............."));
    }

    @AfterEach
    public void tearDown() {
    }
}
