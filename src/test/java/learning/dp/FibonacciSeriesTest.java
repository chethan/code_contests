package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 3/12/16.
 */
public class FibonacciSeriesTest {

    @Test
    public void testGetFib() throws Exception {
        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        assertThat(fibonacciSeries.getFib(10)).isEqualTo(89);
        assertThat(fibonacciSeries.getFibDP(10)).isEqualTo(89);
    }
}
