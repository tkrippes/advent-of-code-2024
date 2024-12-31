package tkrippes.com.github.adventofcode2024.day12.solver;

import tkrippes.com.github.adventofcode2024.day12.GardenPlots;
import tkrippes.com.github.adventofcode2024.day12.Position;

import java.util.List;
import java.util.stream.IntStream;

public class PriceSolverV2 extends PriceSolver {
    public static long solve(GardenPlots plots) {
        List<List<Position>> regions = getRegions(plots.gardenPlots());
        List<Long> areas = getAreas(regions);
        List<Long> numberOfSides = getNumberOfSides(regions);

        return IntStream.range(0, regions.size())
                .mapToLong(i -> areas.get(i) * numberOfSides.get(i))
                .sum();
    }

    private static List<Long> getNumberOfSides(List<List<Position>> regions) {
        return regions.stream()
                .map(PriceSolverV2::getNumberOfSidesOfRegion)
                .toList();
    }

    private static long getNumberOfSidesOfRegion(List<Position> region) {
        return region.stream()
                .flatMap(position -> getAllCornerNeighbours(position).stream())
                .mapToLong(cornerNeighbours -> getNumberOfCorners(region, cornerNeighbours))
                .sum();
    }

    private static List<List<Position>> getAllCornerNeighbours(Position position) {
        return getAllCornerOffsets().stream()
                .map(cornerOffsets -> getCornerNeighbours(position, cornerOffsets.getFirst(), cornerOffsets.getLast()))
                .toList();
    }

    private static List<List<Integer>> getAllCornerOffsets() {
        return List.of(List.of(1, 1), List.of(1, -1), List.of(-1, 1), List.of(-1, -1));
    }

    private static List<Position> getCornerNeighbours(Position position, int rowOffset, int columnOffset) {
        return List.of(new Position(position.row() + rowOffset, position.column()),
                new Position(position.row(), position.column() + columnOffset),
                new Position(position.row() + rowOffset, position.column() + columnOffset));
    }

    private static long getNumberOfCorners(List<Position> region, List<Position> cornerNeighbours) {
        Position rowCornerNeighbour = cornerNeighbours.get(0);
        Position columnCornerNeighbour = cornerNeighbours.get(1);
        Position diagonalCornerNeighbour = cornerNeighbours.get(2);

        long sides = 0;
        if (isConvexCorner(region, rowCornerNeighbour, columnCornerNeighbour)) {
            sides++;
        }

        if (isConcaveCorner(region, rowCornerNeighbour, columnCornerNeighbour, diagonalCornerNeighbour)) {
            sides++;
        }

        return sides;
    }

    private static boolean isConvexCorner(List<Position> region, Position rowCornerNeighbour,
                                          Position columnCornerNeighbour) {
        return !region.contains(rowCornerNeighbour) && !region.contains(columnCornerNeighbour);
    }

    private static boolean isConcaveCorner(List<Position> region, Position rowCornerNeighbour,
                                           Position columnCornerNeighbour, Position diagonalCornerNeighbour) {
        return region.contains(rowCornerNeighbour) && region.contains(columnCornerNeighbour) &&
                !region.contains(diagonalCornerNeighbour);
    }
}
