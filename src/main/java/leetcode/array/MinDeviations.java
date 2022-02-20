package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinDeviations {

    public int minimumDeviation(int[] nums) {
        //if its even you cant increase it further
        //if its odd you cant decrease it further
        // decrease the maximum element to as much as possible
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int minDeviation = Integer.MAX_VALUE;
        //increase all the numbers to the max
        int minElement = Arrays.stream(nums)
            .map(i -> i % 2 == 0 ? i : i * 2)
            .peek(maxHeap::offer)
            .min().orElse(Integer.MAX_VALUE);
        while (!maxHeap.isEmpty()) {
            int maxNumber = maxHeap.poll();
            minDeviation = Math.min(minDeviation, maxNumber - minElement);
            if (maxNumber % 2 == 0) {
                maxNumber = maxNumber / 2;
                maxHeap.offer(maxNumber);
                minElement = Math.min(minElement, maxNumber);
            } else {
                break;
            }
        }
        return minDeviation;
    }
}
