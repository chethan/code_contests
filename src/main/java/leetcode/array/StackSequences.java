package leetcode.array;

import java.util.Stack;

//https://leetcode.com/problems/validate-stack-sequences/
public class StackSequences {

    //Time: O(M+N)
    //Space: O(M)
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0, popIndex = 0;
        while (popIndex < popped.length) {
            if (stack.isEmpty() || stack.peek() != popped[popIndex]) {
                if (pushIndex < pushed.length) {
                    stack.push(pushed[pushIndex++]);
                } else {
                    return false;
                }
            } else {
                stack.pop();
                popIndex++;
            }
        }
        return true;
    }
}
