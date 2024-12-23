package tkrippes.com.github.adventofcode2024.day09.solver;

import tkrippes.com.github.adventofcode2024.day09.DiskMap;
import tkrippes.com.github.adventofcode2024.day09.disk.File;
import tkrippes.com.github.adventofcode2024.day09.disk.FreeSpace;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FilesystemChecksumSolverV1Test {
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
                new File(4, 8), new File(2, 9)));

        assertEquals(1928, FilesystemChecksumSolverV1.solve(map));
    }

    @Test
    public void compactFilesystemLayoutForTestInputShouldReturnCorrectFilesystem() {
        List<Integer> layout = List.of(0, 0, -1, -1, -1, 1, 1, 1, -1, -1, -1, 2, -1, -1, -1,
                3, 3, 3, -1, 4, 4, -1, 5, 5, 5, 5, -1, 6, 6, 6, 6, -1, 7, 7, 7, -1, 8, 8, 8, 8, 9, 9);

        List<Integer> expectedCompactedLayout = List.of(0, 0, 9, 9, 8, 1, 1, 1, 8, 8, 8, 2, 7, 7, 7, 3, 3, 3, 6, 4,
                4, 6, 5, 5, 5, 5, 6, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);

        assertEquals(expectedCompactedLayout,
                FilesystemChecksumSolverV1.compactFilesystemLayout(layout));
    }

    @Test
    public void compactFilesystemLayoutForTestInputPlusTwoDigitsFileIdShouldReturnCorrectFilesystem() {
        List<Integer> layout = List.of(0, 0, -1, -1, -1, 1, 1, 1, -1, -1, -1, 2, -1, -1, -1,
                3, 3, 3, -1, 4, 4, -1, 5, 5, 5, 5, -1, 6, 6, 6, 6, -1, 7, 7, 7, -1, 8, 8, 8, 8, 9, 9, -1, 10);

        List<Integer> expectedCompactedLayout = List.of(0, 0, 10, 9, 9, 1, 1, 1, 8, 8, 8, 2, 8, 7, 7, 3, 3, 3, 7,
                4, 4, 6, 5, 5, 5, 5, 6, 6, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);

        assertEquals(expectedCompactedLayout,
                FilesystemChecksumSolverV1.compactFilesystemLayout(layout));
    }

    @AfterEach
    public void tearDown() {
    }
}
