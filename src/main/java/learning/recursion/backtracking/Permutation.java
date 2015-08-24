package learning.recursion.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chethan on 8/23/15.
 */
public class Permutation {
    public Set<String> permute(String s) {
        Set<String> permutations = new HashSet<>();
        permute("", s, permutations);
        return permutations;
    }

    private void permute(String soFar, String rest, Set<String> permutations) {
        if (rest.isEmpty()) {
            permutations.add(soFar);
        }
        char[] chars = rest.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String nextSoFar = soFar + chars[i];
            permute(nextSoFar, rest.substring(0, i) + rest.substring(i + 1), permutations);
        }
    }
}
