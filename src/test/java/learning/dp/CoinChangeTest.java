package learning.dp;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/15/15.
 */
public class CoinChangeTest {

    @Test
    public void testMinCoins() throws Exception {
        CoinChange coinChange = new CoinChange();
        List<Integer> denominations = Arrays.asList(1, 3, 5);
        assertThat(coinChange.minCoins(denominations, 11)).isEqualTo(3);
        assertThat(coinChange.minCoinsMemoization(denominations, 11)).isEqualTo(3);
    }
}