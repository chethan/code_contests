package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Intervals {

    //https://leetcode.com/problems/meeting-rooms-ii/
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> occupiedRooms = new PriorityQueue<>(intervals.length);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        occupiedRooms.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= occupiedRooms.peek()) {
                occupiedRooms.poll();
            }
            occupiedRooms.add(intervals[i][1]);
        }
        return occupiedRooms.size();
    }

    //https://leetcode.com/problems/meeting-rooms/
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    //https://leetcode.com/problems/insert-interval/
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length + 1][2];
        int index = 0;
        for (; index < intervals.length && intervals[index][0] <= newInterval[0]; index++) {
            newIntervals[index] = intervals[index];
        }
        newIntervals[index] = newInterval;
        for (; index < intervals.length; index++) {
            newIntervals[index + 1] = intervals[index];
        }
        return mergeSortedIntervals(newIntervals);
    }

    //https://leetcode.com/problems/merge-intervals/
    public int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        return mergeSortedIntervals(intervals);
    }

    private int[][] mergeSortedIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        List<int[]> finalSlots = new ArrayList<>();
        finalSlots.add(intervals[0]);
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= finalSlots.get(index)[1]) {
                finalSlots.get(index)[1] = Math.max(finalSlots.get(index)[1], intervals[i][1]);
            } else {
                finalSlots.add(intervals[i]);
                index++;
            }
        }
        return finalSlots.toArray(new int[][]{});
    }

    //https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt((int[] a) -> a[0]));
        int countOfArrows = 1;
        int end = points[0][1];
        for (int[] point : points) {
            if (point[0] <= end) {
                end = Math.min(end, point[1]);
            } else {
                countOfArrows++;
                end = point[1];
            }
        }
        return countOfArrows;
    }

}
