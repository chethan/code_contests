package leetcode;

import ds.ListNode;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 11/6/15.
 */
public class NodeDeletionTest {

    @Test
    public void testRemoveNthFromEnd() throws Exception {
        NodeDeletion nodeDeletion = new NodeDeletion();
        assertThat(nodeDeletion.removeNthFromEnd(ListNode.from(1, 2, 3, 4, 5), 2).toArray()).
                containsSequence(1, 2, 3, 5);
        assertThat(nodeDeletion.removeNthFromEnd(ListNode.from(1, 2, 3, 4, 5), 5).toArray()).
                containsSequence(2, 3, 4, 5);
    }


    @Test
    public void testRemoveElements() throws Exception {
        NodeDeletion nodeDeletion = new NodeDeletion();
        assertThat(nodeDeletion.removeElements(ListNode.from(1, 2, 6, 3, 4, 5, 6), 6).toArray()).
                containsExactly(1, 2, 3, 4, 5);
        assertThat(nodeDeletion.removeElements(ListNode.from(6, 6, 6, 3, 4, 5, 6), 6).toArray()).
                containsExactly(3, 4, 5);
        assertThat(nodeDeletion.removeElements(ListNode.from(1, 2, 2, 1), 2).toArray()).
                containsExactly( 1,1);
    }
}
