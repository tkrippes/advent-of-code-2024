package tkrippes.com.github.adventofcode2024.day13;

public record MachineConfiguration(Direction buttonABehaviour, Direction buttonBBehaviour, Position prizeLocation) {
    @Override
    public String toString() {
        return "Button A: " + buttonABehaviour +
                ", Button B: " + buttonBBehaviour +
                ", Prize: " + prizeLocation;
    }
}
