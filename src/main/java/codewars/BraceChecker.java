package codewars;

import java.util.Stack;

/**
 * Created by Chethan on 9/10/16.
 */
public class BraceChecker {
    public static boolean isValid(String braces) {
        char[] chars = braces.toCharArray();
        Stack<Character> charStack = new Stack<>();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') charStack.push(aChar);
            else if (isMatching(charStack, aChar, ')', '(')) charStack.pop();
            else if (isMatching(charStack, aChar, ']', '[')) charStack.pop();
            else if (isMatching(charStack, aChar, '}', '{')) charStack.pop();
            else return false;
        }
        return charStack.isEmpty();
    }

    private static boolean isMatching(Stack<Character> charStack, char aChar, final char closing, final char opening) {
        return aChar == closing && !charStack.isEmpty() && charStack.peek() == opening;
    }
}
