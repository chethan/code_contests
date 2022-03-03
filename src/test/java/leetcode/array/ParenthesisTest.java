package leetcode.array;

import static org.assertj.core.api.StrictAssertions.assertThat;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ParenthesisTest extends TestCase {

    @Test
    public void testLongestValidParentheses() {
        Parenthesis parentheses = new Parenthesis();
        assertThat(parentheses.longestValidParentheses("((())")).isEqualTo(4);
        assertThat(parentheses.longestValidParentheses("(()()")).isEqualTo(4);
    }

    @Test
    public void testIsValid() {
        Parenthesis parentheses = new Parenthesis();
        assertThat(parentheses.isValid("([)]")).isFalse();
        assertThat(parentheses.isValid("(])")).isFalse();
        assertThat(parentheses.isValid("()[]{}")).isTrue();

    }

    @Test
    public void testGenerateParenthesis() {
        Parenthesis parentheses = new Parenthesis();
        Assertions.assertThat(parentheses.generateParenthesis(1)).containsOnly("()");
        Assertions.assertThat(parentheses.generateParenthesis(3))
            .containsOnly("()()()", "(())()", "(()())", "()(())", "((()))");

    }

    @Test
    public void testCheckValidString() {
        Parenthesis parentheses = new Parenthesis();
        assertThat(parentheses.checkValidString("(*)")).isTrue();
        assertThat(parentheses.checkValidString("***")).isTrue();
        assertThat(parentheses.checkValidString("(*))")).isTrue();

    }
}