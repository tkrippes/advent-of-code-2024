package tkrippes.com.github.adventofcode2024.day09.solver;

import java.util.concurrent.atomic.AtomicInteger;

public class FilesystemChecksumSolver {
    static int calculateChecksum(String compactedFilesystem) {
        AtomicInteger index = new AtomicInteger();

        return compactedFilesystem.chars()
                .takeWhile(ch -> ch != '.')
                .map(Character::getNumericValue)
                .reduce(0, (sum, value) -> sum + index.getAndIncrement() * value);
    }
}
