package leetcode;

import leetcode.array.DuplicateRemover;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/22/16.
 */
public class DuplicateRemoverTest {

    @Test
    public void testRemoveDuplicates() throws Exception {
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        int[] nums = new int[]{1, 1, 2};
        assertThat(duplicateRemover.removeDuplicates(nums)).isEqualTo(2);
        assertThat(nums).containsExactly(1, 2, 1);
        nums = new int[]{1, 2,2};
        assertThat(duplicateRemover.removeDuplicates(nums)).isEqualTo(2);
        assertThat(nums).containsExactly(1, 2,2);
        nums = new int[]{1, 1};
        assertThat(duplicateRemover.removeDuplicates(nums)).isEqualTo(1);
        assertThat(nums).containsExactly(1, 1);
        nums = new int[]{1, 1,1,1,1,1};
        assertThat(duplicateRemover.removeDuplicates(nums)).isEqualTo(1);
        assertThat(nums).containsExactly(1, 1,1,1,1,1);
        nums = new int[]{};
        assertThat(duplicateRemover.removeDuplicates(nums)).isEqualTo(0);
    }
}
