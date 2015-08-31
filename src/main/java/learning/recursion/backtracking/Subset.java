package learning.recursion.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chethan on 8/23/15.
 */
public class Subset {
    public Set<String> generateSubsets(String s) {
        Set<String> subsets = new HashSet<>();
        generateSubsets("", s, subsets);
        return subsets;
    }

    private void generateSubsets(String soFar, String rest, Set<String> subsets) {
        if (rest.isEmpty()) {
            subsets.add(soFar);
        }
        char[] chars = rest.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            generateSubsets(soFar + chars[i], rest.substring(i + 1), subsets);
            generateSubsets(soFar, rest.substring(i + 1), subsets);
        }
    }
}
