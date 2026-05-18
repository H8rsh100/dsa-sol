// LeetCode #56 - Merge Intervals
// Difficulty: Medium
// Link: https://leetcode.com/problems/merge-intervals/

// Problem:
// Given an array of intervals, merge all overlapping intervals
// and return the resulting array.

// Approach: Sort + Greedy
// Sort intervals by start time.
// Walk through — if current interval overlaps with last merged,
// extend the last merged interval's end.
// Otherwise add current as a new interval.
// Two intervals overlap if current.start <= last.end
// Time: O(n log n) | Space: O(n)

import java.util.*;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.get(merged.size() - 1);
            int[] current = intervals[i];

            if (current[0] <= last[1]) {
                // Overlapping — extend end if needed
                last[1] = Math.max(last[1], current[1]);
            } else {
                // No overlap — add as new interval
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals sol = new MergeIntervals();

        int[][] result1 = sol.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        for (int[] interval : result1) {
            System.out.println(Arrays.toString(interval));
        }
        // Expected: [1,6] [8,10] [15,18]

        int[][] result2 = sol.merge(new int[][]{{1,4},{4,5}});
        for (int[] interval : result2) {
            System.out.println(Arrays.toString(interval));
        }
        // Expected: [1,5]
    }
}