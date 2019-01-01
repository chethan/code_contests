package learning.interview.bitwise;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class MaximumWordLengthProductTest {

    @Test
    public void testMaxProduct() {
        MaximumWordLengthProduct maximumWordLengthProduct = new MaximumWordLengthProduct();
        assertThat(maximumWordLengthProduct.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"})).isEqualTo(16);
        assertThat(maximumWordLengthProduct.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"})).isEqualTo(0);
    }
}