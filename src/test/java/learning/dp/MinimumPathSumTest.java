package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/21/15.
 */
public class MinimumPathSumTest {

    @Test
    public void testMinPathSum() throws Exception {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int grid[][] = {{1, 2, 3},
                        {4, 8, 2},
                        {1, 5, 3}};
        assertThat(minimumPathSum.minPathSum(grid)).isEqualTo(11);

    }
}
