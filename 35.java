// LeetCode #62 - Unique Paths
// Difficulty: Medium
// Link: https://leetcode.com/problems/unique-paths/

// Problem:
// A robot is on an m x n grid at top-left corner.
// It can only move right or down.
// How many unique paths are there to reach bottom-right corner?

// Approach: DP Bottom-Up
// dp[i][j] = number of ways to reach cell (i,j).
// First row and first column = 1 (only one way to reach them).
// Every other cell = dp[i-1][j] + dp[i][j-1] (from top + from left).
// Time: O(m * n) | Space: O(m * n)

class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // First row — only one way to reach each cell (go right)
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // First column — only one way to reach each cell (go down)
        for (int i = 0; i < m; i++) dp[i][0] = 1;

        // Fill rest of grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; // from top + from left
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths sol = new UniquePaths();

        System.out.println(sol.uniquePaths(3, 7));
        // Expected: 28

        System.out.println(sol.uniquePaths(3, 2));
        // Expected: 3

        System.out.println(sol.uniquePaths(1, 1));
        // Expected: 1
    }
}