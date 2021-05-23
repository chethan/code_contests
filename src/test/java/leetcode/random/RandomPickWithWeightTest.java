package leetcode.random;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class RandomPickWithWeightTest {

    @Test
    public void testRandomPick() {
        var randomPickWithWeight = new RandomPickWithWeight(new int[]{1});
        assertThat(randomPickWithWeight.pickIndex()).isEqualTo(0);
        assertThat(randomPickWithWeight.pickIndex()).isEqualTo(0);
    }
}