package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Ch
 * ethan on 9/18/16.
 */
public class IncrementerTest {

    @Test
    public void testPlusOne() throws Exception {
        Incrementer incrementer = new Incrementer();
        assertThat(incrementer.plusOne(new int[]{1,2,3})).isEqualTo(new int[]{1,2,4});
        assertThat(incrementer.plusOne(new int[]{9,9,9})).isEqualTo(new int[]{1,0,0,0});
        assertThat(incrementer.plusOne(new int[]{8,9,9,9})).isEqualTo(new int[]{9,0,0,0});
        assertThat(incrementer.plusOne(new int[]{})).isEqualTo(new int[]{1});
        assertThat(incrementer.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0})).isEqualTo(new int[]{9,8,7,6,5,4,3,2,1,1});
        assertThat(incrementer.plusOne(new int[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6})).isEqualTo(new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,7});
    }
}
