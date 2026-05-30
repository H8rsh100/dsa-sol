// LeetCode #312 - Burst Balloons
// Difficulty: Hard
// Link: https://leetcode.com/problems/burst-balloons/

// Problem:
// Given n balloons with values in nums array.
// If you burst balloon i you get nums[i-1] * nums[i] * nums[i+1] coins.
// Return maximum coins you can collect by bursting all balloons.

// Approach: Interval DP (think in reverse)
// Instead of thinking which balloon to burst first,
// think which balloon to burst LAST in each interval.
// dp[left][right] = max coins from bursting all balloons between left and right.
// Add virtual balloons of value 1 at both ends.
// For each interval, try every balloon as the last to burst.
// Time: O(n³) | Space: O(n²)

class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Add virtual balloons of value 1 at both ends
        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;
        for (int i = 0; i < n; i++) balloons[i + 1] = nums[i];

        int size = n + 2;
        int[][] dp = new int[size][size];

        // length = window size, starting from 2
        for (int length = 2; length < size; length++) {
            for (int left = 0; left < size - length; left++) {
                int right = left + length;

                // Try every balloon k as the last to burst in [left, right]
                for (int k = left + 1; k < right; k++) {
                    int coins = balloons[left] * balloons[k] * balloons[right];
                    dp[left][right] = Math.max(
                        dp[left][right],
                        dp[left][k] + coins + dp[k][right]
                    );
                }
            }
        }

        return dp[0][size - 1];
    }

    public static void main(String[] args) {
        BurstBalloons sol = new BurstBalloons();

        System.out.println(sol.maxCoins(new int[]{3, 1, 5, 8}));
        // Expected: 167
        // [3,1,5,8] → burst 1 → [3,5,8] coins 3*1*5=15
        // → burst 5 → [3,8] coins 3*5*8=120
        // → burst 3 → [8] coins 1*3*8=24
        // → burst 8 → coins 1*8*1=8
        // Total: 15+120+24+8 = 167

        System.out.println(sol.maxCoins(new int[]{1, 5}));
        // Expected: 10
    }
}