package codewars;

import java.util.Arrays;

/**
 * Created by Chethan on 8/12/15.
 */
public class PartialWordSearching {
    public String[] findWord(String x, String[] y) {
        String[] collect = Arrays.stream(y).filter(str -> str.toLowerCase().contains(x.toUpperCase())).toArray(String[]::new);
        return collect.length==0?new String[]{"Empty"}:collect;
    }
}
