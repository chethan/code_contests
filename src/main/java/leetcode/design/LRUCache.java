package leetcode.design;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/
public class LRUCache {

    private static class Node {

        int key;
        int value;
        Node prev;
        Node next;
    }

    private static class DataList {

        Node head;
        Node tail;

        public DataList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(Node node) {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(Node node) {
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        public void moveToHead(Node node) {
            removeNode(node);
            addNode(node);
        }

        public Node popTail() {
            Node node = tail.prev;
            removeNode(node);
            return node;
        }

    }

    private final Map<Integer, Node> cache;
    private int size;
    private final int capacity;
    private final DataList data;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        data = new DataList();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        data.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node();
            node.key = key;
            node.value = value;
            cache.put(key, node);
            data.addNode(node);
            size++;
            if (size > capacity) {
                Node tail = data.popTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            data.moveToHead(node);
        }
    }

}
