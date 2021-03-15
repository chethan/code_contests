package leetcode.graph;

import static org.assertj.core.api.Assertions.assertThat;

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
}