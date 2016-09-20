package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/19/16.
 */
public class ZeroMoverTest {

    @Test
    public void testMoveZeroes() throws Exception {
        ZeroMover zeroMover = new ZeroMover();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        zeroMover.moveZeroes(nums);
        assertThat(nums).containsExactly(1, 3, 12, 0, 0);
        nums = new int[]{0, 0, 0, 0, 0};
        zeroMover.moveZeroes(nums);
        assertThat(nums).containsExactly(0, 0, 0, 0, 0);
        nums = new int[]{1, 2, 3, 4, 5};
        zeroMover.moveZeroes(nums);
        assertThat(nums).containsExactly(1, 2, 3, 4, 5);
        nums = new int[]{};
        zeroMover.moveZeroes(nums);
        assertThat(nums).isEmpty();
        nums = new int[]{1, 2, 3, 0, 0};
        zeroMover.moveZeroes(nums);
        assertThat(nums).containsExactly(1, 2, 3, 0, 0);


    }
}
