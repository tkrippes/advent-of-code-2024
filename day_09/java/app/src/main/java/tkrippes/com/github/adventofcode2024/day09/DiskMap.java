package tkrippes.com.github.adventofcode2024.day09;

import tkrippes.com.github.adventofcode2024.day09.disk.FilesystemEntity;

import java.util.List;
import java.util.stream.Collectors;

public record DiskMap(List<FilesystemEntity> filesystem) {
    @Override
    public String toString() {
        return filesystem.stream()
                .map(FilesystemEntity::toString)
                .collect(Collectors.joining());
    }
}
