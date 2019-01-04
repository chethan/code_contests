package learning.interview.arrays;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RangeFunctionsTest {
    @Test
    public void testSummaryRanges() {
        RangeFunctions rangeFunctions = new RangeFunctions();
        assertThat(rangeFunctions.summaryRanges(new int[]{1,2,3,4})).containsExactly("1->4");
        assertThat(rangeFunctions.summaryRanges(new int[]{0,2,3,4,6,8,9})).containsExactly("0","2->4","6","8->9");
        assertThat(rangeFunctions.summaryRanges(new int[]{4})).containsExactly("4");
        assertThat(rangeFunctions.summaryRanges(new int[]{})).isEmpty();
    }
}