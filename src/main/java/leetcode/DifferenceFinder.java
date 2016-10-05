package leetcode;

/**
 * Created by Chethan on 9/27/16.
 */
public class DifferenceFinder {
    public char findTheDifference(String s, String t) {
        int exorValue = s == null ? 0 : s.chars().reduce(0, (left, right) -> left ^ right);
        return (char) (exorValue ^ t.chars().reduce(0, (left, right) -> left ^ right));
    }

}
