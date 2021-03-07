package leetcode.array;

import leetcode.array.ArrayRotator;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/20/16.
 */
public class ArrayRotatorTest {

    @Test
    public void testRotate() throws Exception {
        ArrayRotator arrayRotator = new ArrayRotator();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        arrayRotator.rotate(nums, 3);
        assertThat(nums).containsExactly(5, 6, 7, 1, 2, 3, 4);
        nums = new int[]{1, 2, 3, 4, 5, 6};
        arrayRotator.rotate(nums, 4);
        assertThat(nums).containsExactly(3,4,5,6,1,2);
        nums = new int[]{1, 2};
        arrayRotator.rotate(nums, 1);
        assertThat(nums).containsExactly(2,1);
        nums = new int[]{1, 2};
        arrayRotator.rotate(nums, 0);
        assertThat(nums).containsExactly(1,2);
        nums = new int[]{};
        arrayRotator.rotate(nums, 0);
        assertThat(nums).isEmpty();
    }
}
