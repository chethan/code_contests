package leetcode.graph;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
public class Stones {

    public int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int numberOfConnectedComponents = 0;
        for (int[] stone : stones) {
            if (!visited.contains(stone)) {
                bfs(stones, stone, visited);
                numberOfConnectedComponents++;
            }
        }
        return stones.length - numberOfConnectedComponents;
    }

    void bfs(int[][] stones, int[] currentStone, Set<int[]> visited) {
        visited.add(currentStone);
        for (int[] nextStone : stones) {
            if (!visited.contains(nextStone)) {
                if (nextStone[0] == currentStone[0] || nextStone[1] == currentStone[1]) {
                    bfs(stones, nextStone, visited);
                }
            }
        }
    }
}
