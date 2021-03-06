package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class TrappingRainWaterTest {

    @Test
    public void testRainWaterTrapSize() {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        assertThat(trappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}))
            .isEqualTo(6);
        assertThat(trappingRainWater.trap(new int[]{})).isEqualTo(0);
        assertThat(trappingRainWater.trap(null)).isEqualTo(0);
    }
}