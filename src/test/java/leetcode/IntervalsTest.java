package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

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
}