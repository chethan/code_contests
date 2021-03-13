package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayIntersection {

    //https://leetcode.com/problems/intersection-of-two-arrays/
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> left = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> right = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return left.size() > right.size() ? findIntersection(right, left)
            : findIntersection(left, right);
    }

    public int[] intersectionOfSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        for (int left = 0, right = 0; left < nums1.length && right < nums2.length; ) {
            int leftValue = nums1[left];
            int rightValue = nums2[right];
            if (leftValue == rightValue) {
                result.add(leftValue);
                while (left < nums1.length && leftValue == nums1[left]) {
                    left++;
                }
                while (right < nums2.length && rightValue == nums2[right]) {
                    right++;
                }
            } else if (leftValue < rightValue) {
                left++;
            } else {
                right++;
            }
        }
        return result.stream().mapToInt(a -> a).toArray();
    }


    public int[] intersectionWithDuplicates(int[] nums1, int[] nums2) {
        return nums1.length > nums2.length ? findIntersectionWithDuplicates(nums2, nums1)
            : findIntersectionWithDuplicates(nums1, nums2);
    }

    private int[] findIntersection(Set<Integer> left, Set<Integer> right) {
        return left.stream().filter(right::contains).mapToInt(i -> i).toArray();
    }

    private int[] findIntersectionWithDuplicates(int[] left, int[] right) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Long> countMap = Arrays.stream(left).boxed()
            .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        for (int value : right) {
            long count = countMap.getOrDefault(value, 0L);
            if (count > 0) {
                result.add(value);
                countMap.put(value, count - 1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

}
