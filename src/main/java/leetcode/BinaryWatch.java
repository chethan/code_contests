package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chethan on 10/4/16.
 */
//http://www.programcreek.com/2014/09/leetcode-binary-watch-java/
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int hour = 0; hour < 12; hour++) {
            for (int min = 0; min < 60; min++) {
                int totalBits = countBits(hour) + countBits(min);
                if (totalBits == num) {
                    times.add(hour + ":" + (min < 10 ? "0" : "") + min);
                }
            }
        }
        return times;
    }

    private int countBits(int number) {
        int count = 0;
        while (number > 0) {
            if ((number & 1) == 1) {
                count++;
            }
            number >>= 1;
        }
        return count;
    }

}
