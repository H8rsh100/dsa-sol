// LeetCode #55 - Jump Game
// Difficulty: Medium
// Link: https://leetcode.com/problems/jump-game/

// Problem:
// Given an array where nums[i] is your max jump length at position i,
// return true if you can reach the last index starting from index 0.

// Approach: Greedy
// Track the furthest index reachable at any point.
// For each position, if it's reachable (i <= maxReach),
// update maxReach with i + nums[i].
// If maxReach >= last index at any point — return true.
// Time: O(n) | Space: O(1)

class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // current position unreachable

            maxReach = Math.max(maxReach, i + nums[i]); // update furthest reach

            if (maxReach >= nums.length - 1) return true; // can reach end
        }

        return true;
    }

    public static void main(String[] args) {
        JumpGame sol = new JumpGame();

        System.out.println(sol.canJump(new int[]{2, 3, 1, 1, 4}));
        // Expected: true

        System.out.println(sol.canJump(new int[]{3, 2, 1, 0, 4}));
        // Expected: false (always land on index 3 which has 0 jump)

        System.out.println(sol.canJump(new int[]{0}));
        // Expected: true (already at last index)
    }
}