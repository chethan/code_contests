package leetcode.dp;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class PerfectSquaresTest {

    @Test
    public void testNumSquares() {
        PerfectSquares perfectSquares = new PerfectSquares();
        assertThat(perfectSquares.numSquares(13)).isEqualTo(2);
    }
}