package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/22/16.
 */
public class ArrayMergerTest {

    @Test
    public void testMerge() throws Exception {
        ArrayMerger arrayMerger = new ArrayMerger();
        int[] nums1 = new int[]{1, 3, 5, 0, 0, 0};
        arrayMerger.merge(nums1, 3, new int[]{2, 4, 6}, 3);
        assertThat(nums1).containsExactly(1, 2, 3, 4, 5, 6);
        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        arrayMerger.merge(nums1, 3, new int[]{4, 5, 6}, 3);
        assertThat(nums1).containsExactly(1, 2, 3, 4, 5, 6);
        nums1 = new int[]{4, 5, 6, 0, 0, 0};
        arrayMerger.merge(nums1, 3, new int[]{1, 2, 3}, 3);
        assertThat(nums1).containsExactly(1, 2, 3, 4, 5, 6);
        nums1 = new int[]{1,2,0};
        arrayMerger.merge(nums1, 2, new int[]{3}, 1);
        assertThat(nums1).containsExactly(1, 2, 3);
        nums1 = new int[]{1, 3, 5, 0, 0, 0};
        arrayMerger.merge(nums1, 3, new int[]{}, 0);
        assertThat(nums1).containsExactly(1, 3, 5, 0, 0, 0);
    }
}
