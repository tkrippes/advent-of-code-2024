package tkrippes.com.github.adventofcode2024.day10.solver;

import tkrippes.com.github.adventofcode2024.day10.Position;
import tkrippes.com.github.adventofcode2024.day10.TopographicMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TrailheadScoreSolver {
    public static int solve(TopographicMap map) {
        int score = 0;
        for (Position trailheadPosition : map.getTrailheadPositions()) {
            score += getReachedTrailEndPositions(new HashSet<>(), trailheadPosition, map).size();
        }

        return score;
    }

    private static Set<Position> getReachedTrailEndPositions(Set<Position> visitedPositions, Position currentPosition,
                                                             TopographicMap map) {
        if (visitedPositions.contains(currentPosition)) {
            return new HashSet<>();
        }

        if (map.getTrailEndPositions().contains(currentPosition)) {
            return Set.of(currentPosition);
        }

        Set<Position> reachedTrailEndPosition = new HashSet<>();
        Set<Position> nextPositions = map.getNeighbours(currentPosition).stream().filter(e -> e.getValue() ==
                map.getHeight(currentPosition) + 1).map(Map.Entry::getKey).collect(Collectors.toSet());
        for (Position nextPosition : nextPositions) {
            Set<Position> newVisitedPositions = new HashSet<>(visitedPositions);
            newVisitedPositions.add(currentPosition);
            reachedTrailEndPosition.addAll(getReachedTrailEndPositions(newVisitedPositions, nextPosition, map));
        }

        return reachedTrailEndPosition;
    }
}
