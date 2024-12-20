package tkrippes.com.github.adventofcode2024.day09.solver;

import tkrippes.com.github.adventofcode2024.day09.DiskMap;

import java.util.concurrent.atomic.AtomicInteger;

public class FilesystemChecksumSolver {
    static String getCompactedFilesystem(DiskMap map) {
        String filesystem = map.toString();
        int frontIndex = 0;
        int backIndex = filesystem.length() - 1;

        while (frontIndex < backIndex) {
            if (filesystem.charAt(frontIndex) != '.') {
                frontIndex++;
            } else if (filesystem.charAt(backIndex) == '.') {
                backIndex--;
            } else {
                filesystem = swapCharacters(filesystem, frontIndex, backIndex);
            }
        }

        return filesystem;
    }

    private static String swapCharacters(String filesystem, int characterIndex1, int characterIndex2) {
        char temp = filesystem.charAt(characterIndex1);
        filesystem =
                filesystem.substring(0, characterIndex1) + filesystem.charAt(characterIndex2) + filesystem.substring(characterIndex1 + 1);
        filesystem = filesystem.substring(0, characterIndex2) + temp + filesystem.substring(characterIndex2 + 1);
        return filesystem;
    }

    static int calculateChecksum(String compactedFilesystem) {
        AtomicInteger index = new AtomicInteger();

        return compactedFilesystem.chars()
                .takeWhile(ch -> ch != '.')
                .map(Character::getNumericValue)
                .reduce(0, (sum, value) -> sum + index.getAndIncrement() * value);
    }
}
