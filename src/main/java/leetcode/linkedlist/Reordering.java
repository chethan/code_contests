package leetcode.linkedlist;

import ds.ListNode;

public class Reordering {

    //https://leetcode.com/problems/reorder-list/
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode middle = middleNode(head);
        ListNode secondHead = reverseList(middle);
        merge(head, secondHead);
    }

    //https://leetcode.com/problems/merge-two-sorted-lists/
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode first = list1, second = list2;
        while (second.next != null) {
            ListNode futureFirst = first.next;
            ListNode futureSecond = second.next;
            first.next = second;
            second.next = futureFirst;
            first = futureFirst;
            second = futureSecond;
        }
        return first;
    }

    private ListNode reverseList(ListNode node) {
        ListNode prev = null, current = node, next = node.next;
        while (next != null) {
            ListNode temp = next.next;
            current.next = prev;
            next.next = current;
            prev = current;
            current = next;
            next = temp;
        }
        return current;
    }

    //https://leetcode.com/problems/middle-of-the-linked-list/
    private ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = slow.next;
        }
        return head;

    }
}
