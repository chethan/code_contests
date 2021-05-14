package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class Intervals {

    static class Interval {

        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Interval interval = (Interval) o;
            return start == interval.start &&
                end == interval.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

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

    //https://leetcode.com/problems/interval-list-intersections/
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new ArrayList<>();
        for (int i = 0, j = 0; i < firstList.length && j < secondList.length; ) {
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);
            if (low <= high) {
                intersections.add(new int[]{low, high});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return intersections.toArray(new int[0][]);
    }

    //https://leetcode.com/problems/employee-free-time/
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> q = new PriorityQueue<>((a, b) -> a.start - b.start);
        schedule.forEach(q::addAll);

        int end = q.poll().end;
        while (!q.isEmpty()) {
            Interval interval = q.poll();
            int start = interval.start;
            if (start > end) {
                res.add(new Interval(end, start));
            }
            end = Math.max(interval.end, end);
        }
        return res;
    }

    //https://leetcode.com/problems/employee-free-time/
    public List<Interval> employeeFreeTimeFirstApproach(List<List<Interval>> schedule) {
        List<List<Interval>> freeTime = new ArrayList<>();
        for(List<Interval> employeeSchedule:schedule){
            List<Interval> employeeFreeTime = new ArrayList<>();
            int lastIntervalEnd = -1;
            for(Interval interval:employeeSchedule){
                employeeFreeTime.add(new Interval(lastIntervalEnd,interval.start));
                lastIntervalEnd=interval.end;
            }
            employeeFreeTime.add(new Interval(lastIntervalEnd,Integer.MAX_VALUE));
            freeTime.add(employeeFreeTime);
        }

        List<Interval> commonFreeTime = freeTime.get(0);
        for(int i=1;i<freeTime.size();i++){
            commonFreeTime = mergeIntervals(commonFreeTime,freeTime.get(i));
        }

        if(!commonFreeTime.isEmpty() && commonFreeTime.get(0).start==-1){
            commonFreeTime.remove(0);
        }


        if(!commonFreeTime.isEmpty() && commonFreeTime.get(commonFreeTime.size()-1).end==Integer.MAX_VALUE){
            commonFreeTime.remove(commonFreeTime.size()-1);
        }
        return commonFreeTime;

    }

    private List<Interval> mergeIntervals(List<Interval> interval1,List<Interval> interval2){
        List<Interval> mergedIntervals = new ArrayList<>();
        for(int i=0,j=0;i < interval1.size() && j < interval2.size() ; ){
            int low = Math.max(interval1.get(i).start,interval2.get(j).start);
            int high = Math.min(interval1.get(i).end,interval2.get(j).end);
            if(low<high){
                mergedIntervals.add(new Interval(low,high));
            }
            if(interval1.get(i).end < interval2.get(j).end){
                i++;
            }
            else{
                j++;
            }
        }
        return mergedIntervals;
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
