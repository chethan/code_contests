package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class TaskSchedulerTest {

    @Test
    public void testLeastInterval() {
        TaskScheduler taskScheduler = new TaskScheduler();
        assertThat(taskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2))
            .isEqualTo(8);
        assertThat(taskScheduler
            .leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'},
                2)).isEqualTo(16);
    }
}