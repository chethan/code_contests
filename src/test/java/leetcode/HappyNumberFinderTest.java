package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/23/16.
 */
public class HappyNumberFinderTest {

    @Test
    public void testIsHappy() throws Exception {
        HappyNumberFinder happyNumberFinder = new HappyNumberFinder();
        assertThat(happyNumberFinder.isHappy(19)).isTrue();
        assertThat(happyNumberFinder.isHappy(0)).isFalse();
        assertThat(happyNumberFinder.isHappy(1)).isTrue();
        assertThat(happyNumberFinder.isHappy(4)).isFalse();
        assertThat(happyNumberFinder.isHappy(2)).isFalse();
    }
}
