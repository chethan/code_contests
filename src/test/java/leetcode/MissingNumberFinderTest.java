package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/27/16.
 */
public class MissingNumberFinderTest {

    @Test
    public void testMissingNumber() throws Exception {
        MissingNumberFinder finder = new MissingNumberFinder();
        assertThat(finder.missingNumber(new int[]{0,1,3})).isEqualTo(2);
    }
}
