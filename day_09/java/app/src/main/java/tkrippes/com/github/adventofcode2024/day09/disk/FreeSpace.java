package tkrippes.com.github.adventofcode2024.day09.disk;

public record FreeSpace(int size) implements FilesystemEntity {
    @Override
    public String toString() {
        return ".".repeat(size);
    }
}
