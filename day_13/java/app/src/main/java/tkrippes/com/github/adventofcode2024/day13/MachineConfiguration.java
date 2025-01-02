package tkrippes.com.github.adventofcode2024.day13;

public record MachineConfiguration(Direction buttonA, Direction buttonB, Position prizeLocation) {
    @Override
    public String toString() {
        return "Button A: " + buttonA +
                ", Button B: " + buttonB +
                ", Prize: " + prizeLocation;
    }
}
