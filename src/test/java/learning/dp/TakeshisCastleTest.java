package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.within;

/**
 * Created by Chethan on 10/4/15.
 */
public class TakeshisCastleTest {

    @Test
    public void testBestProbablity() throws Exception {
        TakeshisCastle takeshisCastle = new TakeshisCastle();
        assertThat(takeshisCastle.bestProbability(3, 10, new double[]{0.5, 0.4, 0.6, 0.8, 1.0},
                new int[]{2, 3, 5, 6, 8})).isCloseTo(0.32, within(0.1));
    }
}
