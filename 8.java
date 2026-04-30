// LeetCode #643 - Maximum Average Subarray I
// Difficulty: Easy
// Link: https://leetcode.com/problems/maximum-average-subarray-i/

// Problem:
// Given an integer array and integer k, find a contiguous subarray
// of length k that has the maximum average value and return that value.

// Approach: Sliding Window
// Calculate sum of first window of size k.
// Then slide the window — add the next element, remove the first.
// Track the maximum sum seen.
// Time: O(n) | Space: O(1)

class MaxAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double windowSum = 0;

        // Calculate sum of first window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        double maxSum = windowSum;

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i];       // add new element on right
            windowSum -= nums[i - k];   // remove element on left
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum / k;
    }

    public static void main(String[] args) {
        MaxAverageSubarrayI sol = new MaxAverageSubarrayI();

        System.out.println(sol.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        // Expected: 12.75 (subarray [12,-5,-6,50] / 4 = 12.75... wait)
        // Actually [−5,−6,50,3] = 42/4 = 10.5, [-6,50,3] no...
        // [1,12,-5,-6] = 2/4, [12,-5,-6,50] = 51/4 = 12.75 ✓

        System.out.println(sol.findMaxAverage(new int[]{5}, 1));
        // Expected: 5.0
    }
}