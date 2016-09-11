package codewars;

import java.util.TreeSet;

/**
 * Created by Chethan on 9/10/16.
 */
public class Hamming {

    public static long hamming(int n) {
        TreeSet<Long> hammingNumbers = new TreeSet<>();
        hammingNumbers.add(1L);
        for (int i = 1; i < n; i++) {
            Long number = hammingNumbers.pollFirst();
            hammingNumbers.add(number * 2);
            hammingNumbers.add(number * 3);
            hammingNumbers.add(number * 5);
        }
        return hammingNumbers.pollFirst();
    }

}
