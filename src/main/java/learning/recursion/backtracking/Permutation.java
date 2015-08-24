package learning.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chethan on 8/23/15.
 */
public class Permutation {
    public ArrayList<String> permute(String s) {
        ArrayList<String> permutations = new ArrayList<>();
        permute("", s, permutations);
        return permutations;
    }

    private void permute(String soFar, String rest, List<String> permutations) {
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
