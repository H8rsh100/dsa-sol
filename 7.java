// LeetCode #14 - Longest Common Prefix
// Difficulty: Easy
// Link: https://leetcode.com/problems/longest-common-prefix/

// Problem:
// Find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return "".

// Approach: Vertical Scanning
// Take the first string as reference. Check each character position
// across all strings. Stop when mismatch found or any string runs out.
// Time: O(n * m) where m = length of shortest string | Space: O(1)

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                // Stop if we've gone past a string's length or chars don't match
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        LongestCommonPrefix sol = new LongestCommonPrefix();

        System.out.println(sol.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        // Expected: "fl"

        System.out.println(sol.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        // Expected: ""
    }
}