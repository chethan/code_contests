package learning.interview.arrays;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class ArrayArithmeticTest {

    @Test
    public void testPlusOne() {
        ArrayArithmetic arrayArithmetic = new ArrayArithmetic();
        assertThat(arrayArithmetic.plusOne(new int[]{9})).containsExactly(1,0);
        assertThat(arrayArithmetic.plusOne(new int[]{1})).containsExactly(2);
        assertThat(arrayArithmetic.plusOne(new int[]{})).isEmpty();
        assertThat(arrayArithmetic.plusOne(new int[]{9,9,9})).containsExactly(1,0,0,0);
        assertThat(arrayArithmetic.plusOne(new int[]{9,1,9,9,9})).containsExactly(9,2,0,0,0);
    }

     @Test
    public void addBinary() {
        ArrayArithmetic arrayArithmetic = new ArrayArithmetic();
        assertThat(arrayArithmetic.addBinary("11","1")).isEqualTo("100");
        assertThat(arrayArithmetic.addBinary("11","")).isEqualTo("11");
        assertThat(arrayArithmetic.addBinary("1111","1111")).isEqualTo("11110");
        assertThat(arrayArithmetic.addBinary("","")).isEqualTo("");
        assertThat(arrayArithmetic.addBinary("0","0")).isEqualTo("0");
    }
}