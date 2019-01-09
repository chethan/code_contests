package learning.interview.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class RomanNumbers {
    //https://leetcode.com/problems/roman-to-integer/
    int romanToInt(String s) {
        Map<Character, Integer> symbolMap = constructSymbolToNumberMap();
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            Integer current = symbolMap.get(s.charAt(i));
            Integer next = symbolMap.get(s.charAt(i + 1));
            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }
        return result + symbolMap.get(s.charAt(s.length() - 1));
    }

    //https://leetcode.com/problems/integer-to-roman
    String intToRoman(int num) {
        Map<Integer, String> map = constructNumberToSymbolMap();
        StringBuilder result = new StringBuilder();
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            if (num != 0) {
                int digit = num / key;
                if (digit != 0) {
                    for (int i = 0; i < digit; i++) {
                        result.append(map.get(key));
                    }
                    num = num % key;
                }
            }
        }
        return result.toString();
    }

    private Map<Character, Integer> constructSymbolToNumberMap() {
        Map<Character, Integer> symbolMap = new LinkedHashMap<>();
        symbolMap.put('I', 1);
        symbolMap.put('V', 5);
        symbolMap.put('X', 10);
        symbolMap.put('L', 50);
        symbolMap.put('C', 100);
        symbolMap.put('D', 500);
        symbolMap.put('M', 1000);
        return symbolMap;
    }

    private Map<Integer, String> constructNumberToSymbolMap() {
        Map<Integer, String> symbolMap = new LinkedHashMap<>();
        symbolMap.put(1000, "M");
        symbolMap.put(900, "CM");
        symbolMap.put(500, "D");
        symbolMap.put(400, "CD");
        symbolMap.put(100, "C");
        symbolMap.put(90, "XC");
        symbolMap.put(50, "L");
        symbolMap.put(40, "XL");
        symbolMap.put(10, "X");
        symbolMap.put(9, "IX");
        symbolMap.put(5, "V");
        symbolMap.put(4, "IV");
        symbolMap.put(1, "I");
        return symbolMap;
    }
}
