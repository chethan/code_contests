package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import leetcode.RangeSum.RangeSum2D;
import leetcode.RangeSum.RangeSumArray;
import org.testng.annotations.Test;

public class RangeSumTest {

    @Test
    public void testRangeSumForArray() {
        RangeSum.RangeSumArray sumArray = new RangeSumArray(new int[]{-2, 0, 3, -5, 2, -1});
        assertThat(sumArray.sumRange(0, 2)).isEqualTo(1);
        assertThat(sumArray.sumRange(0, 0)).isEqualTo(-2);
        assertThat(sumArray.sumRange(2, 5)).isEqualTo(-1);
        assertThat(sumArray.sumRange(0, 5)).isEqualTo(-3);
    }

    @Test
    public void testRangeSumFor2D() {
        RangeSum.RangeSum2D rangeSum2D = new RangeSum2D(
            new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}});
        assertThat(rangeSum2D.sumRegion(2, 1, 4, 3)).isEqualTo(8);
        assertThat(rangeSum2D.sumRegion(1, 1, 2, 2)).isEqualTo(11);
        assertThat(rangeSum2D.sumRegion(1, 2, 2, 4)).isEqualTo(12);
    }
}