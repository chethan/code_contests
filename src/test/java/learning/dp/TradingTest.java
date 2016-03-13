package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 3/12/16.
 */
public class TradingTest {

    @Test
    public void testFinalCash() throws Exception {
        Trading trading= new Trading();
        assertThat(trading.finalCash(7)).isEqualTo(7);
        assertThat(trading.finalCash(100)).isEqualTo(120);
        assertThat(trading.finalCashTD(7)).isEqualTo(7);
        assertThat(trading.finalCashTD(100)).isEqualTo(120);
    }
}
