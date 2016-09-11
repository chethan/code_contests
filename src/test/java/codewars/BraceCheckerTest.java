package codewars;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/10/16.
 */
public class BraceCheckerTest {

    @Test
    public void testIsValid() throws Exception {
        assertThat(BraceChecker.isValid("()[]{}")).isTrue();
        assertThat(BraceChecker.isValid("()[]{")).isFalse();
        assertThat(BraceChecker.isValid(")))")).isFalse();
    }
}
