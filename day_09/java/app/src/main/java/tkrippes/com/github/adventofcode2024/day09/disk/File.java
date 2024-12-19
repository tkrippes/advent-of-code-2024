package tkrippes.com.github.adventofcode2024.day09.disk;

public record File(int size, int id) {
    @Override
    public String toString() {
        return String.valueOf(id).repeat(size);
    }
}
