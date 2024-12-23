package tkrippes.com.github.adventofcode2024.day09.solver;

import tkrippes.com.github.adventofcode2024.day09.DiskMap;
import tkrippes.com.github.adventofcode2024.day09.disk.File;
import tkrippes.com.github.adventofcode2024.day09.disk.FilesystemEntity;
import tkrippes.com.github.adventofcode2024.day09.disk.FreeSpace;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FilesystemChecksumSolver {
    public static long solve(DiskMap map) {
        throw new UnsupportedOperationException("TODO: Implement in subclass");
    }

    static List<Integer> getFilesystemLayout(List<FilesystemEntity> filesystem) {
        return filesystem.stream()
                .flatMap(entity -> {
                    if (entity instanceof File(int size, int id)) {
                        return java.util.Collections.nCopies(size, id).stream();
                    } else if (entity instanceof FreeSpace(int size)) {
                        return java.util.Collections.nCopies(size, -1).stream();
                    }

                    return java.util.stream.Stream.empty();
                }).toList();
    }

    static long calculateChecksum(List<Integer> filesystemLayout) {
        AtomicInteger index = new AtomicInteger();

        return filesystemLayout.stream()
                .mapToLong(Integer::longValue)
                .reduce(0L, (sum, value) -> {
                    if (value != -1) {
                        sum += index.get() * value;
                    }
                    index.getAndIncrement();

                    return sum;
                });
    }
}
