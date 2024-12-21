package tkrippes.com.github.adventofcode2024.day09.solver;

import tkrippes.com.github.adventofcode2024.day09.DiskMap;
import tkrippes.com.github.adventofcode2024.day09.disk.File;
import tkrippes.com.github.adventofcode2024.day09.disk.FilesystemEntity;
import tkrippes.com.github.adventofcode2024.day09.disk.FreeSpace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FilesystemChecksumSolver {
    public static long solve(DiskMap map) {
        return calculateChecksum(compactFilesystemLayout(getFilesystemLayout(map.filesystem())));
    }

    public static long solveV2(DiskMap map) {
        return calculateChecksum(getFilesystemLayout(compactFilesystem(map.filesystem())));
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

    static List<FilesystemEntity> compactFilesystem(List<FilesystemEntity> filesystem) {
        List<FilesystemEntity> compactedFilesystem = new ArrayList<>(filesystem);

        for (int backIndex = filesystem.size() - 1; backIndex >= 0; backIndex--) {
            int frontIndex = 0;
            frontIndex = skipFilesAtBeginning(compactedFilesystem, frontIndex);
            backIndex = skipFreeSpacesAtEnd(compactedFilesystem, backIndex);

            while (frontIndex < backIndex) {
                frontIndex = skipFilesAtBeginning(compactedFilesystem, frontIndex);

                int freeSpaceSize = ((FreeSpace) compactedFilesystem.get(frontIndex)).size();
                File file = (File) compactedFilesystem.get(backIndex);

                if (file.size() <= freeSpaceSize) {
                    backIndex = swapFreeSpaceAndFile(backIndex, file, freeSpaceSize, compactedFilesystem, frontIndex);

                    break;
                } else {
                    frontIndex++;
                }
            }
        }

        return compactedFilesystem;
    }

    private static int skipFilesAtBeginning(List<FilesystemEntity> compactedFilesystem, int frontIndex) {
        while (compactedFilesystem.get(frontIndex) instanceof File) {
            frontIndex++;
        }

        return frontIndex;
    }

    private static int skipFreeSpacesAtEnd(List<FilesystemEntity> compactedFilesystem, int backIndex) {
        while (compactedFilesystem.get(backIndex) instanceof FreeSpace) {
            backIndex--;
        }

        return backIndex;
    }

    private static int swapFreeSpaceAndFile(int backIndex, File file, int freeSpaceSize,
                                            List<FilesystemEntity> compactedFilesystem, int frontIndex) {
        backIndex = shrinkFreeSpaceAtBeginning(file.size(), freeSpaceSize, compactedFilesystem,
                frontIndex, backIndex);
        backIndex = doSwapFreeSpaceAndFile(backIndex, file, compactedFilesystem, frontIndex);
        backIndex = mergeFreeSpacesAtEnd(compactedFilesystem, backIndex);

        return backIndex;
    }

    private static int doSwapFreeSpaceAndFile(int backIndex, File file, List<FilesystemEntity> compactedFilesystem,
                                              int frontIndex) {
        compactedFilesystem.add(frontIndex, file);
        backIndex++;
        compactedFilesystem.set(backIndex, new FreeSpace(file.size()));

        return backIndex;
    }

    private static int shrinkFreeSpaceAtBeginning(int fileSize, int freeSpaceSize,
                                                  List<FilesystemEntity> compactedFilesystem, int frontIndex,
                                                  int backIndex) {
        if (fileSize < freeSpaceSize) {
            compactedFilesystem.set(frontIndex, new FreeSpace(freeSpaceSize - fileSize));
        } else {
            compactedFilesystem.remove(frontIndex);
            backIndex--;
        }

        return backIndex;
    }

    private static int mergeFreeSpacesAtEnd(List<FilesystemEntity> compactedFilesystem, int backIndex) {
        backIndex = mergeWithPrecedingFreeSpace(compactedFilesystem, backIndex);
        mergeWithSucceedingFreeSpace(compactedFilesystem, backIndex);

        return backIndex;
    }

    private static void mergeWithSucceedingFreeSpace(List<FilesystemEntity> compactedFilesystem, int backIndex) {
        if (backIndex + 1 < compactedFilesystem.size() && compactedFilesystem.get(backIndex + 1)
                instanceof FreeSpace(int freeSpaceSize)) {
            compactedFilesystem.set(backIndex,
                    new FreeSpace(freeSpaceSize + ((FreeSpace) compactedFilesystem.get(backIndex)).size()));
            compactedFilesystem.remove(backIndex + 1);
        }
    }

    private static int mergeWithPrecedingFreeSpace(List<FilesystemEntity> compactedFilesystem, int backIndex) {
        if (compactedFilesystem.get(backIndex - 1) instanceof FreeSpace(int freeSpaceSize)) {
            compactedFilesystem.set(backIndex,
                    new FreeSpace(freeSpaceSize + ((FreeSpace) compactedFilesystem.get(backIndex)).size()));
            compactedFilesystem.remove(backIndex - 1);
            backIndex--;
        }

        return backIndex;
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
