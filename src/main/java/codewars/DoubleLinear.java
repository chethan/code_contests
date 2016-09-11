package codewars;

import java.util.TreeSet;

/**
 * Created by Chethan on 9/10/16.
 */
public class DoubleLinear {
    public static int dblLinear(int n) {
        TreeSet<Integer> sequence = new TreeSet<>();
        sequence.add(1);
        if (n < 0) return 0;
        for (int i = 0; !sequence.isEmpty(); i++) {
            if (i == n) return sequence.pollFirst();
            Integer integer = sequence.pollFirst();
            sequence.add(2 * integer + 1);
            sequence.add(3 * integer + 1);
        }
        return 0;
    }
}
