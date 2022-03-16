package leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/strobogrammatic-number/
public class StrobogrammaticNumber {

    Map<Character, Character> turnMap = Map.of('0', '0', '6', '9', '9', '6', '8', '8', '1',
        '1');

    public boolean isStrobogrammatic(String num) {
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

    //https://leetcode.com/problems/strobogrammatic-number-ii/
    List<String> findStrobogrammatic(int n) {
        return helper(1, n);
    }

    List<String> helper(int lo, int hi) {
        List<String> result = new ArrayList<>();
        if (lo > hi) {
            return List.of("");
        }
        if (lo == hi) {
            for (char key : turnMap.keySet()) {
                if (turnMap.get(key) == key) {
                    result.add(key + "");
                }
            }
            return result;
        }
        List<String> prev = helper(lo + 1, hi - 1);
        for (char key : turnMap.keySet()) {
            char value = turnMap.get(key);
            if (value == '0' && lo == 1) {
                continue;
            }
            for (String old : prev) {
                result.add(key + old + value);
            }
        }
        return result;
    }
}
