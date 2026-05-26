// LeetCode #72 - Edit Distance
// Difficulty: Hard
// Link: https://leetcode.com/problems/edit-distance/

// Problem:
// Given two strings word1 and word2, return the minimum number
// of operations to convert word1 to word2.
// Operations: insert, delete, or replace a character.

// Approach: 2D DP
// dp[i][j] = min operations to convert word1[0..i] to word2[0..j]
// If chars match: dp[i][j] = dp[i-1][j-1] (no operation needed)
// If chars don't match, take min of:
//   dp[i-1][j] + 1   → delete from word1
//   dp[i][j-1] + 1   → insert into word1
//   dp[i-1][j-1] + 1 → replace in word1
// Base cases: converting to/from empty string = length of other string
// Time: O(m * n) | Space: O(m * n)

class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i; // delete all chars
        for (int j = 0; j <= n; j++) dp[0][j] = j; // insert all chars

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1]; // chars match, no op needed
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i-1][j-1],              // replace
                        Math.min(dp[i-1][j],       // delete
                                 dp[i][j-1])       // insert
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        EditDistance sol = new EditDistance();

        System.out.println(sol.minDistance("horse", "ros"));
        // Expected: 3
        // horse → rorse (replace h→r)
        // rorse → rose (delete r)
        // rose → ros (delete e)

        System.out.println(sol.minDistance("intention", "execution"));
        // Expected: 5

        System.out.println(sol.minDistance("", "abc"));
        // Expected: 3
    }
}