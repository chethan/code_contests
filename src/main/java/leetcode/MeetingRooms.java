package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

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
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        for(int i=0;i<intervals.length-1;i++){
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
}
