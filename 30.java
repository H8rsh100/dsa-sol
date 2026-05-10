// LeetCode #78 - Subsets
// Difficulty: Medium
// Link: https://leetcode.com/problems/subsets/

// Problem:
// Given an integer array of unique elements,
// return all possible subsets (the power set).
// Solution must not contain duplicate subsets.

// Approach: Backtracking
// At each step we decide: include this element or not.
// We build subsets by exploring both choices recursively.
// The key pattern: add current subset to result, then
// for each remaining element — add it, recurse, remove it (backtrack).
// Time: O(2^n) | Space: O(n) call stack

import java.util.*;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Add current subset to result (including empty set)
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]); // choose
            backtrack(nums, i + 1, current, result); // explore
            current.remove(current.size() - 1); // unchoose (backtrack)
        }
    }

    public static void main(String[] args) {
        Subsets sol = new Subsets();

        System.out.println(sol.subsets(new int[] { 1, 2, 3 }));
        // Expected: [[], [1], [1,2], [1,2,3], [1,3], [2], [2,3], [3]]

        System.out.println(sol.subsets(new int[] { 0 }));
        // Expected: [[], [0]]
    }
}