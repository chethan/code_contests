package learning.interview.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

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
    public void lengthOfLongestSubstringTwoDistinct() {
        Substrings substrings = new Substrings();
        assertThat(substrings.lengthOfLongestSubstringTwoDistinct("abcabcbb")).isEqualTo(4);
        assertThat(substrings.lengthOfLongestSubstringTwoDistinct("bbbbb")).isEqualTo(5);
        assertThat(substrings.lengthOfLongestSubstringTwoDistinct("abcdefgh")).isEqualTo(2);
        assertThat(substrings.lengthOfLongestSubstringTwoDistinct("pwwkew")).isEqualTo(3);
    }

    @Test
    public void testRepeatedSubstringPattern() {
        Substrings substrings = new Substrings();
        assertThat(substrings.repeatedSubstringPattern("abab")).isTrue();
        assertThat(substrings.repeatedSubstringPattern("aba")).isFalse();
        assertThat(substrings.repeatedSubstringPattern("abababababac")).isFalse();
        assertThat(substrings.repeatedSubstringPattern("aabaaba")).isFalse();
    }

    @Test
    public void testRepeatedSubstringPatternKMP() {
        Substrings substrings = new Substrings();
        assertThat(substrings.repeatedSubstringPatternKMP("a")).isFalse();
        assertThat(substrings.repeatedSubstringPatternKMP("ababa")).isFalse();
        assertThat(substrings.repeatedSubstringPatternKMP("abab")).isTrue();
        assertThat(substrings.repeatedSubstringPatternKMP("aba")).isFalse();
        assertThat(substrings.repeatedSubstringPatternKMP("abababababac")).isFalse();
        assertThat(substrings.repeatedSubstringPatternKMP("aabaaba")).isFalse();
    }
}