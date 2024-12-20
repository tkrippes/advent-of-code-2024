package tkrippes.com.github.adventofcode2024.day09;

import tkrippes.com.github.adventofcode2024.day09.disk.File;
import tkrippes.com.github.adventofcode2024.day09.disk.FreeSpace;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiskMapTest {
    private DiskMap map;

    @BeforeEach
    public void setUp() {
        map = new DiskMap(List.of(
                new File(2, 0), new FreeSpace(3), new File(3, 1), new FreeSpace(3),
                new File(1, 2), new FreeSpace(3), new File(3, 3), new FreeSpace(1),
                new File(2, 4), new FreeSpace(1), new File(4, 5), new FreeSpace(1),
                new File(4, 6), new FreeSpace(1), new File(3, 7), new FreeSpace(1),
                new File(4, 8), new FreeSpace(0), new File(2, 9)));
    }

    @Test
    public void toStringShouldReturnCorrectString() {
        assertEquals("00...111...2...333.44.5555.6666.777.888899", map.toString());
    }

    @AfterEach
    public void tearDown() {
    }
}
