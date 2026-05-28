// LeetCode #1143 - Longest Common Subsequence
// Difficulty: Medium
// Link: https://leetcode.com/problems/longest-common-subsequence/

// Problem:
// Given two strings text1 and text2, return the length of their
// longest common subsequence.
// Subsequence = characters in order but not necessarily contiguous.
// If no common subsequence, return 0.

// Approach: 2D DP
// dp[i][j] = LCS of text1[0..i-1] and text2[0..j-1]
// If chars match: dp[i][j] = dp[i-1][j-1] + 1
// If chars don't match: dp[i][j] = max(dp[i-1][j], dp[i][j-1])
// Time: O(m * n) | Space: O(m * n)

class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Base cases are already 0 (default int array values)

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1; // chars match
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); // take best
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence sol = new LongestCommonSubsequence();

        System.out.println(sol.longestCommonSubsequence("abcde", "ace"));
        // Expected: 3 (ace)

        System.out.println(sol.longestCommonSubsequence("abc", "abc"));
        // Expected: 3

        System.out.println(sol.longestCommonSubsequence("abc", "def"));
        // Expected: 0
    }
}