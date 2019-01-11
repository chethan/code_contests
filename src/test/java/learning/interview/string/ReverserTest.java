package learning.interview.string;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class ReverserTest {

    @Test
    public void testReverseWords() {
        Reverser reverser = new Reverser();
        assertThat(reverser.reverseWords("")).isEqualTo("");
        assertThat(reverser.reverseWords("NoWords")).isEqualTo("sdroWoN");
        assertThat(reverser.reverseWords("Let's take LeetCode contest")).isEqualTo("s'teL ekat edoCteeL tsetnoc");

    }

    @Test
    public void testReverseWordOrder() {
        Reverser reverser = new Reverser();
        assertThat(reverser.reverseWordOrder("")).isEqualTo("");
        assertThat(reverser.reverseWordOrder("NoWords")).isEqualTo("NoWords");
        assertThat(reverser.reverseWordOrder("Let's take LeetCode contest")).isEqualTo("contest LeetCode take Let's");
        assertThat(reverser.reverseWordOrder("   Let's    take    LeetCode    contest   ")).isEqualTo("contest LeetCode take Let's");
        assertThat(reverser.reverseWordOrder("  ")).isEqualTo("");
    }

    @Test
    public void testReversString() {
        Reverser reverser = new Reverser();
        assertThat(reverser.reverseString("")).isEqualTo("");
        assertThat(reverser.reverseString("NoWords")).isEqualTo("sdroWoN");
        assertThat(reverser.reverseString("Let's take LeetCode contest")).isEqualTo("tsetnoc edoCteeL ekat s'te");
    }

    @Test
    public void testReverseVowels() {
        Reverser reverser = new Reverser();
        assertThat(reverser.reverseVowels("hello")).isEqualTo("holle");
        assertThat(reverser.reverseVowels("leetcode")).isEqualTo("leotcede");
        assertThat(reverser.reverseVowels("")).isEqualTo("");
        assertThat(reverser.reverseVowels("e")).isEqualTo("e");
    }
}