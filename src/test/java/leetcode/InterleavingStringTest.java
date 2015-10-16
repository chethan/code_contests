package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/15/15.
 */
public class InterleavingStringTest {

    @Test
    public void testIsInterleaveRecursive() throws Exception {
        InterleavingString interleavingString = new InterleavingString();
        assertThat(interleavingString.isInterleaveRecursive("aabcc", "dbbca", "aadbbcbcac")).isTrue();
        assertThat(interleavingString.isInterleaveRecursive("aabcc", "dbbca", "aadbbbaccc")).isFalse();
    }

    @Test
    public void testIsInterleave() throws Exception {
        InterleavingString interleavingString = new InterleavingString();
        assertThat(interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac")).isTrue();
        assertThat(interleavingString.isInterleave("aabcc", "dbbca", "aadbbbaccc")).isFalse();

    }
}
