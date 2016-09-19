package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/18/16.
 */
public class NumberGuesserTest {

    @Test
    public void testGuessNumber() throws Exception {
        assertThat(getGuesserForNumber(4).guessNumber(6)).isEqualTo(4);
        assertThat(getGuesserForNumber(0).guessNumber(0)).isEqualTo(0);
        assertThat(getGuesserForNumber(1702766719).guessNumber(2126753390)).isEqualTo(1702766719);

    }

    private NumberGuesser getGuesserForNumber(final int actual) {
        return new NumberGuesser() {
            @Override
            public int guess(int number) {
                return actual == number ? 0 : actual > number ? 1 : -1;
            }
        };
    }
}
