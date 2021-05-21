package leetcode.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class WallsAndGatesTest {

    @Test
    public void testWallsAndGates() {
        WallsAndGates wallsAndGates = new WallsAndGates();
        int empty = Integer.MAX_VALUE;
        int[][] rooms = {{empty, -1, 0, empty}, {empty, empty, empty, -1}, {empty, -1, empty, -1}, {
            0, -1, empty, empty}};
        wallsAndGates.wallsAndGates(rooms);
        assertThat(rooms).isEqualTo(new int[][]{{3, -1, 0, 1}, {2, 2, 1, -1}, {1, -1, 2, -1}, {0, -1, 3, 4}});
    }
}