package tkrippes.com.github.adventofcode2024.day13;

public record Position(long x, long y) {
    @Override
    public String toString() {
        return "X=" + x + ", Y=" + y;
    }
}
