// LeetCode #210 - Course Schedule II
// Difficulty: Medium
// Link: https://leetcode.com/problems/course-schedule-ii/

// Problem:
// Given numCourses and prerequisites,
// return the ordering of courses to take to finish all courses.
// If impossible (cycle), return empty array.

// Approach: Topological Sort (Kahn's Algorithm - BFS)
// Build adjacency list and in-degree count for each course.
// Start with courses having 0 prerequisites (in-degree 0).
// Process them, reduce in-degree of dependent courses.
// If a course's in-degree hits 0 — add to queue.
// Time: O(V + E) | Space: O(V + E)

import java.util.*;

class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        int[] inDegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); // pre[1] -> pre[0]
            inDegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;

            for (int next : graph.get(course)) {
                inDegree[next]--;
                if (inDegree[next] == 0) queue.offer(next);
            }
        }

        // If we processed all courses — valid order. Else cycle exists.
        return index == numCourses ? order : new int[0];
    }

    public static void main(String[] args) {
        CourseScheduleII sol = new CourseScheduleII();

        System.out.println(Arrays.toString(
            sol.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})
        ));
        // Expected: [0,1,2,3] or [0,2,1,3]

        System.out.println(Arrays.toString(
            sol.findOrder(2, new int[][]{{1,0},{0,1}})
        ));
        // Expected: [] (cycle)
    }
}