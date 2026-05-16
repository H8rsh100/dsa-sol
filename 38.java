// LeetCode 139 - Word Break
// Difficulty: Medium
// Link: https://leetcode.com/problems/word-break/

// Problem:
// Given a string s and a dictionary of strings wordDict,
// return true if s can be segmented into space-separated
// sequence of dictionary words.

// Approach: DP Bottom-Up
// dp[i] = true if s[0..i] can be segmented using wordDict.
// For each position i, check all substrings ending at i.
// If dp[j] is true and s[j..i] is in dictionary — dp[i] = true.
// Time: O(n² * m) where m = avg word length | Space: O(n)

import java.util.*;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict); // O(1) lookup
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // empty string is always valid

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check further
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        WordBreak sol = new WordBreak();

        System.out.println(sol.wordBreak("leetcode", Arrays.asList("leet", "code")));
        // Expected: true

        System.out.println(sol.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        // Expected: true

        System.out.println(sol.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        // Expected: false
    }
}