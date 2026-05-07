// LeetCode #198 - House Robber
// Difficulty: Medium
// Link: https://leetcode.com/problems/house-robber/

// Problem:
// You are a robber. Each house has some money.
// You cannot rob two adjacent houses (triggers alarm).
// Return the maximum amount you can rob.

// Approach: DP Bottom-Up
// At each house, you decide: rob it or skip it.
// If you rob house i → money = nums[i] + best up to i-2
// If you skip house i → money = best up to i-1
// Take the max of both choices at every step.
// Time: O(n) | Space: O(1)

class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int prev2 = 0; // best up to i-2
        int prev1 = 0; // best up to i-1

        for (int num : nums) {
            int current = Math.max(prev1, num + prev2); // rob or skip
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber sol = new HouseRobber();

        System.out.println(sol.rob(new int[]{1, 2, 3, 1}));
        // Expected: 4 (rob house 1 and 3: 1+3)

        System.out.println(sol.rob(new int[]{2, 7, 9, 3, 1}));
        // Expected: 12 (rob house 1, 3, 5: 2+9+1)
    }
}