package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import leetcode.Pair;

//https://leetcode.com/problems/word-ladder/
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //Pre processed map
        Map<String, List<String>> variationsMap = new HashMap<>();
        int length = beginWord.length();
        for (String word : wordList) {
            for (int i = 0; i < length; i++) {
                String wordPattern = word.substring(0, i) + "*" + word.substring(i + 1);
                variationsMap.putIfAbsent(wordPattern, new ArrayList<>());
                variationsMap.get(wordPattern).add(word);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new Pair<>(beginWord, 1));
        visited.add(beginWord);

        //BFS and return level
        while (!queue.isEmpty()) {
            Pair<String, Integer> element = queue.poll();
            int level = element.getValue();
            String word = element.getKey();
            for (int i = 0; i < length; i++) {
                String wordPattern =
                    word.substring(0, i) + "*" + word.substring(i + 1);
                for (String nextWord : variationsMap.getOrDefault(wordPattern, List.of())) {
                    if (nextWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.contains(nextWord)) {
                        visited.add(nextWord);
                        queue.add(new Pair<>(nextWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
