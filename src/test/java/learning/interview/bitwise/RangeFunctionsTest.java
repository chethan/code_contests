package learning.interview.bitwise;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class RangeFunctionsTest {

    @Test
    public void testRangeBitwiseAnd() {
        RangeFunctions rangeFunctions = new RangeFunctions();
        assertThat(rangeFunctions.rangeBitwiseAnd(5,7)).isEqualTo(4);
        assertThat(rangeFunctions.rangeBitwiseAnd(5,5)).isEqualTo(5);
        assertThat(rangeFunctions.rangeBitwiseAnd(10,11)).isEqualTo(10);
    }

    @Test
    public void testCountPrimeSetBits() {
        RangeFunctions rangeFunctions = new RangeFunctions();
        assertThat(rangeFunctions.countPrimeSetBits(6,10)).isEqualTo(4);
        assertThat(rangeFunctions.countPrimeSetBits(10,15)).isEqualTo(5);
    }
}