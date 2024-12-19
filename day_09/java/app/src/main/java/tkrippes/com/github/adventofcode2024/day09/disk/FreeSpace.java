package tkrippes.com.github.adventofcode2024.day09.disk;

public record FreeSpace(int size) {
    @Override
    public String toString() {
        return ".".repeat(size);
    }
}
