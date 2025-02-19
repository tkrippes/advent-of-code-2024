package tkrippes.com.github.adventofcode2024.day12;

import java.util.HashMap;
import java.util.Map;

public class GardenPlotsTestInputHelper {
    public static GardenPlots getTestInput1GardenPlots() {
        Map<Position, Character> plots = new HashMap<>();
        plots.put(new Position(0, 0), 'A');
        plots.put(new Position(0, 1), 'A');
        plots.put(new Position(0, 2), 'A');
        plots.put(new Position(0, 3), 'A');
        plots.put(new Position(1, 0), 'B');
        plots.put(new Position(1, 1), 'B');
        plots.put(new Position(1, 2), 'C');
        plots.put(new Position(1, 3), 'D');
        plots.put(new Position(2, 0), 'B');
        plots.put(new Position(2, 1), 'B');
        plots.put(new Position(2, 2), 'C');
        plots.put(new Position(2, 3), 'C');
        plots.put(new Position(3, 0), 'E');
        plots.put(new Position(3, 1), 'E');
        plots.put(new Position(3, 2), 'E');
        plots.put(new Position(3, 3), 'C');

        return new GardenPlots(plots);
    }

    public static GardenPlots getTestInput2GardenPlots() {
        Map<Position, Character> plots = new HashMap<>();
        plots.put(new Position(0, 0), 'O');
        plots.put(new Position(0, 1), 'O');
        plots.put(new Position(0, 2), 'O');
        plots.put(new Position(0, 3), 'O');
        plots.put(new Position(0, 4), 'O');
        plots.put(new Position(1, 0), 'O');
        plots.put(new Position(1, 1), 'X');
        plots.put(new Position(1, 2), 'O');
        plots.put(new Position(1, 3), 'X');
        plots.put(new Position(1, 4), 'O');
        plots.put(new Position(2, 0), 'O');
        plots.put(new Position(2, 1), 'O');
        plots.put(new Position(2, 2), 'O');
        plots.put(new Position(2, 3), 'O');
        plots.put(new Position(2, 4), 'O');
        plots.put(new Position(3, 0), 'O');
        plots.put(new Position(3, 1), 'X');
        plots.put(new Position(3, 2), 'O');
        plots.put(new Position(3, 3), 'X');
        plots.put(new Position(3, 4), 'O');
        plots.put(new Position(4, 0), 'O');
        plots.put(new Position(4, 1), 'O');
        plots.put(new Position(4, 2), 'O');
        plots.put(new Position(4, 3), 'O');
        plots.put(new Position(4, 4), 'O');

        return new GardenPlots(plots);
    }

    public static GardenPlots getTestInput3GardenPlots() {
        Map<Position, Character> plots = new HashMap<>();
        plots.put(new Position(0, 0), 'R');
        plots.put(new Position(0, 1), 'R');
        plots.put(new Position(0, 2), 'R');
        plots.put(new Position(0, 3), 'R');
        plots.put(new Position(0, 4), 'I');
        plots.put(new Position(0, 5), 'I');
        plots.put(new Position(0, 6), 'C');
        plots.put(new Position(0, 7), 'C');
        plots.put(new Position(0, 8), 'F');
        plots.put(new Position(0, 9), 'F');
        plots.put(new Position(1, 0), 'R');
        plots.put(new Position(1, 1), 'R');
        plots.put(new Position(1, 2), 'R');
        plots.put(new Position(1, 3), 'R');
        plots.put(new Position(1, 4), 'I');
        plots.put(new Position(1, 5), 'I');
        plots.put(new Position(1, 6), 'C');
        plots.put(new Position(1, 7), 'C');
        plots.put(new Position(1, 8), 'C');
        plots.put(new Position(1, 9), 'F');
        plots.put(new Position(2, 0), 'V');
        plots.put(new Position(2, 1), 'V');
        plots.put(new Position(2, 2), 'R');
        plots.put(new Position(2, 3), 'R');
        plots.put(new Position(2, 4), 'R');
        plots.put(new Position(2, 5), 'C');
        plots.put(new Position(2, 6), 'C');
        plots.put(new Position(2, 7), 'F');
        plots.put(new Position(2, 8), 'F');
        plots.put(new Position(2, 9), 'F');
        plots.put(new Position(3, 0), 'V');
        plots.put(new Position(3, 1), 'V');
        plots.put(new Position(3, 2), 'R');
        plots.put(new Position(3, 3), 'C');
        plots.put(new Position(3, 4), 'C');
        plots.put(new Position(3, 5), 'C');
        plots.put(new Position(3, 6), 'J');
        plots.put(new Position(3, 7), 'F');
        plots.put(new Position(3, 8), 'F');
        plots.put(new Position(3, 9), 'F');
        plots.put(new Position(4, 0), 'V');
        plots.put(new Position(4, 1), 'V');
        plots.put(new Position(4, 2), 'V');
        plots.put(new Position(4, 3), 'V');
        plots.put(new Position(4, 4), 'C');
        plots.put(new Position(4, 5), 'J');
        plots.put(new Position(4, 6), 'J');
        plots.put(new Position(4, 7), 'C');
        plots.put(new Position(4, 8), 'F');
        plots.put(new Position(4, 9), 'E');
        plots.put(new Position(5, 0), 'V');
        plots.put(new Position(5, 1), 'V');
        plots.put(new Position(5, 2), 'I');
        plots.put(new Position(5, 3), 'V');
        plots.put(new Position(5, 4), 'C');
        plots.put(new Position(5, 5), 'C');
        plots.put(new Position(5, 6), 'J');
        plots.put(new Position(5, 7), 'J');
        plots.put(new Position(5, 8), 'E');
        plots.put(new Position(5, 9), 'E');
        plots.put(new Position(6, 0), 'V');
        plots.put(new Position(6, 1), 'V');
        plots.put(new Position(6, 2), 'I');
        plots.put(new Position(6, 3), 'I');
        plots.put(new Position(6, 4), 'I');
        plots.put(new Position(6, 5), 'C');
        plots.put(new Position(6, 6), 'J');
        plots.put(new Position(6, 7), 'J');
        plots.put(new Position(6, 8), 'E');
        plots.put(new Position(6, 9), 'E');
        plots.put(new Position(7, 0), 'M');
        plots.put(new Position(7, 1), 'I');
        plots.put(new Position(7, 2), 'I');
        plots.put(new Position(7, 3), 'I');
        plots.put(new Position(7, 4), 'I');
        plots.put(new Position(7, 5), 'I');
        plots.put(new Position(7, 6), 'J');
        plots.put(new Position(7, 7), 'J');
        plots.put(new Position(7, 8), 'E');
        plots.put(new Position(7, 9), 'E');
        plots.put(new Position(8, 0), 'M');
        plots.put(new Position(8, 1), 'I');
        plots.put(new Position(8, 2), 'I');
        plots.put(new Position(8, 3), 'I');
        plots.put(new Position(8, 4), 'S');
        plots.put(new Position(8, 5), 'I');
        plots.put(new Position(8, 6), 'J');
        plots.put(new Position(8, 7), 'E');
        plots.put(new Position(8, 8), 'E');
        plots.put(new Position(8, 9), 'E');
        plots.put(new Position(9, 0), 'M');
        plots.put(new Position(9, 1), 'M');
        plots.put(new Position(9, 2), 'M');
        plots.put(new Position(9, 3), 'I');
        plots.put(new Position(9, 4), 'S');
        plots.put(new Position(9, 5), 'S');
        plots.put(new Position(9, 6), 'J');
        plots.put(new Position(9, 7), 'E');
        plots.put(new Position(9, 8), 'E');
        plots.put(new Position(9, 9), 'E');

        return new GardenPlots(plots);
    }

