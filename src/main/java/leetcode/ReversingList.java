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
        ListNode next = null;
        ListNode current = head;
        ListNode previous = head.next;
        while (previous != null) {

            ListNode tempNode = previous.next;

            current.next = next;
            previous.next = current;

            next = current;
            current = previous;
            previous = tempNode;
        }
        return current;
    }
}
