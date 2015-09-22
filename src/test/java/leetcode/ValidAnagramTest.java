package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/21/15.
 */
public class ValidAnagramTest {

    @Test
    public void testIsAnagram() throws Exception {
        ValidAnagram validAnagram = new ValidAnagram();
        assertThat(validAnagram.isAnagram("anagram", "nagaram")).isEqualTo(true);
        assertThat(validAnagram.isAnagram("car", "rat")).isEqualTo(false);
    }
}
