package leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutocompleteSystem {

    private final Node trie;
    private String current = "";

    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Node();
        for (int i = 0; i < sentences.length; i++) {
            insert(trie, sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            insert(trie, current, 1);
            current = "";
        } else {
            current += c;
            List<Node> list = lookup(trie, current);
            list.sort((a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence)
                : b.times - a.times);
            for (int i = 0; i < Math.min(3, list.size()); i++) {
                res.add(list.get(i).sentence);
            }
        }
        return res;
    }

    static class Node {

        int times = 0;
        String sentence;
        Map<Character, Node> children;

        Node() {
            this.children = new HashMap<>();
        }
    }

    private void insert(Node t, String s, int times) {
        for (int i = 0; i < s.length(); i++) {
            if (!t.children.containsKey(s.charAt(i))) {
                t.children.put(s.charAt(i), new Node());
            }
            t = t.children.get(s.charAt(i));
        }
        t.times += times;
        t.sentence = s;
    }

    private List<Node> lookup(Node t, String s) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!t.children.containsKey(s.charAt(i))) {
                return new ArrayList<>();
            }
            t = t.children.get(s.charAt(i));
        }
        traverse(s, t, list);
        return list;
    }

    private void traverse(String s, Node t, List<Node> list) {
        if (t.times > 0) {
            list.add(t);
        }
        for (Character c : t.children.keySet()) {
            Node next = t.children.get(c);
            if (next != null) {
                traverse(s, next, list);
            }
        }
    }
}
