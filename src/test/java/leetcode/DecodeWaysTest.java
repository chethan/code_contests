package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/15/15.
 */
public class DecodeWaysTest {

    @Test
    public void testNumDecodings() throws Exception {
        DecodeWays decodeWays = new DecodeWays();
        assertThat(decodeWays.numDecodings("")).isEqualTo(0);
        assertThat(decodeWays.numDecodings("0")).isEqualTo(0);
        assertThat(decodeWays.numDecodings("10")).isEqualTo(1);
        assertThat(decodeWays.numDecodings("17")).isEqualTo(2);
        assertThat(decodeWays.numDecodings("1111111111")).isEqualTo(89);
    }
}
