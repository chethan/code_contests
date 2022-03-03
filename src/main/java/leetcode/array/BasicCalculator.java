package leetcode.array;

import java.util.Stack;

public class BasicCalculator {

    //Time: O(N)
    //Space: O(N)
    //https://leetcode.com/problems/basic-calculator-ii/
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char previousOperator = '+';
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }
            if ((!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar))
                || i == s.length() - 1) {
                if (previousOperator == '-') {
                    stack.push(-currentNumber);
                } else if (previousOperator == '+') {
                    stack.push(currentNumber);
                } else if (previousOperator == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (previousOperator == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                previousOperator = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
