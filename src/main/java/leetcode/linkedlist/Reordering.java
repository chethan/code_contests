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
        mergeTwoLists(head, secondHead);
    }

    //https://leetcode.com/problems/merge-two-sorted-lists/
    //Time: O(N+M)
    //Space: O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 != null ? list1 : list2;
        return dummyHead.next;
    }

    //https://leetcode.com/problems/merge-two-sorted-lists/
    //Time: O(N+M)
    //Space: O(N+M)
    public ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursion(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoListsRecursion(list1, list2.next);
        return list2;
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
        prev.next = slow.next;
        return head;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return iterativeMerge(left, right);
    }

    ListNode iterativeMerge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }
    //https://leetcode.com/problems/sort-list/

    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
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
}
