package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/18/16.
 */
public class BinaryAdderTest {

    @Test
    public void testAddBinary() throws Exception {
        BinaryAdder binaryAdder = new BinaryAdder();
        assertThat(binaryAdder.addBinary("111", "1")).isEqualTo("1000");
        assertThat(binaryAdder.addBinary("1", "111")).isEqualTo("1000");
        assertThat(binaryAdder.addBinary("10", "1")).isEqualTo("11");
        assertThat(binaryAdder.addBinary("10", "")).isEqualTo("10");
        assertThat(binaryAdder.addBinary("0", "0")).isEqualTo("0");
        assertThat(binaryAdder.addBinary("", "")).isEqualTo("");
        assertThat(binaryAdder.addBinary("1010", "1011")).isEqualTo("10101");
    }
}
