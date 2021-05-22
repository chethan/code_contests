package leetcode.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.StrictAssertions;
import org.testng.annotations.Test;

public class IslandsTest {

    @Test
    public void testNumberOfIslands() {
        Islands islands = new Islands();
        char[][] grid = new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        assertThat(islands.numIslands(grid)).isEqualTo(1);
        assertThat(islands.numIslands(new char[][]{{}})).isEqualTo(0);
    }

    @Test
    public void testMaxAreaOfIsland() {
        Islands islands = new Islands();
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        assertThat(islands.maxAreaOfIsland(grid)).isEqualTo(6);
    }

    @Test
    public void testShortestBridge() {
        Islands islands = new Islands();
        int[][] grid = {{0,1,0},{0,0,0},{0,0,1}};
        assertThat(islands.shortestBridge(grid)).isEqualTo(2);
    }
}