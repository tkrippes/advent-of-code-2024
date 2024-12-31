package tkrippes.com.github.adventofcode2024.day12.solver;

import tkrippes.com.github.adventofcode2024.day12.Position;

import java.util.*;
import java.util.stream.Collectors;

public class PriceSolver {
    protected static List<List<Position>> getRegions(Map<Position, Character> plots) {
        List<List<Position>> regions = new ArrayList<>();
        Map<Position, Boolean> visitedPositions = getInitialVisitedPositions(plots);

        plots.keySet().stream()
                .filter(plotPosition -> plotNotVisitedYet(plotPosition, visitedPositions))
                .forEach(plotPosition -> regions.add(getRegionContainingPlot(plotPosition, plots, visitedPositions)));

        return regions;
    }

    private static Map<Position, Boolean> getInitialVisitedPositions(Map<Position, Character> plots) {
        return plots.keySet().stream()
                .collect(Collectors.toMap(position -> position, _ -> false));
    }

    private static boolean plotNotVisitedYet(Position plotPosition,
                                             Map<Position, Boolean> visitedPositions) {
        return !visitedPositions.get(plotPosition);
    }

    private static List<Position> getRegionContainingPlot(Position plotPosition,
                                                          Map<Position, Character> plots,
                                                          Map<Position, Boolean> visitedPositions) {
        List<Position> region = new ArrayList<>();
        List<Position> positionsToVisit = new ArrayList<>();
        addPlotToRegion(plotPosition, region);
        updateVisitingPlots(plotPosition, visitedPositions, positionsToVisit);

        while (!positionsToVisit.isEmpty()) {
            Position currentPlotPosition = positionsToVisit.removeFirst();
            getNeighbourPlotPositionsWithSamePlantType(currentPlotPosition,
                    plots.get(currentPlotPosition), plots).stream()
                    .filter(neighbourPlotPosition -> plotNotVisitedYet(neighbourPlotPosition, visitedPositions))
                    .forEach(neighbourPlotPosition -> {
                        addPlotToRegion(neighbourPlotPosition, region);
                        updateVisitingPlots(neighbourPlotPosition, visitedPositions, positionsToVisit);
                    });
        }

        return region;
    }

    private static void addPlotToRegion(Position plotPosition, List<Position> region) {
        region.add(plotPosition);
    }

    private static void updateVisitingPlots(Position plotPosition,
                                            Map<Position, Boolean> visitedPositions,
                                            List<Position> positionsToVisit) {
        positionsToVisit.add(plotPosition);
        visitedPositions.put(plotPosition, true);
    }

    private static List<Position> getNeighbourPlotPositionsWithSamePlantType(Position plotPosition,
                                                                             Character plantType,
                                                                             Map<Position, Character> plots) {
        return getNeighbourPlotPositions(plotPosition).stream()
                .filter(neighbourPosition -> plots.get(neighbourPosition) == plantType)
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
