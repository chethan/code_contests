package leetcode.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class FloodFillTest {

    @Test
    public void testFloodFill() {
        FloodFill floodFill = new FloodFill();
        assertThat(floodFill.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2))
            .isEqualTo(new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}});
        assertThat(floodFill.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 1))
            .isEqualTo(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
    }
}