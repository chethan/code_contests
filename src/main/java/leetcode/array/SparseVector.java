package leetcode.array;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
public class SparseVector {

    Map<Integer, Integer> vectorMap;

    //Time: O(N)
    //Space: O(K) where k is the non-zero numbers in vector
    SparseVector(int[] nums) {
        vectorMap = IntStream.range(0, nums.length)
            .filter(i -> nums[i] != 0)
            .boxed()
            .collect(Collectors.toMap(i -> i, i -> nums[i]));
    }

    // Return the dotProduct of two sparse vectors
    //Time: O(K)
    //Space: O(K) where k is the non-zero numbers in vector
    public int dotProduct(SparseVector vec) {
        return vectorMap.keySet().stream()
            .mapToInt(k -> vectorMap.get(k) * vec.vectorMap.getOrDefault(k, 0))
            .sum();
    }
}
