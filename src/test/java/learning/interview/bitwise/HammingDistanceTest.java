package learning.interview.bitwise;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class HammingDistanceTest {

    @Test
    public void testHammingDistance() {
        HammingDistance hammingDistance = new HammingDistance();
        assertThat(hammingDistance.hammingDistance(4, 4)).isEqualTo(0);
        assertThat(hammingDistance.hammingDistance(1, 4)).isEqualTo(2);
    }

    @Test
    public void testTotalHammingDistance() {
        HammingDistance hammingDistance = new HammingDistance();
        assertThat(hammingDistance.totalHammingDistance(new int[]{4, 14, 2})).isEqualTo(6);
    }
}