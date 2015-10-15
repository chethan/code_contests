package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/15/15.
 */
public class ClimbingStairsTest {

    @Test
    public void testClimbStairs() throws Exception {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        assertThat(climbingStairs.climbStairs(2)).isEqualTo(2);
        assertThat(climbingStairs.climbStairs(3)).isEqualTo(3);
    }
}
