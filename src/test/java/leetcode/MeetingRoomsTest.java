package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class MeetingRoomsTest {

    @Test
    public void testMinMeetingRooms() {
        MeetingRooms meetingRooms = new MeetingRooms();
        assertThat(meetingRooms.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}))
            .isEqualTo(2);
        assertThat(meetingRooms.minMeetingRooms(new int[][]{}))
            .isEqualTo(0);
    }

    @Test
    public void testCanAttendAllMeetings() {
        MeetingRooms meetingRooms = new MeetingRooms();
        assertThat(meetingRooms.canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}))
            .isFalse();
        assertThat(meetingRooms.canAttendMeetings(new int[][]{{23, 30}, {5, 10}, {15, 20}}))
            .isTrue();
    }

    @Test
    public void testMergeIntervals() {
        MeetingRooms meetingRooms = new MeetingRooms();
        assertThat(meetingRooms.mergeIntervals(new int[][]{{0, 30}, {5, 10}, {15, 20}}))
            .containsExactly(new int[]{0, 30});

    }
}