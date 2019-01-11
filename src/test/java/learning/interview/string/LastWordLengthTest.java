package learning.interview.string;

import learning.interview.string.LastWordLength;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/30/16.
 */
public class LastWordLengthTest {

    @Test
    public void testLengthOfLastWord() throws Exception {
        LastWordLength lastWordLength = new LastWordLength();
        assertThat(lastWordLength.lengthOfLastWord("hello world")).isEqualTo(5);
    }
}
