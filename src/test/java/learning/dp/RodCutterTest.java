package learning.dp;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class RodCutterTest {

    @Test
    public void testRodCutter() {
        RodCutter rodCutter = new RodCutter();
        assertThat(rodCutter.maxProfit(new int[]{})).isEqualTo(0);
        assertThat(rodCutter.maxProfit(new int[]{1, 5, 8, 9, 10, 17, 17, 20})).isEqualTo(22);
        assertThat(rodCutter.maxProfit(new int[]{3, 5, 8, 9, 10, 17, 17, 20})).isEqualTo(24);
    }
}