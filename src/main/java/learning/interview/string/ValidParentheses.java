package learning.interview.string;

import ds.Tuple;

import java.util.Stack;

/**
 * Created by Chethan on 10/15/15.
 */
class ValidParentheses {
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
}
