package tkrippes.com.github.adventofcode2024.day12.solver;

import tkrippes.com.github.adventofcode2024.day12.Position;

import java.util.*;
import java.util.stream.Collectors;

public class PriceSolver {
    protected static List<List<Position>> getRegions(Map<Position, Character> plots) {
        List<List<Position>> regions = new ArrayList<>();
        Map<Position, Boolean> visitedPlots = getInitialVisitedPositions(plots);

        plots.entrySet().stream()
                .filter(plot -> plotNotVisitedYet(plot, visitedPlots))
                .forEach(plot -> regions.add(getRegionContainingPlot(plot, plots, visitedPlots)));

        return regions;
    }

    private static Map<Position, Boolean> getInitialVisitedPositions(Map<Position, Character> plots) {
        return plots.keySet().stream()
                .collect(Collectors.toMap(position -> position, _ -> false));
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
            getNeighbourPlotsWithSamePlantType(currentPlot.getKey(), currentPlot.getValue(), plots).stream()
                    .filter(neighbourPlot -> plotNotVisitedYet(neighbourPlot, visitedPlots))
                    .forEach(neighbourPlot -> {
                        addPlotToRegion(neighbourPlot, region);
                        updateVisitingPlots(neighbourPlot, visitedPlots, plotsToVisit);
                    });
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
        return getNeighbourPlotPositions(position).stream()
                .filter(neighbourPosition -> plots.get(neighbourPosition) == plantType)
                .map(neighbourPosition -> Map.entry(neighbourPosition, plots.get(neighbourPosition)))
                .toList();
    }

    private static List<Position> getNeighbourPlotPositions(Position position) {
        return List.of(
                new Position(position.row() - 1, position.column()),
                new Position(position.row() + 1, position.column()),
                new Position(position.row(), position.column() - 1),
                new Position(position.row(), position.column() + 1));
    }

    protected static List<Long> getAreas(List<List<Position>> regions) {
        return regions.stream().mapToLong(List::size).boxed().toList();
    }
}
