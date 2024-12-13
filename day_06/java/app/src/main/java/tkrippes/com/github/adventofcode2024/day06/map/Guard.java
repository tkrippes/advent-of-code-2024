package tkrippes.com.github.adventofcode2024.day06.map;

public class Guard {
    public enum Orientation {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private Position position;
    private Orientation orientation;

    public Guard(Position position) {
        this.position = position;
        this.orientation = Orientation.UP;
    }

    public Guard(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public Position getNextPosition() {
        return switch (orientation) {
            case UP -> new Position(position.row() - 1, position.column());
            case RIGHT -> new Position(position.row(), position.column() + 1);
            case DOWN -> new Position(position.row() + 1, position.column());
            case LEFT -> new Position(position.row(), position.column() - 1);
        };
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Orientation getNextOrientation() {
        return switch (orientation) {
            case UP -> Orientation.RIGHT;
            case RIGHT -> Orientation.DOWN;
            case DOWN -> Orientation.LEFT;
            case LEFT -> Orientation.UP;
        };
    }

    public void turnRight() {
        switch (orientation) {
            case UP -> orientation = Orientation.RIGHT;
            case RIGHT -> orientation = Orientation.DOWN;
            case DOWN -> orientation = Orientation.LEFT;
            case LEFT -> orientation = Orientation.UP;
        }
    }

    public void move() {
        switch (orientation) {
            case UP -> position = new Position(position.row() - 1, position.column());
            case RIGHT -> position = new Position(position.row(), position.column() + 1);
            case DOWN -> position = new Position(position.row() + 1, position.column());
            case LEFT -> position = new Position(position.row(), position.column() - 1);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Guard guard)) {
            return false;
        }

        return guard.position.equals(this.position) && guard.orientation.equals(this.orientation);
    }
}
