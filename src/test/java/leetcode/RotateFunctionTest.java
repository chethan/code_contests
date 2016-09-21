package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/20/16.
 */
public class RotateFunctionTest {

    @Test
    public void testMaxRotateFunction() throws Exception {
        RotateFunction rotateFunction = new RotateFunction();
        assertThat(rotateFunction.maxRotateFunction(new int[]{4, 3, 2, 6})).isEqualTo(26);
        assertThat(rotateFunction.maxRotateFunction(new int[]{-2147483648,-2147483648})).isEqualTo(-2147483648);
        assertThat(rotateFunction.maxRotateFunction(new int[]{})).isEqualTo(0);
    }
}
