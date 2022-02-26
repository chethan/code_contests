package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/critical-connections-in-a-network/
public class CriticalConnections {


    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    Map<Integer, Integer> rankMap = new HashMap<>();
    Set<Pair> connectionMap = new HashSet<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        formGraph(n, connections);
        dfs(0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (Pair node : connectionMap) {
            result.add(List.of(node.left, node.right));
        }
        return result;
    }

    int dfs(int node, int rank) {
        if (rankMap.get(node) != null) {
            return rankMap.get(node);
        }
        rankMap.put(node, rank);
        int minRank = rank + 1;
        for (int neighbour : adjacencyList.get(node)) {
            Integer neighbourRank = rankMap.get(neighbour);
            if (neighbourRank != null && neighbourRank == rank - 1) {
                continue;
            }
            int recursiveRank = dfs(neighbour, rank + 1);
            if (recursiveRank <= rank) {
                connectionMap.remove(
                    new Pair(Math.min(node, neighbour), Math.max(node, neighbour)));
            }
            minRank = Math.min(recursiveRank, minRank);
        }
        return minRank;
    }


    void formGraph(int n, List<List<Integer>> connections) {
        adjacencyList = new HashMap<>();
        rankMap = new HashMap<>();
        connectionMap = new HashSet<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
            rankMap.put(i, null);
        }
        for (List<Integer> connection : connections) {
            int left = connection.get(0);
            int right = connection.get(1);
            adjacencyList.get(left).add(right);
            adjacencyList.get(right).add(left);
            connectionMap.add(new Pair(Math.min(left, right), Math.max(right, left)));
        }
    }

    private static class Pair {

        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }


        @Override
        public int hashCode() {
            return Integer.hashCode(left) + Integer.hashCode(right);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pair) {
                Pair other = (Pair) obj;
                return this.left == other.left && this.right == other.right;
            }
            return false;
        }
    }
}
