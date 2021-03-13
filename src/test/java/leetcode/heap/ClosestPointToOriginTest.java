package leetcode.heap;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class ClosestPointToOriginTest {

    @Test
    public void testKClosestPointToOrigin() {
        ClosestPointToOrigin closestPointToOrigin = new ClosestPointToOrigin();
        assertThat(closestPointToOrigin.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1))
            .containsExactly(new int[]{-2, 2});
    }
}