// LeetCode #53 - Maximum Subarray
// Difficulty: Easy
// Link: https://leetcode.com/problems/maximum-subarray/

// Problem:
// Given an integer array, find the subarray with the largest sum and return its sum.

// Approach: Kadane's Algorithm
// At each element, decide: is it better to extend the previous subarray
// or start fresh from this element?
// Track the max sum seen at any point.
// Time: O(n) | Space: O(1)

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend current subarray or start new one here
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray sol = new MaximumSubarray();

        System.out.println(sol.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        // Expected: 6 (subarray [4,-1,2,1])

        System.out.println(sol.maxSubArray(new int[]{1}));
        // Expected: 1

        System.out.println(sol.maxSubArray(new int[]{5, 4, -1, 7, 8}));
        // Expected: 23
    }
}