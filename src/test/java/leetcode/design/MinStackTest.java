package leetcode.design;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class MinStackTest {

    @Test
    public void testMinStackOperations() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertThat(minStack.getMin()).isEqualTo(-3);
        minStack.pop();
        assertThat(minStack.top()).isEqualTo(0);
        assertThat(minStack.getMin()).isEqualTo(-2);
    }
}