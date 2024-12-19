package tkrippes.com.github.adventofcode2024.day09.disk;

import java.util.Optional;

public record FileFreeSpaceBlock(File file, Optional<FreeSpace> freeSpace) {
    @Override
    public String toString() {
        return file.toString() +
                freeSpace.map(FreeSpace::toString).orElse("");
    }
}
