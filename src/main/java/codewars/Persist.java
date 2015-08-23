package codewars;

import java.util.Arrays;

/**
 * Created by Chethan on 8/20/15.
 */
public class Persist {
    public int persistence(long n) {
        return compute(n,0);
    }

    private int compute(long n,int steps){
        return n < 10 ? steps : compute(Arrays.stream(Long.toString(n).split("\\B")).map(Integer::valueOf).reduce(1, (a, b) -> a * b), steps + 1);
    }
}
