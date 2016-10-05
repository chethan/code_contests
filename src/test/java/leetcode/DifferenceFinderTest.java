package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/27/16.
 */
public class DifferenceFinderTest {

    @Test
    public void testFindTheDifference() throws Exception {
        DifferenceFinder differenceFinder = new DifferenceFinder();
        assertThat(differenceFinder.findTheDifference("abcd", "abcde")).isEqualTo('e');
        assertThat(differenceFinder.findTheDifference("", "z")).isEqualTo('z');
        assertThat(differenceFinder.findTheDifference("abcd", "dfcab")).isEqualTo('f');
        assertThat(differenceFinder.findTheDifference(null, "z")).isEqualTo('z');
    }
}
