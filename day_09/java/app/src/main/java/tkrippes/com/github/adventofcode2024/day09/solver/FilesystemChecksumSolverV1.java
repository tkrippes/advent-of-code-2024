package tkrippes.com.github.adventofcode2024.day09.solver;

import tkrippes.com.github.adventofcode2024.day09.DiskMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilesystemChecksumSolverV1 extends FilesystemChecksumSolver {
    public static long solve(DiskMap map) {
        return calculateChecksum(compactFilesystemLayout(getFilesystemLayout(map.filesystem())));
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
}
