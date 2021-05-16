package leetcode.dp;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class RussianDollTest {

    @Test
    public void testMaxEnvelops() {
        RussianDoll russianDoll = new RussianDoll();
        assertThat(russianDoll.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}})).isEqualTo(3);
        assertThat(russianDoll.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}, {1, 1}})).isEqualTo(1);
    }
}