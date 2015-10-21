package leetcode;

import ds.Tuple;

import java.util.Stack;

/**
 * Created by Chethan on 10/15/15.
 */
public class ValidParanthesis {
    //https://leetcode.com/problems/valid-parentheses/
    public boolean isValid(String s) {
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
    public int longestValidParentheses(String s) {
        Stack<Tuple<Integer>> tuples = new Stack<>();
        int longest = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                tuples.push(new Tuple<>(i, 1));
            } else {
                if (tuples.isEmpty() || tuples.peek().right == 0) {
                    tuples.push(new Tuple<>(i, 0));
                } else {
                    tuples.pop();
                    int longestLocal = tuples.isEmpty() ? i + 1 : (i - tuples.peek().left);
                    longest = Math.max(longestLocal, longest);
                }
            }
        }
        return longest;
    }
}
