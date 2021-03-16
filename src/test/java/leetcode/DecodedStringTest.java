package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class DecodedStringTest {

    @Test
    public void testDecodedString() {
        DecodedString decodedString = new DecodedString();
        assertThat(decodedString.decodeString("3[a]2[bc]")).isEqualTo("aaabcbc");
        assertThat(decodedString.decodeString("3[a2[c]]")).isEqualTo("accaccacc");
        assertThat(decodedString.decodeString("2[abc]3[cd]ef")).isEqualTo("abcabccdcdcdef");
        assertThat(decodedString.decodeString("abc3[cd]xyz")).isEqualTo("abccdcdcdxyz");
    }
}