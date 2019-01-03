package learning.interview.arrays;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/19/16.
 */
public class MajorityElementFinderTest {

    @Test
    public void testMajorityElement() {
        MajorityElementFinder majorityElementFinder = new MajorityElementFinder();
        assertThat(majorityElementFinder.majorityElement(new int[]{4, 2, 4, 4, 4, 4})).isEqualTo(4);
        assertThat(majorityElementFinder.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})).isEqualTo(2);
        assertThat(majorityElementFinder.majorityElement(new int[]{3, 2, 3})).isEqualTo(3);
        assertThat(majorityElementFinder.majorityElement(new int[]{3})).isEqualTo(3);
    }
}
