package leetcode.random;

import ds.ListNode;
import java.util.Random;

//https://leetcode.com/problems/linked-list-random-node/
public class RandomNode {

    ListNode head;
    Random random;

    public RandomNode(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        int count = 1, chosenValue = 0;
        ListNode current = head;
        while (current != null) {
            if (random.nextInt(count) == 0) {
                chosenValue = current.val;
            }
            count++;
            current = current.next;
        }
        return chosenValue;
    }
}
