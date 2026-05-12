// LeetCode #46 - Permutations
// Difficulty: Medium
// Link: https://leetcode.com/problems/permutations/

// Problem:
// Given an array of distinct integers, return all possible permutations.

// Approach: Backtracking
// Same choose → explore → unchoose pattern as Subsets.
// Difference: we use all elements each time, just in different orders.
// Track which elements are used with a boolean array.
// When current permutation size == nums length, we have a complete permutation.
// Time: O(n * n!) | Space: O(n)

import java.util.*;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        // Complete permutation found
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // skip already used elements

            used[i] = true;
            current.add(nums[i]);                        // choose
            backtrack(nums, used, current, result);      // explore
            current.remove(current.size() - 1);          // unchoose
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations sol = new Permutations();

        System.out.println(sol.permute(new int[]{1, 2, 3}));
        // Expected: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        System.out.println(sol.permute(new int[]{0, 1}));
        // Expected: [[0,1],[1,0]]
    }
}