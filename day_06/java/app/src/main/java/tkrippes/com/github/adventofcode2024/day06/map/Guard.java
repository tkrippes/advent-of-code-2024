package tkrippes.com.github.adventofcode2024.day06.map;

public class Guard {
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
