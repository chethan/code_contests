package leetcode.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Provinces {

    //https://leetcode.com/problems/number-of-provinces/
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        Set<Integer> visitedCities = new HashSet<>();
        return (int) IntStream.range(0, isConnected.length)
            .filter(i -> !visitedCities.contains(i))
            .peek(i -> dfs(i, isConnected, visitedCities))
            .count();
    }

    private void dfs(int city, int[][] isConnected, Set<Integer> visitedCities) {
        if (visitedCities.contains(city)) {
            return;
        }
        visitedCities.add(city);
        IntStream.range(0, isConnected.length)
            .filter(i -> i != city && isConnected[city][i] == 1)
            .forEach(i -> dfs(i, isConnected, visitedCities));
    }
}
