package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/19/15.
 */
public class ArrayProductTest {

    @Test
    public void testProductExceptSelf() throws Exception {
        ArrayProduct arrayProduct = new ArrayProduct();
        assertThat(arrayProduct.productExceptSelf(new int[]{1,2,3,4})).contains(24,12,8,6);
        assertThat(arrayProduct.productExceptSelf(new int[]{1,0})).contains(0,1);
        assertThat(arrayProduct.productExceptSelf(new int[]{0,0})).contains(0,0);
        assertThat(arrayProduct.productExceptSelf(new int[]{0,4,0})).contains(0,0,0);
    }
}
