package leetcode.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class SnakeAndLadderTest {

    @Test
    public void testMinMoves() {
        SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
        int[][] board = {{-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 35, -1, -1, 13, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 15, -1, -1, -1, -1}};
        assertThat(snakeAndLadder.minMoves(board)).isEqualTo(4);
    }
}