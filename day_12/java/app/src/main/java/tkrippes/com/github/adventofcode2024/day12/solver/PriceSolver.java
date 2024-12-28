package tkrippes.com.github.adventofcode2024.day12.solver;

import tkrippes.com.github.adventofcode2024.day12.GardenPlots;
import tkrippes.com.github.adventofcode2024.day12.Position;

import java.util.*;
import java.util.stream.IntStream;

public class PriceSolver {
    public static long solve(GardenPlots plots) {
        List<List<Position>> regions = getRegions(plots.gardenPlots());
        List<Long> areas = getAreas(regions);
        List<Long> perimeters = getPerimeters(regions);

        return IntStream.range(0, regions.size())
                .mapToLong(i -> areas.get(i) * perimeters.get(i))
                .sum();
    }

    private static List<List<Position>> getRegions(Map<Position, Character> plots) {
        // TODO refactor
        List<List<Position>> regions = new ArrayList<>();
        Map<Position, Boolean> visitedPositions = new HashMap<>();
        for (Position position : plots.keySet()) {
            visitedPositions.put(position, false);
        }

        for (Map.Entry<Position, Character> plot : plots.entrySet()) {
            if (!visitedPositions.get(plot.getKey())) {
                List<Position> region = new ArrayList<>();
                List<Map.Entry<Position, Character>> queue = new ArrayList<>();
                queue.add(plot);
                visitedPositions.put(plot.getKey(), true);
                region.add(plot.getKey());

                while (!queue.isEmpty()) {
                    Map.Entry<Position, Character> currentPlot = queue.removeFirst();
                    for (Map.Entry<Position, Character> neighbourPlot :
                            getNeighbourPlotsWithSamePlantType(currentPlot.getKey(),
                                    currentPlot.getValue(), plots)) {
                        if (!visitedPositions.get(neighbourPlot.getKey())) {
                            queue.add(neighbourPlot);
                            visitedPositions.put(neighbourPlot.getKey(), true);
                            region.add(neighbourPlot.getKey());
                        }
                    }
                }

                regions.add(region);
            }
        }

        return regions;
    }

    private static List<Map.Entry<Position, Character>> getNeighbourPlotsWithSamePlantType(Position position,
                                                                                           Character plantType,
                                                                                           Map<Position, Character> plots) {
        List<Map.Entry<Position, Character>> neighbourPlots = new ArrayList<>();
        for (Position neighbourPosition : List.of(
                new Position(position.row() - 1, position.column()),
                new Position(position.row() + 1, position.column()),
                new Position(position.row(), position.column() - 1),
                new Position(position.row(), position.column() + 1))) {
            if (plots.get(neighbourPosition) == plantType) {
                neighbourPlots.add(Map.entry(neighbourPosition, plots.get(neighbourPosition)));
            }
        }

        return neighbourPlots;
    }

    private static List<Long> getAreas(List<List<Position>> regions) {
        return regions.stream().mapToLong(List::size).boxed().toList();
    }

    private static List<Long> getPerimeters(List<List<Position>> regions) {
        return regions.stream()
                .map(region -> region.stream()
                        .mapToLong(position -> switch (getNumberOfNeighboursInRegion(position, region)) {
                            case 0 -> 4;
                            case 1 -> 3;
                            case 2 -> 2;
                            case 3 -> 1;
                            default -> 0;
                        }).sum()
                ).toList();
    }

    private static int getNumberOfNeighboursInRegion(Position position, List<Position> region) {
        int numberOfNeighbours = 0;

        for (Position neighbourPosition : List.of(
                new Position(position.row() - 1, position.column()),
                new Position(position.row() + 1, position.column()),
                new Position(position.row(), position.column() - 1),
                new Position(position.row(), position.column() + 1))) {
            if (region.contains(neighbourPosition)) {
                numberOfNeighbours++;
            }
        }

        return numberOfNeighbours;
    }
}
