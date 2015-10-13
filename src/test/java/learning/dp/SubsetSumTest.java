package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/12/15.
 */
public class SubsetSumTest {

    @Test
    public void testIsPresent() throws Exception {
        SubsetSum subsetSum = new SubsetSum();
        assertThat(subsetSum.isPresent(new int[]{3, 34, 4, 12, 5, 2}, 9)).isTrue();
    }
}
