package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import leetcode.Intervals.Interval;
import org.testng.annotations.Test;

public class IntervalsTest {

    @Test
    public void testMinMeetingRooms() {
        Intervals intervals = new Intervals();
        assertThat(intervals.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}))
            .isEqualTo(2);
        assertThat(intervals.minMeetingRooms(new int[][]{}))
            .isEqualTo(0);
    }

    @Test
    public void testCanAttendAllMeetings() {
        Intervals intervals = new Intervals();
        assertThat(intervals.canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}))
            .isFalse();
        assertThat(intervals.canAttendMeetings(new int[][]{{23, 30}, {5, 10}, {15, 20}}))
            .isTrue();
    }

    @Test
    public void testMergeIntervals() {
        Intervals intervals = new Intervals();
        assertThat(intervals.mergeIntervals(new int[][]{{0, 30}, {5, 10}, {15, 20}}))
            .containsExactly(new int[]{0, 30});
    }

    @Test
    public void testInsertInterval() {
        Intervals intervals = new Intervals();
        assertThat(intervals.insert(new int[][]{{0, 30}, {5, 10}, {15, 20}}, new int[]{10, 35}))
            .containsExactly(new int[]{0, 35});
    }

    @Test
    public void testIntervalIntersection() {
        Intervals intervals = new Intervals();
        assertThat(intervals.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}))
            .isEqualTo(new int[][]{{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}});
    }

    @Test
    public void testEmployeeFreeTime() {
        Intervals intervals = new Intervals();
        assertThat(intervals.employeeFreeTime(Arrays.asList(Arrays.asList(new Interval(1, 2), new Interval(5, 6))
            , Arrays.asList(new Interval(1, 3), new Interval(4, 10))))).containsExactly(new Interval(3, 4));
        assertThat(intervals.employeeFreeTimeFirstApproach(Arrays.asList(Arrays.asList(new Interval(1, 2), new Interval(5, 6))
            , Arrays.asList(new Interval(1, 3), new Interval(4, 10))))).containsExactly(new Interval(3, 4));

    }

    @Test
    public void testFindMinArrowShots() {
        Intervals intervals = new Intervals();
        assertThat(intervals.findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}))
            .isEqualTo(2);

    }
}