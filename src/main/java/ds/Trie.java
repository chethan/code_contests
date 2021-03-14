package ds;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/implement-trie-prefix-tree/
public class Trie {

    TrieNode node;
    /**
     * Initialize your data structure here.
     */
    public Trie() {
        node = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode current = node;
        for (int i = 0; i < word.length(); i++) {
            if (!current.node.containsKey(word.charAt(i))) {
                current.node.put(word.charAt(i), new TrieNode());
            }
            current = current.node.get(word.charAt(i));
        }
        current.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode current = searchPrefix(word);
        return current != null && current.end;

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;

    }

    private static class TrieNode {
        Map<Character, TrieNode> node = new HashMap<>();
        boolean end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    private TrieNode searchPrefix(String prefix) {
        TrieNode current = node;
        for (int i = 0; i < prefix.length(); i++) {
            if (!current.node.containsKey(prefix.charAt(i))) {
                return null;
            }
            current = current.node.get(prefix.charAt(i));
        }
        return current;
    }
}

