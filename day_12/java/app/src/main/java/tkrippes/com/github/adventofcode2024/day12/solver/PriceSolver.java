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
        List<List<Position>> regions = new ArrayList<>();
        Map<Position, Boolean> visitedPlots = getInitialVisitedPositions(plots);

        for (Map.Entry<Position, Character> plot : plots.entrySet()) {
            if (plotNotVisitedYet(plot, visitedPlots)) {
                regions.add(getRegionContainingPlot(plot, plots, visitedPlots));
            }
        }

        return regions;
    }

    private static Map<Position, Boolean> getInitialVisitedPositions(Map<Position, Character> plots) {
        Map<Position, Boolean> visitedPositions = new HashMap<>();
        for (Position position : plots.keySet()) {
            visitedPositions.put(position, false);
        }

        return visitedPositions;
    }

    private static boolean plotNotVisitedYet(Map.Entry<Position, Character> plot,
                                             Map<Position, Boolean> visitedPositions) {
        return !visitedPositions.get(plot.getKey());
    }

    private static List<Position> getRegionContainingPlot(Map.Entry<Position, Character> plot,
                                                          Map<Position, Character> plots,
                                                          Map<Position, Boolean> visitedPlots) {
        List<Position> region = new ArrayList<>();
        List<Map.Entry<Position, Character>> plotsToVisit = new ArrayList<>();
        addPlotToRegion(plot, region);
        updateVisitingPlots(plot, visitedPlots, plotsToVisit);

        while (!plotsToVisit.isEmpty()) {
            Map.Entry<Position, Character> currentPlot = plotsToVisit.removeFirst();
            for (Map.Entry<Position, Character> neighbourPlot :
                    getNeighbourPlotsWithSamePlantType(currentPlot.getKey(),
                            currentPlot.getValue(), plots)) {
                if (plotNotVisitedYet(neighbourPlot, visitedPlots)) {
                    addPlotToRegion(neighbourPlot, region);
                    updateVisitingPlots(neighbourPlot, visitedPlots, plotsToVisit);
                }
            }
        }

        return region;
    }

    private static void addPlotToRegion(Map.Entry<Position, Character> plot, List<Position> region) {
        region.add(plot.getKey());
    }

    private static void updateVisitingPlots(Map.Entry<Position, Character> plot,
                                            Map<Position, Boolean> visitedPositions,
                                            List<Map.Entry<Position, Character>> plotsToVisit) {
        plotsToVisit.add(plot);
        visitedPositions.put(plot.getKey(), true);
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
