package leetcode.array;

import java.util.Map;
import java.util.stream.IntStream;

//https://leetcode.com/problems/strobogrammatic-number/
public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {

        Map<Character, Character> turnMap = Map.of('0', '0', '6', '9', '9', '6', '8', '8', '1',
            '1');
        for (int left = 0, right = num.length() - 1; left <= right; left++, right--) {
            char lchar = num.charAt(left);
            char rchar = num.charAt(right);
            if (!turnMap.containsKey(lchar) || !turnMap.containsKey(rchar) ||
                turnMap.get(lchar) != rchar) {
                return false;
            }
        }
        return true;
    }
}
