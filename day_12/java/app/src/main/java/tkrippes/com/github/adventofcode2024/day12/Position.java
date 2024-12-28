package tkrippes.com.github.adventofcode2024.day12;

public record Position(int row, int column) {
    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}
