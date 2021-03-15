package leetcode.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//https://leetcode.com/problems/replace-words/
public class ReplaceWords {

    private static class TrieNode {

        Map<Character, TrieNode> children = new HashMap<>();
        boolean end;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode node = new TrieNode();
        for (String word : dictionary) {
            insert(node, word);
        }
        List<String> result = new ArrayList<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            String root = search(node, word);
            result.add(Objects.requireNonNullElse(root, word));
        }
        return String.join(" ", result);
    }

    private void insert(TrieNode node, String word) {
        TrieNode current = node;
        for (int i = 0; i < word.length(); i++) {
            current.children.putIfAbsent(word.charAt(i), new TrieNode());
            current = current.children.get(word.charAt(i));
        }
        current.end = true;
    }

    private String search(TrieNode node, String word) {
        TrieNode current = node;
        for (int i = 0; i < word.length(); i++) {
            if (!current.children.containsKey(word.charAt(i))) {
                return null;
            }
            current = current.children.get(word.charAt(i));
            if (current.end) {
                return word.substring(0, i + 1);
            }

        }
        return null;
    }

}
