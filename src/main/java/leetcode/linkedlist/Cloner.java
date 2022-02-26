package leetcode.linkedlist;

import java.util.HashMap;

public class Cloner {

    private final HashMap<Node, Node> visited = new HashMap<>();

    //https://leetcode.com/problems/copy-list-with-random-pointer/
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (visited.containsKey(head)) {
            return visited.get(head);
        }
        Node clonedHead = new Node(head.val);
        visited.put(head, clonedHead);
        clonedHead.next = copyRandomList(head.next);
        clonedHead.random = copyRandomList(head.random);
        return clonedHead;
    }

    public Node copyRandomListIteratively(Node head) {
        if (head == null) {
            return null;
        }
        Node loopNode = head;
        while (loopNode != null) {
            Node clonedNode = new Node(loopNode.val);
            clonedNode.next = loopNode.next;
            loopNode.next = clonedNode;
            loopNode = clonedNode.next;
        }
        loopNode = head;
        while (loopNode != null) {
            if (loopNode.random != null) {
                loopNode.next.random = loopNode.random.next;
            }
            loopNode = loopNode.next.next;
        }
        Node clonedHead = head.next;
        Node oldLoopNode = head;
        Node newLoopNode = head.next;
        while (oldLoopNode != null) {
            oldLoopNode.next = newLoopNode.next;
            if (newLoopNode.next != null) {
                newLoopNode.next = newLoopNode.next.next;
            }
            oldLoopNode = oldLoopNode.next;
            newLoopNode = newLoopNode.next;

        }
        return clonedHead;
    }

    private static class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
