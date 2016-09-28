package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/27/16.
 */
public class MissingPositiveNumberFinderTest {

    @Test
    public void testFirstMissingPositive() throws Exception {
        MissingPositiveNumberFinder mpnf = new MissingPositiveNumberFinder();
        assertThat(mpnf.firstMissingPositive(new int[]{2})).isEqualTo(1);
        assertThat(mpnf.firstMissingPositive(new int[]{3, 4, -1, 1})).isEqualTo(2);
        assertThat(mpnf.firstMissingPositive(new int[]{1,2,0})).isEqualTo(3);
        assertThat(mpnf.firstMissingPositive(new int[]{1,3,0})).isEqualTo(2);
        assertThat(mpnf.firstMissingPositive(new int[]{3, 4, -1, 6})).isEqualTo(1);
    }
}
