package learning.interview.numbers;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverserTest {

    @Test
    public void shouldReverseNumber() {
        Reverser reverser = new Reverser();
        assertThat(reverser.reverse(1463847412)).isEqualTo(2147483641);
        assertThat(reverser.reverse(-123)).isEqualTo(-321);
        assertThat(reverser.reverse(Integer.MAX_VALUE)).isEqualTo(0);

    }

    @Test
    public void shouldCheckForPalindrome() {
        Reverser reverser = new Reverser();
        assertThat(reverser.isPalindrome(1463883641)).isTrue();
        assertThat(reverser.isPalindrome(0)).isTrue();
        assertThat(reverser.isPalindrome(1000021)).isFalse();
    }
}