// LeetCode #10 - Regular Expression Matching
// Difficulty: Hard
// Link: https://leetcode.com/problems/regular-expression-matching/

// Problem:
// Given string s and pattern p, implement regex matching with:
// '.' matches any single character
// '*' matches zero or more of the preceding element
// The matching must cover the entire string.

// Approach: 2D DP
// dp[i][j] = true if s[0..i-1] matches p[0..j-1]
// Cases:
//   chars match (or p[j]=='.'): dp[i][j] = dp[i-1][j-1]
//   p[j] == '*':
//     zero occurrences: dp[i][j] = dp[i][j-2]
//     one+ occurrences: dp[i][j] = dp[i-1][j] if s[i] matches p[j-1]
// Time: O(m * n) | Space: O(m * n)

class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true; // empty string matches empty pattern

        // Handle patterns like a*, a*b*, a*b*c* matching empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    // Direct match
                    dp[i][j] = dp[i-1][j-1];
                } else if (pc == '*') {
                    char prev = p.charAt(j - 2);
                    // Zero occurrences of preceding element
                    dp[i][j] = dp[i][j-2];
                    // One or more occurrences — prev must match current char
                    if (prev == '.' || prev == sc) {
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching sol = new RegularExpressionMatching();

        System.out.println(sol.isMatch("aa", "a"));
        // Expected: false

        System.out.println(sol.isMatch("aa", "a*"));
        // Expected: true (a* = two a's)

        System.out.println(sol.isMatch("ab", ".*"));
        // Expected: true (.* matches any sequence)

        System.out.println(sol.isMatch("aab", "c*a*b"));
        // Expected: true (c*=0 c's, a*=2 a's, b=b)
    }
}