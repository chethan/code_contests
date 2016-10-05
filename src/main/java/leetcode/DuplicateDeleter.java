package leetcode;

import ds.ListNode;

/**
 * Created by Chethan on 9/27/16.
 */
public class DuplicateDeleter {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode next = head.next, previous = head;
        while (next != null) {
            if (next.val != previous.val) {
                if (previous.next != next) {
                    previous.next = next;
                    previous = next;
                } else {
                    previous = previous.next;
                }
            }
            next = next.next;
        }
        previous.next = null;
        return head;
    }
}
