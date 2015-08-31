package learning.recursion.backtracking;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 8/23/15.
 */
public class BinaryValuesTest {

    @Test
    public void testAllBinaryValues() throws Exception {
        assertThat(new BinaryValues().allBinaryValues(3)).containsExactly("000", "001", "010", "011", "100", "101", "110", "111");
        assertThat(new BinaryValues().allBinaryValues(1)).containsExactly("0", "1");
    }
}