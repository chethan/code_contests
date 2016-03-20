package learning.tech.interview.meetup;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 3/19/16.
 */
public class CakeDistributionTest {

    @Test
    public void testMaximumSlice() throws Exception {
        CakeDistribution cakeDistribution = new CakeDistribution();
//        assertThat(cakeDistribution.maximumSlice(new int[]{8, 7, 11}, 7)).isEqualTo(3.5);
        assertThat(cakeDistribution.maximumSlice(new int[]{500, 300, 200}, 1000)).isEqualTo(1.0);
    }
}
