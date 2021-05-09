package leetcode.array;

import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/car-pooling/
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> totalCountMap = new TreeMap<>();
        for (int[] trip : trips) {
            totalCountMap
                .put(trip[1], totalCountMap.getOrDefault(trip[1], 0) + trip[0]);
            totalCountMap
                .put(trip[2], totalCountMap.getOrDefault(trip[2], 0) - trip[0]);
        }
        int usedCapacity = 0;
        for (int currentCount : totalCountMap.values()) {
            usedCapacity += currentCount;
            if (usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }

    //0 <= trips[i][1] < trips[i][2] <= 1000
    public boolean carPoolingWithBucketSort(int[][] trips, int capacity) {
        int[] totalCounts = new int[1001];
        for (int[] trip : trips) {
            totalCounts[trip[1]] += trip[0];
            totalCounts[trip[2]] -= trip[0];
        }
        int usedCapacity = 0;
        for (int currentCount : totalCounts) {
            usedCapacity += currentCount;
            if (usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}
