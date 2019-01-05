package learning.interview.string;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class StringCompressionTest {

    @Test
    public void testCompress() {
        StringCompression stringCompression = new StringCompression();
        assertThat(stringCompression.compress(new char[]{'a','a','b','b','c','c','c'})).isEqualTo(6);
        assertThat(stringCompression.compress(new char[]{'a','a'})).isEqualTo(2);
        assertThat(stringCompression.compress(new char[]{'a'})).isEqualTo(1);
        assertThat(stringCompression.compress(new char[]{'a','b'})).isEqualTo(2);
        assertThat(stringCompression.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'})).isEqualTo(4);
    }
}