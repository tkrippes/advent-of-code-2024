package tkrippes.com.github.adventofcode2024.day10.solver;

import tkrippes.com.github.adventofcode2024.day10.Position;
import tkrippes.com.github.adventofcode2024.day10.TopographicMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TrailheadRatingSolver {
    public static int solve(TopographicMap map) {
        Set<Set<Position>> hikingTrails = new HashSet<>();
        for (Position trailheadPosition : map.getTrailheadPositions()) {
            hikingTrails.addAll(getHikingTrails(new HashSet<>(), trailheadPosition, map));
        }

        return hikingTrails.size();
    }

    private static Set<Set<Position>> getHikingTrails(Set<Position> visitedPositions, Position currentPosition,
                                                      TopographicMap map) {
        if (visitedPositions.contains(currentPosition)) {
            return new HashSet<>();
        }

        if (map.getTrailEndPositions().contains(currentPosition)) {
            Set<Position> hikingTrail = new HashSet<>(visitedPositions);
            hikingTrail.add(currentPosition);

            return Set.of(hikingTrail);
        }

        Set<Set<Position>> hikingTrails = new HashSet<>();
        Set<Position> nextPositions = map.getNeighbours(currentPosition).stream().filter(e -> e.getValue() ==
                map.getHeight(currentPosition) + 1).map(Map.Entry::getKey).collect(Collectors.toSet());
        for (Position nextPosition : nextPositions) {
            Set<Position> newVisitedPositions = new HashSet<>(visitedPositions);
            newVisitedPositions.add(currentPosition);
            hikingTrails.addAll(getHikingTrails(newVisitedPositions, nextPosition, map));
        }

        return hikingTrails;
    }
}
