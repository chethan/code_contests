package leetcode;

import ds.ListNode;

/**
 * Created by Chethan on 11/2/15.
 */
public class ReversingList {

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = null;
        ListNode rest = reverseListRecursive(next);
        next.next = head;
        return rest;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode previous = null;
        ListNode current = head;
        while (current!= null) {
            ListNode tempNode = current.next;
            current.next = previous;
            previous = current;
            current = tempNode;
        }
        return previous;
    }
}
