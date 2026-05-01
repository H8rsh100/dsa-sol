// LeetCode #209 - Minimum Size Subarray Sum
// Difficulty: Medium
// Link: https://leetcode.com/problems/minimum-size-subarray-sum/

// Problem:
// Given an array of positive integers and a target,
// return the minimal length of a subarray whose sum >= target.
// If no such subarray exists, return 0.

// Approach: Dynamic Sliding Window
// Unlike fixed-size sliding window, here the window grows and shrinks.
// Expand right pointer to grow sum, shrink left pointer when sum >= target.
// Track minimum window length throughout.
// Time: O(n) | Space: O(1)

class MinSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right]; // expand window

            while (sum >= target) {
                // Found valid window — record its length
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left]; // shrink from left
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        MinSizeSubarraySum sol = new MinSizeSubarraySum();

        System.out.println(sol.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        // Expected: 2 (subarray [4,3])

        System.out.println(sol.minSubArrayLen(4, new int[]{1, 4, 4}));
        // Expected: 1

        System.out.println(sol.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1}));
        // Expected: 0 (impossible)
    }
}