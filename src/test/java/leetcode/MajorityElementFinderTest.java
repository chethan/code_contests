package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/19/16.
 */
public class MajorityElementFinderTest {

    @Test
    public void testMajorityElement() throws Exception {
        MajorityElementFinder majorityElementFinder = new MajorityElementFinder();
        assertThat(majorityElementFinder.majorityElement(new int[]{4, 2, 4, 4, 4,4})).isEqualTo(4);
    }
}
