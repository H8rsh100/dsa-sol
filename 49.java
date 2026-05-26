// LeetCode #5 - Longest Palindromic Substring
// Difficulty: Medium
// Link: https://leetcode.com/problems/longest-palindromic-substring/

// Problem:
// Given a string s, return the longest palindromic substring.

// Approach: Expand Around Center
// Every palindrome has a center (single char or between two chars).
// For each position, expand outward as long as chars match.
// Track the longest palindrome found.
// Two cases: odd length (single center) and even length (double center).
// Time: O(n²) | Space: O(1)

class LongestPalindromicSubstring {
    private int start = 0;
    private int maxLen = 1;

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);     // odd length
            expandAroundCenter(s, i, i + 1); // even length
        }

        return s.substring(start, start + maxLen);
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            int len = right - left + 1;
            if (len > maxLen) {
                maxLen = len;
                start = left;
            }
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();

        System.out.println(sol.longestPalindrome("babad"));
        // Expected: "bab" or "aba"

        System.out.println(sol.longestPalindrome("cbbd"));
        // Expected: "bb"

        System.out.println(sol.longestPalindrome("racecar"));
        // Expected: "racecar"
    }
}