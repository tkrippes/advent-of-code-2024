package tkrippes.com.github.adventofcode2024.day08;

public record Position(int row, int column) {
    public Position add(Position otherPosition) {
        return new Position(row + otherPosition.row(), column + otherPosition.column());
    }

    public Position subtract(Position otherPosition) {
        return new Position(row - otherPosition.row(), column - otherPosition.column());
    }
}
