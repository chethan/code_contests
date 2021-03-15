package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    //https://leetcode.com/problems/course-schedule-ii/
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> sortedCourses = new ArrayList<>();
        for (int[] prerequisite : prerequisites) {
            graph.putIfAbsent(prerequisite[1], new ArrayList<>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] cache = new boolean[numCourses];
        for (int currentCourse = 0; currentCourse < numCourses; currentCourse++) {
            if (cyclic(currentCourse, graph, visited, cache, sortedCourses)) {
                return new int[]{};
            }
        }

        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = sortedCourses.get(numCourses - i - 1);
        }
        return order;
    }

    //https://leetcode.com/problems/course-schedule/
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return findOrder(numCourses, prerequisites).length != 0;
    }

    private boolean cyclic(int currentCourse, Map<Integer, List<Integer>> graph, boolean[] visited,
        boolean[] cache, List<Integer> sortedCourses) {
        if (visited[currentCourse]) {
            return true;
        }
        if (cache[currentCourse]) {
            return false;
        }

        visited[currentCourse] = true;
        for (int nextCourse : graph.getOrDefault(currentCourse, List.of())) {
            if (cyclic(nextCourse, graph, visited, cache, sortedCourses)) {
                return true;
            }
        }
        visited[currentCourse] = false;
        cache[currentCourse] = true;
        sortedCourses.add(currentCourse);
        return false;

    }
}
