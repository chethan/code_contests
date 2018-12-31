package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PeakFinderTest {
    @Test
    public void shouldFindPeak() {
        PeakFinder peakFinder = new PeakFinder();
        assertThat(peakFinder.findPeakElement(new int[]{})).isEqualTo(-1);
        assertThat(peakFinder.findPeakElement(new int[]{1})).isEqualTo(0);
        assertThat(peakFinder.findPeakElement(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})).isEqualTo(8);
        assertThat(peakFinder.findPeakElement(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1})).isEqualTo(0);
        assertThat(peakFinder.findPeakElement(new int[]{1, 2, 5, 4, 2, 1})).isEqualTo(2);
    }

    @Test
    public void shouldFind2DPeak() {
        PeakFinder peakFinder = new PeakFinder();
        assertThat(peakFinder.find2DPeak(new int[1][0])).isEqualTo(-1);
        assertThat(peakFinder.find2DPeak(new int[0][0])).isEqualTo(-1);
        assertThat(peakFinder.find2DPeak(new int[][]{{1, 2, 3}, {3, 4, 5}})).isEqualTo(5);
        assertThat(peakFinder.find2DPeak(new int[][]{{10, 7}, {11, 17}})).isEqualTo(17);
        assertThat(peakFinder.find2DPeak(new int[][]{{10, 8, 10, 10},
                {14, 13, 12, 11},
                {15, 9, 11, 21},
                {22, 20, 19, 18}})).isEqualTo(22);
        assertThat(peakFinder.find2DPeak(new int[][]{{16, 3, 8, 3},
                {2, 4, 9, 15},
                {4, 2, 7, 16},
                {9, 1, 2, 17},
                {5, 6, 20, 18}}

        )).isEqualTo(20);
    }
}
