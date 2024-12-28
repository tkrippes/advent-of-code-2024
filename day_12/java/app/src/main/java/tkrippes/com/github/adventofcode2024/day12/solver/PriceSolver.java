package tkrippes.com.github.adventofcode2024.day12.solver;

import tkrippes.com.github.adventofcode2024.day12.GardenPlots;
import tkrippes.com.github.adventofcode2024.day12.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceSolver {
    public static long solve(GardenPlots plots) {
        Map<Character, Long> areas = getAreas(plots);
        Map<Character, Long> perimeters = getPerimeters(plots);

        long price = 0;
        for (Character plantType : areas.keySet()) {
            price += areas.get(plantType) * perimeters.get(plantType);
        }

        return price;
    }

    private static Map<Character, Long> getAreas(GardenPlots plots) {
        Map<Character, Long> areas = new HashMap<>();
        for (Map.Entry<Position, Character> plot : plots.gardenPlot().entrySet()) {
            areas.putIfAbsent(plot.getValue(), 0L);
            areas.put(plot.getValue(), areas.get(plot.getValue()) + 1);
        }

        return areas;
    }

    private static Map<Character, Long> getPerimeters(GardenPlots plots) {
        Map<Character, Long> perimeters = new HashMap<>();
        for (Map.Entry<Position, Character> plot : plots.gardenPlot().entrySet()) {
            perimeters.putIfAbsent(plot.getValue(), 0L);
            switch (getNumberOfNeighboursWithSamePlantType(plot, plots)) {
                case 0 -> perimeters.put(plot.getValue(), perimeters.get(plot.getValue()) + 4);
                case 1 -> perimeters.put(plot.getValue(), perimeters.get(plot.getValue()) + 3);
                case 2 -> perimeters.put(plot.getValue(), perimeters.get(plot.getValue()) + 2);
                case 3 -> perimeters.put(plot.getValue(), perimeters.get(plot.getValue()) + 1);
            }
        }

        return perimeters;
    }

    private static int getNumberOfNeighboursWithSamePlantType(Map.Entry<Position, Character> plot, GardenPlots plots) {
        int numberOfNeighbours = 0;
        Position position = plot.getKey();
        Character plantType = plot.getValue();
        
        for (Position neighbourPosition : List.of(
                new Position(position.row() - 1, position.column()),
                new Position(position.row() + 1, position.column()),
                new Position(position.row(), position.column() - 1),
                new Position(position.row(), position.column() + 1))) {
            if (plots.gardenPlot().get(neighbourPosition) == plantType) {
                numberOfNeighbours++;
            }
        }

        return numberOfNeighbours;
    }
}
