package learning.interview.string;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/15/15.
 */
public class ValidParenthesesTest {

    @Test
    public void testLongestValidParentheses() {
        ValidParentheses validParentheses = new ValidParentheses();
        assertThat(validParentheses.longestValidParentheses("((())")).isEqualTo(4);
        assertThat(validParentheses.longestValidParentheses("(()()")).isEqualTo(4);
    }

    @Test
    public void testIsValid() {
        ValidParentheses validParentheses = new ValidParentheses();
        assertThat(validParentheses.isValid("([)]")).isFalse();
        assertThat(validParentheses.isValid("(])")).isFalse();
        assertThat(validParentheses.isValid("()[]{}")).isTrue();

    }
}
