package leetcode.linkedlist;

import ds.ListNode;

public class PalindromeDetection {

    //https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //Find middle Node
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        //Reverse second part of the list
        ListNode secondHead = reverseList(slow);
        //Compare both halves
        while (head != null) {
            if (head.val != secondHead.val) {
                return false;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        return true;
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
}