    public static GardenPlots getTestInput4GardenPlots() {
        Map<Position, Character> plots = new HashMap<>();
        plots.put(new Position(0, 0), 'E');
        plots.put(new Position(0, 1), 'E');
        plots.put(new Position(0, 2), 'E');
        plots.put(new Position(0, 3), 'E');
        plots.put(new Position(0, 4), 'E');
        plots.put(new Position(1, 0), 'E');
        plots.put(new Position(1, 1), 'X');
        plots.put(new Position(1, 2), 'X');
        plots.put(new Position(1, 3), 'X');
        plots.put(new Position(1, 4), 'X');
        plots.put(new Position(2, 0), 'E');
        plots.put(new Position(2, 1), 'E');
        plots.put(new Position(2, 2), 'E');
        plots.put(new Position(2, 3), 'E');
        plots.put(new Position(2, 4), 'E');
        plots.put(new Position(3, 0), 'E');
        plots.put(new Position(3, 1), 'X');
        plots.put(new Position(3, 2), 'X');
        plots.put(new Position(3, 3), 'X');
        plots.put(new Position(3, 4), 'X');
        plots.put(new Position(4, 0), 'E');
        plots.put(new Position(4, 1), 'E');
        plots.put(new Position(4, 2), 'E');
        plots.put(new Position(4, 3), 'E');
        plots.put(new Position(4, 4), 'E');
        plots.put(new Position(4, 4), 'E');

        return new GardenPlots(plots);
    }

    public static GardenPlots getTestInput5GardenPlots() {
        Map<Position, Character> plots = new HashMap<>();
        plots.put(new Position(0, 0), 'A');
        plots.put(new Position(0, 1), 'A');
        plots.put(new Position(0, 2), 'A');
        plots.put(new Position(0, 3), 'A');
        plots.put(new Position(0, 4), 'A');
        plots.put(new Position(0, 5), 'A');
        plots.put(new Position(1, 0), 'A');
        plots.put(new Position(1, 1), 'A');
        plots.put(new Position(1, 2), 'A');
        plots.put(new Position(1, 3), 'B');
        plots.put(new Position(1, 4), 'B');
        plots.put(new Position(1, 5), 'A');
        plots.put(new Position(2, 0), 'A');
        plots.put(new Position(2, 1), 'A');
        plots.put(new Position(2, 2), 'A');
        plots.put(new Position(2, 3), 'B');
        plots.put(new Position(2, 4), 'B');
        plots.put(new Position(2, 5), 'A');
        plots.put(new Position(3, 0), 'A');
        plots.put(new Position(3, 1), 'B');
        plots.put(new Position(3, 2), 'B');
        plots.put(new Position(3, 3), 'A');
        plots.put(new Position(3, 4), 'A');
        plots.put(new Position(3, 5), 'A');
        plots.put(new Position(4, 0), 'A');
        plots.put(new Position(4, 1), 'B');
        plots.put(new Position(4, 2), 'B');
        plots.put(new Position(4, 3), 'A');
        plots.put(new Position(4, 4), 'A');
        plots.put(new Position(4, 5), 'A');
        plots.put(new Position(5, 0), 'A');
        plots.put(new Position(5, 1), 'A');
        plots.put(new Position(5, 2), 'A');
        plots.put(new Position(5, 3), 'A');
        plots.put(new Position(5, 4), 'A');
        plots.put(new Position(5, 5), 'A');

        return new GardenPlots(plots);
    }
}
