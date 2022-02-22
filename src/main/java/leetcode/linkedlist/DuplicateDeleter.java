package leetcode.linkedlist;

import ds.ListNode;

/**
 * Created by Chethan on 9/27/16.
 */
public class DuplicateDeleter {

    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode loopNode = head;
        while (loopNode.next != null) {
            if (loopNode.val == loopNode.next.val) {
                ListNode duplicateNode = loopNode.next;
                loopNode.next = duplicateNode.next;
                duplicateNode.next = null;
            } else {
                loopNode = loopNode.next;
            }
        }
        return head;
    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
    public ListNode deleteAllDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentinelHead = new ListNode(0, head);
        ListNode loopNode = head, followerNode = sentinelHead;
        boolean foundLastDuplicate = false;
        while (loopNode != null) {
            if (loopNode.next != null && loopNode.val == loopNode.next.val) {
                loopNode = loopNode.next;
                foundLastDuplicate = true;
            } else {
                if (foundLastDuplicate) {
                    followerNode.next = loopNode.next;
                    loopNode = followerNode.next;
                    foundLastDuplicate = false;
                } else {
                    followerNode = loopNode;
                    loopNode = loopNode.next;
                }
            }
        }
        return sentinelHead.next;
    }
}
