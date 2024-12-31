package tkrippes.com.github.adventofcode2024.day12.solver;

import tkrippes.com.github.adventofcode2024.day12.GardenPlots;
import tkrippes.com.github.adventofcode2024.day12.Position;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PriceSolverV1 extends PriceSolver {
    public static long solve(GardenPlots plots) {
        List<List<Position>> regions = getRegions(plots.gardenPlots());
        List<Long> areas = getAreas(regions);
        List<Long> perimeters = getPerimeters(regions);

        return IntStream.range(0, regions.size())
                .mapToLong(i -> areas.get(i) * perimeters.get(i))
                .sum();
    }

    private static List<Long> getPerimeters(List<List<Position>> regions) {
        return regions.stream()
                .map(PriceSolverV1::getPerimeterOfRegion).toList();
    }

    private static long getPerimeterOfRegion(List<Position> region) {
        return region.stream()
                .mapToLong(position -> switch (getNumberOfNeighboursInRegion(position, region)) {
                    case 0 -> 4;
                    case 1 -> 3;
                    case 2 -> 2;
                    case 3 -> 1;
                    default -> 0;
                }).sum();
    }

    private static int getNumberOfNeighboursInRegion(Position position, List<Position> region) {
        return (int) Stream.of(
                        new Position(position.row() - 1, position.column()),
                        new Position(position.row() + 1, position.column()),
                        new Position(position.row(), position.column() - 1),
                        new Position(position.row(), position.column() + 1))
                .filter(region::contains)
                .count();
    }
}
