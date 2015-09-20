package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/19/15.
 */
public class HammingWeightTest {

    @Test
    public void testHammingWeight() throws Exception {
        HammingWeight hammingWeight = new HammingWeight();
        assertThat(hammingWeight.hammingWeight(11)).isEqualTo(3);
    }
}
