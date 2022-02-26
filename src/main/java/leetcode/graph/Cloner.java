package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cloner {

    //https://leetcode.com/problems/clone-graph/
    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        return deepClone(node, visited);

    }

    private Node deepClone(Node node, Map<Node, Node> visited) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node clonedNode = new Node(node.val);
        visited.put(node, clonedNode);
        if (node.neighbors != null) {
            clonedNode.neighbors = new ArrayList<>();
            for (Node neighbor : node.neighbors) {
                clonedNode.neighbors.add(deepClone(neighbor, visited));
            }
        }
        return clonedNode;
    }

    static class Node {

        int val;
        List<Node> neighbors;

        Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

    }
}
