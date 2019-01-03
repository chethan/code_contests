package learning.interview.arrays;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WaterContainerTest {

    @Test
    public void testMaxArea() {
        WaterContainer waterContainer = new WaterContainer();
        assertThat(waterContainer.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})).isEqualTo(49);
        assertThat(waterContainer.maxArea(new int[]{1, 8, 1, 1, 1, 1, 1, 1, 1})).isEqualTo(8);
        assertThat(waterContainer.maxArea(new int[]{1,9})).isEqualTo(1);
    }
}