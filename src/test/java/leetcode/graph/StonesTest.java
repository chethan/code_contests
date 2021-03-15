package leetcode.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class StonesTest {

    @Test
    public void testMaxStonesToBeRemoved() {
        Stones stones = new Stones();
        assertThat(stones.removeStones(new int[][]{})).isEqualTo(0);
        assertThat(stones.removeStones(new int[][]{{1, 1}})).isEqualTo(0);
        assertThat(stones.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}))
            .isEqualTo(5);
    }
}