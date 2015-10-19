package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/16/15.
 */
public class BuySellStocksTest {

    @Test
    public void testMaxProfit() throws Exception {
        BuySellStocks buySellStocks = new BuySellStocks();
        assertThat(buySellStocks.maxProfit(new int[]{10, 100, 1, 5, 7, 88})).isEqualTo(90);
        assertThat(buySellStocks.maxProfit1(new int[]{10, 100, 1, 5, 7, 88})).isEqualTo(177);
        assertThat(buySellStocks.maxProfit2(new int[]{1, 4, 5, 7, 6, 3, 2, 9})).isEqualTo(13);
        assertThat(buySellStocks.maxProfit2Faster(new int[]{1, 4, 5, 7, 6, 3, 2, 9})).isEqualTo(13);
    }
}
