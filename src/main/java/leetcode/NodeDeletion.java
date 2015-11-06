package leetcode;

import ds.ListNode;

/**
 * Created by Chethan on 11/6/15.
 */
public class NodeDeletion {
    //https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode loopNode = head, nthNode = head;
        for (int i = 0; i <= n; i++) {
            if (loopNode == null) {
                if (i == n) {
                    return head.next;
                }
                return head;
            }
            loopNode = loopNode.next;
        }
        while (loopNode != null) {
            loopNode = loopNode.next;
            nthNode = nthNode.next;
        }
        nthNode.next = nthNode.next.next;
        return head;
    }

    //https://leetcode.com/problems/remove-linked-list-elements/
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode loopNode = head, previousNode = null;
        while (loopNode != null) {
            ListNode tempNode = loopNode.next;
            if (loopNode.val == val) {
                if (loopNode != head) {
                    previousNode.next = previousNode.next.next;
                } else {
                    head = loopNode.next;
                }
            } else {
                previousNode = loopNode;
            }
            loopNode = tempNode;
        }
        return head;
    }

    //https://leetcode.com/problems/delete-node-in-a-linked-list/
    public void deleteNode(ListNode node) {
        if(node==null || node.next==null) return;
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
