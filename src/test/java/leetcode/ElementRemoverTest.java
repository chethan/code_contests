package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/19/16.
 */
public class ElementRemoverTest {

    @Test
    public void testRemoveElement() throws Exception {
        ElementRemover elementRemover = new ElementRemover();
        int[] nums = new int[]{3, 2, 2, 3};
        assertThat(elementRemover.removeElement(nums, 3)).isEqualTo(2);
        assertThat(nums).containsExactly(2, 2, 3, 3);
        nums = new int[]{3, 2, 2, 3};
        assertThat(elementRemover.removeElement(nums, 4)).isEqualTo(4);
        assertThat(nums).containsExactly(3,2,2,3);
        nums = new int[]{3, 3, 3, 3};
        assertThat(elementRemover.removeElement(nums, 3)).isEqualTo(0);
        assertThat(nums).containsExactly(3,3,3,3);
        nums = new int[]{1, 2, 3, 4};
        assertThat(elementRemover.removeElement(nums, 3)).isEqualTo(3);
        assertThat(nums).containsExactly(1,2,4,3);
    }
}
