package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTree {

    //https://leetcode.com/problems/clone-n-ary-tree/
    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }
        ArrayList<Node> clonedChildren = new ArrayList<>();
        if (root.children != null) {
            root.children.stream().map(this::cloneTree)
                .forEach(clonedChildren::add);
        }
        return new Node(root.val, clonedChildren);
    }

    //https://leetcode.com/problems/clone-n-ary-tree/
    public Node cloneTreeBFS(Node root) {
        if (root == null) {
            return null;
        }
        Node clonedNode = new Node(root.val, new ArrayList<>());
        Queue<Node[]> queue = new LinkedList<>();
        queue.offer(new Node[]{root, clonedNode});
        while (!queue.isEmpty()) {
            Node[] currentNodes = queue.poll();
            Node oldNode = currentNodes[0];
            Node newNode = currentNodes[1];
            for (Node childNode : oldNode.children) {
                Node newChildNode = new Node(childNode.val, new ArrayList<>());
                newNode.children.add(newChildNode);
                queue.offer(new Node[]{childNode, newChildNode});
            }
        }
        return clonedNode;
    }

    private static class Node {

        public int val;
        public List<Node> children;

        public Node(int val, ArrayList<Node> _children) {
            this.val = val;
            children = _children;
        }
    }
}
