package learning.interview.string;

import ds.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Chethan on 10/15/15.
 */
class Parentheses {
    //https://leetcode.com/problems/valid-parentheses/
    boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                Character c1 = stack.peek();
                if ((c == ')' && c1 == '(') ||
                        (c == '}' && c1 == '{') || (c == ']' && c1 == '[')) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }

    //https://leetcode.com/problems/longest-valid-parentheses/
    int longestValidParentheses(String s) {
        //stack will finally have all the indicies for invalid values
        Stack<Integer> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && chars[stack.peek()] == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        int to = chars.length, from = 0, longest = 0;
        while (!stack.empty()) {
            from = stack.pop();
            longest = Math.max(longest, to - from - 1);
            to = from;
        }
        return Math.max(longest, to);
    }

    //https://leetcode.com/problems/valid-parenthesis-string/
    boolean checkValidString(String s) {
        return checkValidStringRecur(s, 0, 0);
    }

    private boolean checkValidStringRecur(String s, int index, int count) {
        if (count < 0) return false;
        if (index >= s.length()) return count == 0;
        if (s.charAt(index) == '(') return checkValidStringRecur(s, index + 1, count + 1);
        if (s.charAt(index) == ')') return checkValidStringRecur(s, index + 1, count - 1);
        return checkValidStringRecur(s, index + 1, count - 1) || checkValidStringRecur(s, index + 1, count + 1) || checkValidStringRecur(s, index + 1, count);
    }


    //https://leetcode.com/problems/generate-parentheses/
    List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisRecur(result, "", 0, 0, n);
        return result;
    }

    private void generateParenthesisRecur(List<String> result, String str, int open, int close, int total) {
        if (str.length() == total * 2) {
            result.add(str);
            return;
        }

        if (open < total) {
            generateParenthesisRecur(result, str + "(", open + 1, close, total);
        }
        if (close < open) {
            generateParenthesisRecur(result, str + ")", open, close + 1, total);
        }

    }
}
