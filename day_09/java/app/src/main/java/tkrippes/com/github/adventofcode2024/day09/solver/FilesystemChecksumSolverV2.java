package tkrippes.com.github.adventofcode2024.day09.solver;

import tkrippes.com.github.adventofcode2024.day09.DiskMap;
import tkrippes.com.github.adventofcode2024.day09.disk.File;
import tkrippes.com.github.adventofcode2024.day09.disk.FilesystemEntity;
import tkrippes.com.github.adventofcode2024.day09.disk.FreeSpace;

import java.util.ArrayList;
import java.util.List;

public class FilesystemChecksumSolverV2 extends FilesystemChecksumSolver {
    public static long solve(DiskMap map) {
        return calculateChecksum(getFilesystemLayout(compactFilesystem(map.filesystem())));
    }

    static List<FilesystemEntity> compactFilesystem(List<FilesystemEntity> filesystem) {
        List<FilesystemEntity> compactedFilesystem = new ArrayList<>(filesystem);

        for (int backIndex = filesystem.size() - 1; backIndex >= 0; backIndex--) {
            int frontIndex = 0;
            frontIndex = skipFilesAtBeginning(compactedFilesystem, frontIndex);
            backIndex = skipFreeSpacesAtEnd(compactedFilesystem, backIndex);

            while (frontIndex < backIndex) {
                frontIndex = skipFilesAtBeginning(compactedFilesystem, frontIndex);
                if (frontIndex >= backIndex) {
                    break;
                }

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

    private static int doSwapFreeSpaceAndFile(int backIndex, File file, List<FilesystemEntity> compactedFilesystem,
                                              int frontIndex) {
        compactedFilesystem.add(frontIndex, file);
        backIndex++;
        compactedFilesystem.set(backIndex, new FreeSpace(file.size()));

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
}
