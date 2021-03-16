package leetcode.graph;

import ds.UnionFind;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphAsTree {

    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);
        return dfs(graph, parent, 0) && parent.size() == n;
    }

    public boolean validTreeUsingUnionFind(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
                if (!unionFind.union(edge[0], edge[1])) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, Map<Integer, Integer> parent, int node) {
        for (int nextNode : graph.getOrDefault(node, List.of())) {
            if (parent.get(node) == nextNode) {
                continue;
            }
            if (parent.containsKey(nextNode)) {
                return false;
            }
            parent.put(nextNode, node);
            boolean cycle = dfs(graph, parent, nextNode);
            if (!cycle) {
                return false;
            }
        }
        return true;
    }

}
