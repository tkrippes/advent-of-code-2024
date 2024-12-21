package tkrippes.com.github.adventofcode2024.day09.solver;

import tkrippes.com.github.adventofcode2024.day09.DiskMap;
import tkrippes.com.github.adventofcode2024.day09.disk.File;
import tkrippes.com.github.adventofcode2024.day09.disk.FreeSpace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FilesystemChecksumSolver {
    public static long solve(DiskMap map) {
        return calculateChecksum(compactFilesystemLayout(getFilesystemLayout(map)));
    }

    static List<Integer> getFilesystemLayout(DiskMap map) {
        return map.filesystem().stream()
                .flatMap(entity -> {
                    if (entity instanceof File(int size, int id)) {
                        return java.util.Collections.nCopies(size, id).stream();
                    } else if (entity instanceof FreeSpace(int size)) {
                        return java.util.Collections.nCopies(size, -1).stream();
                    }

                    return java.util.stream.Stream.empty();
                }).toList();
    }

    static List<Integer> compactFilesystemLayout(List<Integer> filesystemLayout) {
        int frontIndex = 0;
        int backIndex = filesystemLayout.size() - 1;
        List<Integer> compactedFilesystemLayout = new ArrayList<>(filesystemLayout);

        while (frontIndex < backIndex) {
            if (compactedFilesystemLayout.get(frontIndex) != -1) {
                frontIndex++;
            } else if (compactedFilesystemLayout.get(backIndex) == -1) {
                backIndex--;
            } else {
                Collections.swap(compactedFilesystemLayout, frontIndex, backIndex);
            }
        }

        return compactedFilesystemLayout;
    }

    static long calculateChecksum(List<Integer> compactedFilesystemLayout) {
        AtomicInteger index = new AtomicInteger();

        return compactedFilesystemLayout.stream()
                .takeWhile(i -> i != -1)
                .mapToLong(Integer::longValue)
                .reduce(0L, (sum, value) -> sum + index.getAndIncrement() * value);
    }
}
