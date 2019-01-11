package learning.interview.string;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class SubstringsTest {

    @Test
    public void testLengthOfLongestSubstring() {
        Substrings substrings = new Substrings();
        assertThat(substrings.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
        assertThat(substrings.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
        assertThat(substrings.lengthOfLongestSubstring("abcdefgh")).isEqualTo(8);
        assertThat(substrings.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    }

    @Test
    public void testLengthOfLongestSubstringBetter() {
        Substrings substrings = new Substrings();
        assertThat(substrings.lengthOfLongestSubstringBetter("abcabcbb")).isEqualTo(3);
        assertThat(substrings.lengthOfLongestSubstringBetter("bbbbb")).isEqualTo(1);
        assertThat(substrings.lengthOfLongestSubstringBetter("abcdefgh")).isEqualTo(8);
        assertThat(substrings.lengthOfLongestSubstringBetter("pwwkew")).isEqualTo(3);
    }
    @Test
    public void testRepeatedSubstringPattern() {
        Substrings substrings = new Substrings();
        assertThat(substrings.repeatedSubstringPattern("abab")).isTrue();
        assertThat(substrings.repeatedSubstringPattern("aba")).isFalse();
        assertThat(substrings.repeatedSubstringPattern("abababababac")).isFalse();
        assertThat(substrings.repeatedSubstringPattern("aabaaba")).isFalse();
    }
}