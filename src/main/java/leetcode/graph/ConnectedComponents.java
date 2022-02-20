package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConnectedComponents {


    //https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
    public int countComponents(int n, int[][] edges) {
        if (n == 0 || edges == null || edges.length == 0) {
            return n;
        }
        List<List<Integer>> adjacencyList = IntStream.range(0, n)
            .mapToObj(i -> new ArrayList<Integer>())
            .collect(Collectors.toList());
        Arrays.stream(edges).
            forEach(edge -> {
                adjacencyList.get(edge[0]).add(edge[1]);
                adjacencyList.get(edge[1]).add(edge[0]);
            });
        Set<Integer> visited = new HashSet<>();
        return (int) IntStream.range(0, n)
            .filter(i -> !visited.contains(i))
            .peek(i -> dfs(i, adjacencyList, visited))
            .count();

    }

    private void dfs(int node, List<List<Integer>> adjacencyList, Set<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        adjacencyList.get(node).forEach(i -> dfs(i, adjacencyList, visited));
    }
}
