// LeetCode #207 - Course Schedule
// Difficulty: Medium
// Link: https://leetcode.com/problems/course-schedule/

// Problem:
// There are n courses labeled 0 to n-1.
// prerequisites[i] = [a, b] means you must take b before a.
// Return true if you can finish all courses (no cycle exists).

// Approach: DFS Cycle Detection
// Build adjacency list. Run DFS from each unvisited node.
// Track nodes in current DFS path using a "visiting" state.
// If we revisit a node currently in path — cycle found, return false.
// States: 0 = unvisited, 1 = visiting, 2 = visited (safe)
// Time: O(n + e) | Space: O(n + e)

import java.util.*;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        int[] state = new int[numCourses]; // 0=unvisited, 1=visiting, 2=done

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(graph, state, i)) return false;
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] state, int node) {
        state[node] = 1; // mark as visiting

        for (int neighbor : graph.get(node)) {
            if (state[neighbor] == 1) return true;  // cycle found
            if (state[neighbor] == 0 && hasCycle(graph, state, neighbor)) return true;
        }

        state[node] = 2; // mark as fully visited
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule sol = new CourseSchedule();

        System.out.println(sol.canFinish(2, new int[][]{{1,0}}));
        // Expected: true (take 0 then 1)

        System.out.println(sol.canFinish(2, new int[][]{{1,0},{0,1}}));
        // Expected: false (cycle: 0 needs 1, 1 needs 0)
    }
}