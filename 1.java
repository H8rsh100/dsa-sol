// LeetCode #1 - Two Sum
// Difficulty: Easy
// Link: https://leetcode.com/problems/two-sum/

// Problem:
// Given an array of integers and a target, return indices of the two numbers
// that add up to the target. Each input has exactly one solution.

// Approach: HashMap
// Instead of brute force O(n²), we use a HashMap to store each number
// and its index as we iterate. For each number, we check if (target - num)
// already exists in the map. If yes, we found our pair.
// Time: O(n) | Space: O(n)

import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If complement exists in map, we found the answer
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store current number with its index
            map.put(nums[i], i);
        }

        return new int[] {}; // no solution found (won't happen per problem constraints)
    }

    // Quick test
    public static void main(String[] args) {
        TwoSum sol = new TwoSum();

        int[] result = sol.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Output: [" + result[0] + ", " + result[1] + "]");
        
    }
}