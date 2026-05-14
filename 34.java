// LeetCode #300 - Longest Increasing Subsequence
// Difficulty: Medium
// Link: https://leetcode.com/problems/longest-increasing-subsequence/

// Problem:
// Given an integer array, return the length of the longest
// strictly increasing subsequence.
// Subsequence = elements in order but not necessarily contiguous.

// Approach: DP Bottom-Up
// dp[i] = length of LIS ending at index i.
// For each i, look at all j < i — if nums[j] < nums[i],
// we can extend that subsequence. Take the max.
// Time: O(n²) | Space: O(n)

import java.util.Arrays;
class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // every element is an LIS of length 1 by itself

        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // Extend LIS ending at j with nums[i]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();

        System.out.println(sol.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        // Expected: 4 (2,3,7,101)

        System.out.println(sol.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        // Expected: 4 (0,1,2,3)

        System.out.println(sol.lengthOfLIS(new int[]{7, 7, 7, 7}));
        // Expected: 1 (strictly increasing — no two same)
    }
}