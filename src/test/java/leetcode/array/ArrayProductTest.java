package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

/**
 * Created by Chethan on 9/19/15.
 */
public class ArrayProductTest {

    @Test
    public void testProductExceptSelf() throws Exception {
        ArrayProduct arrayProduct = new ArrayProduct();
        assertThat(arrayProduct.productExceptSelf(new int[]{1, 2, 3, 4})).contains(24, 12, 8, 6);
        assertThat(arrayProduct.productExceptSelf(new int[]{1, 0})).contains(0, 1);
        assertThat(arrayProduct.productExceptSelf(new int[]{0, 0})).contains(0, 0);
        assertThat(arrayProduct.productExceptSelf(new int[]{0, 4, 0})).contains(0, 0, 0);
    }

    @Test
    public void testProductExceptSelfWithoutDivision() throws Exception {
        ArrayProduct arrayProduct = new ArrayProduct();
        assertThat(arrayProduct.productExceptSelfWithoutDivision(new int[]{1, 2, 3, 4})).contains(24, 12, 8, 6);
        assertThat(arrayProduct.productExceptSelfWithoutDivision(new int[]{1, 0})).contains(0, 1);
        assertThat(arrayProduct.productExceptSelfWithoutDivision(new int[]{0, 0})).contains(0, 0);
        assertThat(arrayProduct.productExceptSelfWithoutDivision(new int[]{0, 4, 0})).contains(0, 0, 0);
    }
}
