package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/16/15.
 */
public class CuttingSticksTest {

    @Test
    public void testMinimumCost() throws Exception {
        CuttingSticks cuttingSticks= new CuttingSticks();
        assertThat(cuttingSticks.minimumCost(100, new int[]{25, 50, 75})).isEqualTo(200);
        assertThat(cuttingSticks.minimumCost(10, new int[]{4, 5, 7,8})).isEqualTo(22);
    }
}
