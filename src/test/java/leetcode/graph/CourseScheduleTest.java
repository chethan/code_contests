package leetcode.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class CourseScheduleTest {

    @Test
    public void testCanFinishAllTheCourses() {
        CourseSchedule courseSchedule = new CourseSchedule();
        assertThat(courseSchedule.canFinish(2, new int[][]{{1, 0}, {0, 1}})).isFalse();
        assertThat(courseSchedule.canFinish(2, new int[][]{{1, 0}})).isTrue();
        assertThat(courseSchedule.canFinish(1, new int[][]{})).isTrue();

    }

    @Test
    public void testFindOrderOfAllTheCourses() {
        CourseSchedule courseSchedule = new CourseSchedule();
        assertThat(courseSchedule.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}))
            .containsExactly(0, 2, 1, 3);
        assertThat(courseSchedule.findOrder(2, new int[][]{{1, 0}, {0, 1}})).hasSize(0);
        assertThat(courseSchedule.findOrder(2, new int[][]{{1, 0}})).containsExactly(0, 1);
        assertThat(courseSchedule.findOrder(1, new int[][]{})).containsExactly(0);
    }
}