// LeetCode #45 - Jump Game II
// Difficulty: Medium
// Link: https://leetcode.com/problems/jump-game-ii/

// Problem:
// Given an array where nums[i] is max jump length at position i,
// return the minimum number of jumps to reach the last index.
// You are guaranteed you can always reach the last index.

// Approach: Greedy
// Track current jump boundary and furthest reachable position.
// When we reach the boundary of current jump, we MUST jump.
// Each time we jump, update boundary to furthest reachable so far.
// Time: O(n) | Space: O(1)

class JumpGameII {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;  // boundary of current jump
        int farthest = 0;    // furthest we can reach

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                // Must jump here — reached boundary
                jumps++;
                currentEnd = farthest;

                if (currentEnd >= nums.length - 1) break;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII sol = new JumpGameII();

        System.out.println(sol.jump(new int[]{2, 3, 1, 1, 4}));
        // Expected: 2 (jump to index 1, then to last)

        System.out.println(sol.jump(new int[]{2, 3, 0, 1, 4}));
        // Expected: 2

        System.out.println(sol.jump(new int[]{1, 2, 3}));
        // Expected: 2
    }
}