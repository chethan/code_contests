package learning.interview.string;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/15/15.
 */
public class ParenthesesTest {

    @Test
    public void testLongestValidParentheses() {
        String[] s = "avcd; e'fgh.".replaceAll("[\\.\\?\\;\\.\\']", "").split("[\\S,]");

        Parentheses parentheses = new Parentheses();
        assertThat(parentheses.longestValidParentheses("((())")).isEqualTo(4);
        assertThat(parentheses.longestValidParentheses("(()()")).isEqualTo(4);
    }

    @Test
    public void testIsValid() {
        Parentheses parentheses = new Parentheses();
        assertThat(parentheses.isValid("([)]")).isFalse();
        assertThat(parentheses.isValid("(])")).isFalse();
        assertThat(parentheses.isValid("()[]{}")).isTrue();

    }

    @Test
    public void testGenerateParenthesis() {
        Parentheses parentheses = new Parentheses();
        assertThat(parentheses.generateParenthesis(1)).containsOnly("()");
        assertThat(parentheses.generateParenthesis(3)).containsOnly("()()()", "(())()", "(()())", "()(())", "((()))");

    }

    @Test
    public void testCheckValidString() {
        Parentheses parentheses = new Parentheses();
        assertThat(parentheses.checkValidString("(*)")).isTrue();
        assertThat(parentheses.checkValidString("***")).isTrue();
        assertThat(parentheses.checkValidString("(*))")).isTrue();

    }
}
