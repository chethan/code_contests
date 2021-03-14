package leetcode.heap;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class SlidingWindowMedianTest {

    @Test
    public void testMedianForSlidingWindow() {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        assertThat(slidingWindowMedian.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))
            .containsExactly(1, -1, -1, 3, 5, 6);
        assertThat(slidingWindowMedian.medianSlidingWindow(new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE}, 2))
            .containsExactly(Integer.MAX_VALUE);
    }
}