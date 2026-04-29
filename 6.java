// LeetCode #242 - Valid Anagram
// Difficulty: Easy
// Link: https://leetcode.com/problems/valid-anagram/

// Problem:
// Given two strings s and t, return true if t is an anagram of s.
// An anagram uses the same characters in the same frequency, different order.

// Approach: Frequency Counter Array
// Use an int array of size 26 (one slot per letter a-z).
// Increment for each char in s, decrement for each char in t.
// If all slots are 0 at the end — valid anagram.
// Time: O(n) | Space: O(1) — array size is always fixed at 26

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++; // increment for s
            freq[t.charAt(i) - 'a']--; // decrement for t
        }

        for (int count : freq) {
            if (count != 0) return false; // mismatch in frequency
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();

        System.out.println(sol.isAnagram("anagram", "nagaram"));
        // Expected: true

        System.out.println(sol.isAnagram("rat", "car"));
        // Expected: false

        System.out.println(sol.isAnagram("listen", "silent"));
        // Expected: true
    }
}