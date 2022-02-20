package leetcode.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaximumGap {

    //Implemented using radix sort
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] finalNums = radixSort(nums);
        return IntStream
            .range(1, nums.length)
            .map(i -> finalNums[i] - finalNums[i - 1])
            .max().orElse(0);
    }

    //Implemented using radix sort
    public int maximumGapUsingBuckets(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = maxElement(nums), min = minElement(nums);
        int bucketSize = Math.max((max - min) / nums.length - 1, 1);
        int numberOfBuckets = ((max - min) / bucketSize) + 1;

        Bucket[] buckets = new Bucket[numberOfBuckets];
        for (int num : nums) {
            int bucketIndex = (num - min) / bucketSize;
            if (buckets[bucketIndex] == null) {
                buckets[bucketIndex] = new Bucket(num, num);
            } else {
                int newMax = Math.max(buckets[bucketIndex].max, num);
                int newMin = Math.min(buckets[bucketIndex].min, num);
                buckets[bucketIndex] = new Bucket(newMax, newMin);
            }
        }

        int previousBucketMax = min, maxGap = 0;
        for (Bucket bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            maxGap = Math.max(maxGap, bucket.min - previousBucketMax);
            previousBucketMax = bucket.max;
        }
        return maxGap;

    }

    private class Bucket {

        int max;
        int min;

        Bucket(int max, int min) {
            this.max = max;
            this.min = min;
        }

    }

    private int[] radixSort(int[] nums) {
        int digitIndex = 1, max = maxElement(nums);
        while (max / digitIndex > 0) {
            int[] counts = new int[10];
            for (int i : nums) {
                int num = (i / digitIndex) % 10;
                counts[num]++;
            }
            for (int j = 1; j < 10; j++) {
                counts[j] += counts[j - 1];
            }
            int[] temp = new int[nums.length];
            for (int j = nums.length - 1; j >= 0; j--) {
                int num = (nums[j] / digitIndex) % 10;
                temp[--counts[num]] = nums[j];
            }
            nums = temp;
            digitIndex *= 10;
        }
        return nums;
    }

    private int maxElement(int[] nums) {
        return Arrays.stream(nums).max().orElse(0);
    }

    private int minElement(int[] nums) {
        return Arrays.stream(nums).min().orElse(0);
    }
}
