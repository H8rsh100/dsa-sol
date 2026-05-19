// LeetCode #435 - Non-overlapping Intervals
// Difficulty: Medium
// Link: https://leetcode.com/problems/non-overlapping-intervals/

// Problem:
// Given an array of intervals, return the minimum number of intervals
// you need to remove to make the rest non-overlapping.

// Approach: Greedy - Sort by end time
// Sort by end time (not start — this is the key insight).
// Keep track of the end of last kept interval.
// If current interval starts before last end — it overlaps, remove it.
// Otherwise keep it and update last end.
// Time: O(n log n) | Space: O(1)

import java.util.Arrays;

class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int removed = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                // Overlapping — remove current interval
                removed++;
            } else {
                // No overlap — keep it, update lastEnd
                lastEnd = intervals[i][1];
            }
        }

        return removed;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals sol = new NonOverlappingIntervals();

        System.out.println(sol.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
        // Expected: 1 (remove [1,3])

        System.out.println(sol.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));
        // Expected: 2 (remove two of the three)

        System.out.println(sol.eraseOverlapIntervals(new int[][]{{1,2},{2,3}}));
        // Expected: 0 (no overlap)
    }
}