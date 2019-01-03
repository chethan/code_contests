package learning.interview.linkedList;

import ds.ListNode;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SegregatorTest {

    @Test
    public void testEvenOdd() {
        Segregator segregator = new Segregator();
        assertThat(segregator.evenOdd(ListNode.from(1, 2, 3, 4, 5)).toArray()).containsExactly(1, 3, 5, 2, 4);
        assertThat(segregator.evenOdd(ListNode.from(2, 1, 3, 5, 6, 4, 7)).toArray()).containsExactly(1, 3, 5, 7, 2, 6, 4);
        assertThat(segregator.evenOdd(ListNode.from(1, 3, 5, 7)).toArray()).containsExactly(1, 3, 5, 7);
        assertThat(segregator.evenOdd(ListNode.from(2, 4, 6, 8)).toArray()).containsExactly(8, 2, 4, 6);


    }
}