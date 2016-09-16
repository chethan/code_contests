package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/16/16.
 */
public class IntegerDivisonTest {

    @Test
    public void testDivide() throws Exception {
        IntegerDivison integerDivison = new IntegerDivison();
        assertThat(integerDivison.divide(1, 1)).isEqualTo(1);
        assertThat(integerDivison.divide(-2147483648,-1)).isEqualTo(2147483647);
        assertThat(integerDivison.divide(10, 3)).isEqualTo(3);
        assertThat(integerDivison.divide(10, 0)).isEqualTo(Integer.MAX_VALUE);
        assertThat(integerDivison.divide(3, 10)).isEqualTo(0);
        assertThat(integerDivison.divide(-10, 3)).isEqualTo(-3);
        assertThat(integerDivison.divide(2147483647,1)).isEqualTo(2147483647);
    }
}
