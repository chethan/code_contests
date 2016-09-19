package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/16/16.
 */
public class IntegerDivisionTest {

    @Test
    public void testDivide() throws Exception {
        IntegerDivision integerDivision = new IntegerDivision();
        assertThat(integerDivision.divide(1, 1)).isEqualTo(1);
        assertThat(integerDivision.divide(-2147483648,-1)).isEqualTo(2147483647);
        assertThat(integerDivision.divide(10, 3)).isEqualTo(3);
        assertThat(integerDivision.divide(10, 0)).isEqualTo(Integer.MAX_VALUE);
        assertThat(integerDivision.divide(3, 10)).isEqualTo(0);
        assertThat(integerDivision.divide(-10, 3)).isEqualTo(-3);
        assertThat(integerDivision.divide(2147483647,1)).isEqualTo(2147483647);
    }
}
