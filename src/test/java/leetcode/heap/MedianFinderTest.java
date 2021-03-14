package leetcode.heap;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class MedianFinderTest {

    @Test
    public void testMedianFinderOnStreamOfData() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertThat(medianFinder.findMedian()).isEqualTo(1.5);
        medianFinder.addNum(3);
        assertThat(medianFinder.findMedian()).isEqualTo(2);
    }
}