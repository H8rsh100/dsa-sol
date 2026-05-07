// LeetCode #322 - Coin Change
// Difficulty: Medium
// Link: https://leetcode.com/problems/coin-change/

// Problem:
// Given coins of different denominations and a total amount,
// return the fewest coins needed to make up that amount.
// If it cannot be made up, return -1.

// Approach: DP Bottom-Up
// Build a dp array where dp[i] = min coins needed to make amount i.
// For each amount, try every coin — if coin fits, check if using it
// gives fewer coins than current best.
// Initialize dp with amount+1 (impossible value), dp[0] = 0.
// Time: O(amount * coins) | Space: O(amount)

import java.util.Arrays;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // fill with "impossible" value
        dp[0] = 0; // 0 coins needed to make amount 0

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    // Use this coin and check if it gives better result
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange sol = new CoinChange();

        System.out.println(sol.coinChange(new int[]{1, 5, 10, 25}, 36));
        // Expected: 3 (25 + 10 + 1)

        System.out.println(sol.coinChange(new int[]{2}, 3));
        // Expected: -1 (impossible)

        System.out.println(sol.coinChange(new int[]{1, 2, 5}, 11));
        // Expected: 3 (5 + 5 + 1)
    }
}