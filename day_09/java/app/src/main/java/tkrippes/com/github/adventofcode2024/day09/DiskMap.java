package tkrippes.com.github.adventofcode2024.day09;

import tkrippes.com.github.adventofcode2024.day09.disk.FileFreeSpaceBlock;

import java.util.List;
import java.util.stream.Collectors;

public record DiskMap(List<FileFreeSpaceBlock> blocks) {
    @Override
    public String toString() {
        return blocks.stream()
                .map(FileFreeSpaceBlock::toString)
                .collect(Collectors.joining());
    }
}
