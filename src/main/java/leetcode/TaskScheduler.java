package leetcode;

import java.util.Arrays;

public class TaskScheduler {

    //https://leetcode.com/problems/task-scheduler/
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int[] frequency = new int[26];
        for (char task : tasks) {
            frequency[task - 'A']++;
        }
        Arrays.sort(frequency);
        int maxFrequency = frequency[25];
        int idleTime = (maxFrequency - 1) * n;
        for (int i = 24; i >= 0; i--) {
            idleTime -= Math.min(maxFrequency - 1, frequency[i]);
        }
        return tasks.length + Math.max(idleTime, 0);
    }
}
