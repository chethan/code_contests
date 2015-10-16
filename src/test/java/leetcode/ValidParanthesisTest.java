package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/15/15.
 */
public class ValidParanthesisTest {

    @Test
    public void testLongestValidParentheses() throws Exception {
        ValidParanthesis validParanthesis = new ValidParanthesis();
        assertThat(validParanthesis.longestValidParentheses("((())")).isEqualTo(4);
        assertThat(validParanthesis.longestValidParentheses("(()()")).isEqualTo(4);
    }

    @Test
    public void testIsValid() throws Exception {
        ValidParanthesis validParanthesis = new ValidParanthesis();
        assertThat(validParanthesis.isValid("([)]")).isFalse();
        assertThat(validParanthesis.isValid("(])")).isFalse();
        assertThat(validParanthesis.isValid("()[]{}")).isTrue();

    }
}
