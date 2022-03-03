package leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;

public class Parenthesis {

    //Time: O(N)
    //Space: O(1)
    public int minAddToMakeValid(String s) {
        int unbalancedOpenCount = 0, unbalancedCloseCount = 0;
        for (int i = 0; i < s.length(); i++) {
            unbalancedOpenCount += (s.charAt(i) == '(' ? 1 : -1);
            if (unbalancedOpenCount == -1) {
                unbalancedCloseCount++;
                unbalancedOpenCount++;
            }
        }
        return unbalancedOpenCount + unbalancedCloseCount;
    }

    //Time: O(N)
    //Space: O(N)
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> unbalancedOpenStack = new Stack<>();
        Set<Integer> indices = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                unbalancedOpenStack.push(i);
            }
            if (ch == ')') {
                if (unbalancedOpenStack.isEmpty()) {
                    indices.add(i);
                } else {
                    unbalancedOpenStack.pop();
                }
            }
        }
        indices.addAll(unbalancedOpenStack);
        for (int i = 0; i < s.length(); i++) {
            if (!indices.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    //Time: O(N)
    //Space: O(N) -> For string builder
    public String minRemoveToMakeValidWithoutStack(String s) {
        StringBuilder result = removeParenthesis(s, '(', ')', IntStream.range(0, s.length()));
        result = removeParenthesis(result.toString(), ')', '(',
            IntStream.iterate(result.length() - 1, i -> i >= 0, i -> i - 1));
        return result.reverse().toString();
    }

    StringBuilder removeParenthesis(String s, char toRemove, char toMatch, IntStream range) {
        final int[] balance = {0};
        StringBuilder builder = new StringBuilder();
        range.forEach(i -> {
                char ch = s.charAt(i);
                if (ch == toRemove) {
                    balance[0]++;
                }
                if (ch == toMatch) {
                    balance[0]--;
                }
                if (balance[0] == -1) {
                    balance[0] = 0;
                } else {
                    builder.append(ch);
                }
            }
        );
        return builder;
    }

    //https://leetcode.com/problems/valid-parentheses/
    boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character c1 = stack.peek();
                if ((c == ')' && c1 == '(') ||
                    (c == '}' && c1 == '{') || (c == ']' && c1 == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //https://leetcode.com/problems/longest-valid-parentheses/
    int longestValidParentheses(String s) {
        //stack will finally have all the indices for invalid values
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
        int to = chars.length, from, longest = 0;
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

    //https://leetcode.com/problems/generate-parentheses/
    List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisRecur(result, "", 0, 0, n);
        return result;
    }

    private boolean checkValidStringRecur(String s, int index, int count) {
        if (count < 0) {
            return false;
        }
        if (index >= s.length()) {
            return count == 0;
        }
        if (s.charAt(index) == '(') {
            return checkValidStringRecur(s, index + 1, count + 1);
        }
        if (s.charAt(index) == ')') {
            return checkValidStringRecur(s, index + 1, count - 1);
        }
        return checkValidStringRecur(s, index + 1, count - 1) || checkValidStringRecur(s, index + 1,
            count + 1) || checkValidStringRecur(s, index + 1, count);
    }

    private void generateParenthesisRecur(List<String> result, String str, int open, int close,
        int total) {
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
