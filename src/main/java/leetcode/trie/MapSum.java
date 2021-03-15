package leetcode.trie;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/map-sum-pairs/
class MapSum {

    private final Map<String, Integer> countMap;
    private final TrieNode node;

    private static class TrieNode {

        Map<Character, TrieNode> children = new HashMap<>();
        int score;
    }

    public MapSum() {
        node = new TrieNode();
        countMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - countMap.getOrDefault(key, 0);
        countMap.put(key, val);
        TrieNode current = node;
        current.score += delta;
        for (int i = 0; i < key.length(); i++) {
            current.children.putIfAbsent(key.charAt(i), new TrieNode());
            current = current.children.get(key.charAt(i));
            current.score += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode current = node;
        for (char c : prefix.toCharArray()) {
            current = current.children.get(c);
            if (current == null) {
                return 0;
            }
        }
        return current.score;
    }
}

