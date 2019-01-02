package learning.interview.numbers;

import java.util.ArrayList;
import java.util.List;

class Clock {

    //https://leetcode.com/problems/largest-time-for-given-digits/
    String largestTimeFromDigits(int[] A) {
        int maxHour = -1, maxMin = -1;
        List<String> permutations = permutation(A);
        for (String permutation : permutations) {
            int parseInt = Integer.parseInt(permutation);
            int hour = parseInt / 100;
            int min = parseInt % 100;
            if (hour <= 23 && min <= 59 && (hour > maxHour || hour == maxHour && min > maxMin)) {
                maxHour = hour;
                maxMin = min;
            }
        }
        if (maxHour < 0) return "";
        return getString(maxHour) + ":" + getString(maxMin);
    }

    private String getString(int value) {
        return value > 9 ? value + "" : ("0" + value);
    }

    private List<String> permutation(int[] options) {
        List<String> permutations = new ArrayList<>();
        if (options.length == 0) return permutations;
        if (options.length == 1) {
            permutations.add("" + options[0]);
            return permutations;
        }
        for (int i = 0; i < options.length; i++) {
            int[] newOptions = new int[options.length - 1];
            System.arraycopy(options, 0, newOptions, 0, i);
            System.arraycopy(options, i + 1, newOptions, i, options.length - i - 1);
            List<String> results = permutation(newOptions);
            for (String result : results) {
                permutations.add("" + options[i] + result);
            }
        }

        return permutations;
    }


}