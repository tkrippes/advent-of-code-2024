package tkrippes.com.github.adventofcode2024.day09.solver;

import tkrippes.com.github.adventofcode2024.day09.DiskMap;
import tkrippes.com.github.adventofcode2024.day09.disk.File;
import tkrippes.com.github.adventofcode2024.day09.disk.FilesystemEntity;
import tkrippes.com.github.adventofcode2024.day09.disk.FreeSpace;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FilesystemChecksumSolverV2Test {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void solveV2ForTestInputShouldReturnCorrectChecksum() {
        DiskMap map = new DiskMap(List.of(
                new File(2, 0), new FreeSpace(3), new File(3, 1), new FreeSpace(3),
                new File(1, 2), new FreeSpace(3), new File(3, 3), new FreeSpace(1),
                new File(2, 4), new FreeSpace(1), new File(4, 5), new FreeSpace(1),
                new File(4, 6), new FreeSpace(1), new File(3, 7), new FreeSpace(1),
                new File(4, 8), new File(2, 9)));

        assertEquals(2858, FilesystemChecksumSolverV2.solve(map));
    }

    @Test
    public void compactFilesystemForTestInputShouldReturnCorrectFilesystem() {
        List<FilesystemEntity> filesystem = List.of(
                new File(2, 0), new FreeSpace(3), new File(3, 1), new FreeSpace(3),
                new File(1, 2), new FreeSpace(3), new File(3, 3), new FreeSpace(1),
                new File(2, 4), new FreeSpace(1), new File(4, 5), new FreeSpace(1),
                new File(4, 6), new FreeSpace(1), new File(3, 7), new FreeSpace(1),
                new File(4, 8), new File(2, 9));

        List<FilesystemEntity> expectedFilesystem = List.of(
                new File(2, 0), new File(2, 9), new File(1, 2), new File(3, 1),
                new File(3, 7), new FreeSpace(1), new File(2, 4), new FreeSpace(1),
                new File(3, 3), new FreeSpace(4), new File(4, 5), new FreeSpace(1),
                new File(4, 6), new FreeSpace(5), new File(4, 8), new FreeSpace(2));

        assertEquals(expectedFilesystem,
                FilesystemChecksumSolverV2.compactFilesystem(filesystem));
    }

    @AfterEach
    public void tearDown() {
    }
}
