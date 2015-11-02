package leetcode;

import ds.ListNode;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 11/2/15.
 */
public class ReversingListTest
{

    @Test
    public void testReverseList() throws Exception {
        ReversingList reversingList = new ReversingList();
        assertThat(reversingList.reverseList(ListNode.from(1, 2, 3, 4)).toArray()).
                containsSequence(4, 3, 2, 1);
        assertThat(reversingList.reverseList(ListNode.from(1)).toArray()).
                containsSequence(1);
    }

    @Test
    public void testReverseListRecursive() throws Exception {
        ReversingList reversingList = new ReversingList();
        assertThat(reversingList.reverseListRecursive(ListNode.from(1, 2, 3, 4)).toArray()).
                containsSequence(4, 3, 2, 1);
        assertThat(reversingList.reverseListRecursive(ListNode.from(1)).toArray()).
                containsSequence(1);

    }
}
