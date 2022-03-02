package leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/moving-average-from-data-stream/
// Time O(1) , Space O(W) where W is the windowSize
public class MovingAverage {

    int size;
    Queue<Integer> window;
    double sum;

    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0.0;
        window = new LinkedList<>();
    }

    public double next(int val) {
        window.offer(val);
        int prevValue = window.size() <= size ? 0 : window.poll();
        sum = sum - prevValue + val;
        return sum / window.size();
    }
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
