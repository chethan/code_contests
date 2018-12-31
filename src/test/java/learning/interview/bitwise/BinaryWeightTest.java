package learning.interview.bitwise;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryWeightTest {

    @Test
    public void testNearestNumberWithSameWeight() {
        BinaryWeight binaryWeight = new BinaryWeight();
        assertThat(binaryWeight.nearestNumberWithSameWeight(6)).isEqualTo(5);
        assertThat(binaryWeight.nearestNumberWithSameWeight(7)).isEqualTo(11);

    }
}