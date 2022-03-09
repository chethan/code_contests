package leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/is-graph-bipartite/
//Time: O(N+E)
//Space: O(N)
public class BipartiteGraph {

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int index = 0; index < graph.length; index++) {
            if (colors[index] != -1) {
                continue;
            }
            if (traverse(graph, colors, index)) {
                return false;
            }
        }
        return true;
    }

    private boolean traverse(int[][] graph, int[] colors, int index) {
        Queue<Integer> nodes = new LinkedList<>();
        int currentColor = 0;
        colors[index] = currentColor;
        nodes.offer(index);
        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();
            currentColor = currentColor ^ 1;
            for (int i = 0; i < levelSize; i++) {
                int current = nodes.poll();
                int[] neighbours = graph[current];
                for (int neighbour : neighbours) {
                    if (colors[neighbour] == -1) {
                        colors[neighbour] = currentColor;
                        nodes.offer(neighbour);
                    } else if (colors[neighbour] != currentColor) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
