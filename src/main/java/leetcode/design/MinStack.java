package leetcode.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/min-stack/
//https://leetcode.com/problems/max-stack/
public class MinStack {

    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
        } else {
            int currentMin = stack.peek()[1];
            stack.push(new int[]{x, Math.min(x, currentMin)});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public int popMin() {
        List<Integer> items = new ArrayList<>();
        int currentMin = stack.peek()[1];
        while (top() != currentMin) {
            items.add(top());
            pop();
        }
        pop();
        for (int i = items.size() - 1; i >= 0; i--) {
            push(items.get(i));
        }
        return currentMin;
    }
}

