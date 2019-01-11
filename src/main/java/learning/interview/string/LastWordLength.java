package learning.interview.string;

/**
 * Created by Chethan on 9/30/16.
 */
public class LastWordLength {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) return 0;
        String[] split = s.split("\\s+");
        if (split.length == 0) return 0;
        return split[split.length - 1].length();
    }
}
