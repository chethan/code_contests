package learning.interview.bitwise;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BitwiseArithmeticTest {

    @Test
    public void testAdd() {
        BitwiseArithmetic bitwiseArithmetic = new BitwiseArithmetic();
        assertThat(bitwiseArithmetic.add(17, 23)).isEqualTo(40);
        assertThat(bitwiseArithmetic.add(1, 2)).isEqualTo(3);
        assertThat(bitwiseArithmetic.add(-2, 3)).isEqualTo(1);
        assertThat(bitwiseArithmetic.add(2, -3)).isEqualTo(-1);
        assertThat(bitwiseArithmetic.add(-1, 1)).isEqualTo(0);
        assertThat(bitwiseArithmetic.add(7, 7)).isEqualTo(14);
    }

    @Test
    public void testSmartAdd() {
        BitwiseArithmetic bitwiseArithmetic = new BitwiseArithmetic();
        assertThat(bitwiseArithmetic.smartAdd(17, 23)).isEqualTo(40);
        assertThat(bitwiseArithmetic.smartAdd(1, 2)).isEqualTo(3);
        assertThat(bitwiseArithmetic.smartAdd(-2, 3)).isEqualTo(1);
        assertThat(bitwiseArithmetic.smartAdd(2, -3)).isEqualTo(-1);
        assertThat(bitwiseArithmetic.smartAdd(-1, 1)).isEqualTo(0);
        assertThat(bitwiseArithmetic.smartAdd(7, 7)).isEqualTo(14);
    }

    @Test
    public void testMultiply() {
        BitwiseArithmetic bitwiseArithmetic = new BitwiseArithmetic();
        assertThat(bitwiseArithmetic.multiply(17, 23)).isEqualTo(391);
        assertThat(bitwiseArithmetic.multiply(1, 2)).isEqualTo(2);
        assertThat(bitwiseArithmetic.multiply(-2, 3)).isEqualTo(-6);
        assertThat(bitwiseArithmetic.multiply(2, -3)).isEqualTo(-6);
        assertThat(bitwiseArithmetic.multiply(-1, 1)).isEqualTo(-1);
        assertThat(bitwiseArithmetic.multiply(7, 7)).isEqualTo(49);
    }

    @Test
    public void testDivide() {
        BitwiseArithmetic bitwiseArithmetic = new BitwiseArithmetic();
        assertThat(bitwiseArithmetic.divide(17, 23)).isEqualTo(0);
        assertThat(bitwiseArithmetic.divide(0, 0)).isEqualTo(0);
        assertThat(bitwiseArithmetic.divide(0, 23)).isEqualTo(0);
        assertThat(bitwiseArithmetic.divide(43, 7)).isEqualTo(6);
        assertThat(bitwiseArithmetic.divide(7, 7)).isEqualTo(1);
    }

    @Test
    public void testPow() {
        System.out.println(Integer.MAX_VALUE);
        BitwiseArithmetic bitwiseArithmetic = new BitwiseArithmetic();
        assertThat(bitwiseArithmetic.pow(1, Integer.MAX_VALUE)).isEqualTo(1);
        assertThat(bitwiseArithmetic.pow(2, Integer.MIN_VALUE)).isEqualTo(0);
        assertThat(bitwiseArithmetic.pow(2, 10)).isEqualTo(1024);
        assertThat(bitwiseArithmetic.pow(2, -2)).isEqualTo(0.25);
    }
}