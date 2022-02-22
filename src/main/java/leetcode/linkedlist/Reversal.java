package leetcode.linkedlist;

import ds.ListNode;

public class Reversal {

    //https://leetcode.com/problems/reverse-linked-list-ii/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode from = null, to = null, prev = null;
        ListNode loopNode = head;
        if (head == null || head.next == null) {
            return head;
        }
        int count = 1;
        while (loopNode != null) {
            if (count == left) {
                from = loopNode;
            }
            if (count == right) {
                to = loopNode.next;
            }
            if (count == left - 1) {
                prev = loopNode;
            }
            count++;
            loopNode = loopNode.next;
        }
        //head node of the reversed list
        ListNode node = reverseList(from, to);
        if (prev != null) {
            prev.next = node;
        }
        //reversed from head
        else {
            head = node;
        }
        //connecting last node to rest of the list
        if (from != null) {
            from.next = to;
        }
        return head;


    }

    //https://leetcode.com/problems/reverse-linked-list/
    private ListNode reverseList(ListNode from, ListNode to) {
        if (from == null || from.next == null) {
            return from;
        }
        ListNode previous = null;
        ListNode current = from;
        ListNode next = from.next;
        while (next != to) {
            ListNode tempNode = next.next;
            current.next = previous;
            next.next = current;
            previous = current;
            current = next;
            next = tempNode;
        }
        return current;
    }

    private ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode rest = reverseListRecursive(next);
        next.next = head;
        return rest;
    }
}
