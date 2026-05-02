// LeetCode #15 - 3Sum
// Difficulty: Medium
// Link: https://leetcode.com/problems/3sum/

// Problem:
// Given an integer array, return all triplets [nums[i], nums[j], nums[k]]
// such that i != j != k and nums[i] + nums[j] + nums[k] == 0.
// Solution must not contain duplicate triplets.

// Approach: Sort + Two Pointers
// Sort the array. Fix one element, then use two pointers on the rest.
// Skip duplicates at every level to avoid repeated triplets.
// Time: O(n²) | Space: O(1) ignoring output

import java.util.*;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // need bigger sum
                } else {
                    right--; // need smaller sum
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();

        System.out.println(sol.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        // Expected: [[-1,-1,2],[-1,0,1]]

        System.out.println(sol.threeSum(new int[]{0, 0, 0}));
        // Expected: [[0,0,0]]
    }
}