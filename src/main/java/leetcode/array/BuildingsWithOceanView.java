package leetcode.array;

import java.util.Stack;
import java.util.stream.IntStream;

public class BuildingsWithOceanView {

    //https://leetcode.com/problems/buildings-with-an-ocean-view/
    //Time O(N) , Space O(1) - Ignoring the stack used for result
    public int[] findBuildings(int[] heights) {
        int maxHeight = 0;
        Stack<Integer> resultList = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                resultList.push(i);
            }
            maxHeight = Math.max(maxHeight, heights[i]);
        }
        int[] result = new int[resultList.size()];
        IntStream.range(0, resultList.size())
            .forEach(i -> result[i] = resultList.pop());
        return result;

    }
}
