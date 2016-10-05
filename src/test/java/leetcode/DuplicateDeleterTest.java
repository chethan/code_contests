package leetcode;

import ds.ListNode;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/27/16.
 */
public class DuplicateDeleterTest {

    @Test
    public void testDeleteDuplicates() throws Exception {
        DuplicateDeleter deleter = new DuplicateDeleter();
        assertThat(deleter.deleteDuplicates(null)).isNull();
        assertThat(deleter.deleteDuplicates(ListNode.from(1)).toArray()).containsExactly(1);
        assertThat(deleter.deleteDuplicates(ListNode.from(1,1)).toArray()).containsExactly(1);
        assertThat(deleter.deleteDuplicates(ListNode.from(1,2)).toArray()).containsExactly(1,2);
        assertThat(deleter.deleteDuplicates(ListNode.from(1, 1, 2)).toArray()).containsExactly(1, 2);
        assertThat(deleter.deleteDuplicates(ListNode.from(2,3,4,5,6,6,6)).toArray()).containsExactly(2,3,4,5,6);
        assertThat(deleter.deleteDuplicates(ListNode.from(2,3,4,5,6,6,6,7)).toArray()).containsExactly(2,3,4,5,6,7);
    }
}
