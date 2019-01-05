package learning.interview.string;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class PhoneNumber {
    private String[] mappingArray = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    List<String> letterCombinations(String digits) {
        List<String> letterCombinations = new ArrayList<>();

        if (digits == null || digits.equals("")) return letterCombinations;

        String mappingValue = mappingArray[digits.charAt(0) - '1'];
        String remainingDigits = digits.substring(1);
        for (int i = 0; i < mappingValue.length(); i++) {
            List<String> partialCombinations = letterCombinations(remainingDigits);
            for (String partialCombination : partialCombinations) {
                letterCombinations.add(mappingValue.charAt(i) + partialCombination);
            }
            if (partialCombinations.isEmpty()) {
                letterCombinations.add(mappingValue.charAt(i) + "");
            }

        }

        return letterCombinations;
    }

    List<String> letterCombinationsIterative(String digits) {
        LinkedList<String> letterCombinations = new LinkedList<>();
        if (digits == null || digits.equals("")) return letterCombinations;
        letterCombinations.add("");
        for (int i = 0; i < digits.length(); i++) {
            String mappingValue = mappingArray[digits.charAt(i) - '1'];
            while (letterCombinations.peek().length() == i) {
                String partialCombination = letterCombinations.remove();
                for (int j = 0; j < mappingValue.length(); j++) {
                    letterCombinations.add(partialCombination + mappingValue.charAt(j));
                }
            }
        }
        return letterCombinations;

    }

}
