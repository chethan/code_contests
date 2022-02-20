package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {


    public String alienOrder(String[] words) {
        //convert words to adjacency list
        Map<Character, List<Character>> adjacencyList = new HashMap<>();
        Map<Character, Integer> incomingDegreeCount = new HashMap<>();
        boolean isValid = constructAdjacencyList(words, adjacencyList, incomingDegreeCount);
        if (!isValid) {
            return "";
        }
        // topological sort
        StringBuilder result = topologicalSort(adjacencyList, incomingDegreeCount);
        if (result.length() < incomingDegreeCount.size()) {
            return "";
        }
        return result.toString();
    }

    private StringBuilder topologicalSort(Map<Character, List<Character>> adjacencyList,
        Map<Character, Integer> incomingDegreeCount) {
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        for (char c : incomingDegreeCount.keySet()) {
            if (incomingDegreeCount.get(c) == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);
            List<Character> outgoing = adjacencyList.get(c);
            for (char next : outgoing) {
                incomingDegreeCount.put(next, incomingDegreeCount.get(next) - 1);
                if (incomingDegreeCount.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return result;
    }

    private boolean constructAdjacencyList(String[] words,
        Map<Character, List<Character>> adjacencyList,
        Map<Character, Integer> incomingDegreeCount) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjacencyList.putIfAbsent(c, new ArrayList<>());
                incomingDegreeCount.putIfAbsent(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            //invalid lexicographical order (prefix should come first)
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return false;
            }
            int minLength = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjacencyList.get(word1.charAt(j)).add(word2.charAt(j));
                    incomingDegreeCount
                        .put(word2.charAt(j), incomingDegreeCount.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        return true;
    }
}
