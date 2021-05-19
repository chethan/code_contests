package learning.interview.string;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Chethan on 8/23/15.
 */
class Anagrams {

    private final Set<String> words;

    Anagrams() throws Exception {
        //TODO: Read from classpath
        words = Files.readAllLines(Paths.get("src/main/resources/words")).
            stream().map(String::toLowerCase).
            collect(Collectors.toSet());
    }

    ////https://leetcode.com/problems/valid-anagram/
    boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] charCounts = new int[256];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i)]++;
            charCounts[t.charAt(i)]--;
        }
        for (int charCount : charCounts) {
            if (charCount != 0) {
                return false;
            }
        }
        return true;
    }


    //https://leetcode.com/problems/group-anagrams/
    List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            map.putIfAbsent(sortedString, new ArrayList<>());
            map.get(sortedString).add(str);
        }
        return map.keySet().stream().map(map::get).collect(Collectors.toList());
    }

    //https://leetcode.com/problems/group-anagrams/
    List<List<String>> groupAnagramsWithoutSorting(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = new char[26];
            for (char c : str.toCharArray()) {
                chars[c - 'a']++;
            }
            String countKey = new String(chars);
            map.putIfAbsent(countKey, new ArrayList<>());
            map.get(countKey).add(str);
        }
        return new ArrayList<>(map.values());
    }

    //https://leetcode.com/problems/group-shifted-strings/
    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String countKey = getKeyBasedOnDifference(str);
            map.putIfAbsent(countKey, new ArrayList<>());
            map.get(countKey).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String getKeyBasedOnDifference(String str) {
        char[] chars = str.toCharArray();
        StringBuilder key = new StringBuilder();
        for(int i = 1; i < chars.length; i++) {
            int diff = chars[i] - chars[i-1];
            key.append(diff < 0 ? diff + 26 : diff);
            key.append(",");
        }
        return key.toString();
    }

    //https://leetcode.com/problems/find-all-anagrams-in-a-string
    //solved using sliding window technique
    List<Integer> findAnagrams(String s, String p) {
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return new ArrayList<>();
        }

        List<Integer> anagramIndicies = new ArrayList<>();
        char[] pchars = p.toCharArray();
        char[] schars = s.toCharArray();
        int[] counter = new int[26];

        for (char pchar : pchars) {
            counter[pchar - 'a']++;
        }

        int start = 0, end = 0, len = pchars.length, diff = len;

        for (; end < len; end++) {
            counter[schars[end] - 'a']--;
            if (counter[schars[end] - 'a'] >= 0) {
                diff--;
            }
        }

        if (diff == 0) {
            anagramIndicies.add(0);
        }

        while (end < schars.length) {
            if (counter[schars[start] - 'a'] >= 0) {
                diff++;
            }
            counter[schars[start] - 'a']++;

            start++;

            counter[schars[end] - 'a']--;

            if (counter[schars[end] - 'a'] >= 0) {
                diff--;
            }
            end++;

            if (diff == 0) {
                anagramIndicies.add(start);
            }
        }

        return anagramIndicies;

    }

    String firstAnagram(String s) {
        return firstAnagram("", s).orElse("");
    }

    private Optional<String> firstAnagram(String soFar, String rest) {
        if (rest.isEmpty()) {
            return words.contains(soFar) ? Optional.of(soFar) : Optional.<String>empty();
        }
        char[] chars = rest.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String nextSoFar = soFar + chars[i];
            Optional<String> permutation = firstAnagram(nextSoFar, rest.substring(0, i) + rest.substring(i + 1));
            if (permutation.isPresent()) {
                return permutation;
            }
        }
        return Optional.empty();

    }

}
