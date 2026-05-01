// LeetCode #125 - Valid Palindrome
// Difficulty: Easy
// Link: https://leetcode.com/problems/valid-palindrome/

// Problem:
// A phrase is a palindrome if, after converting to lowercase and
// removing non-alphanumeric characters, it reads the same forwards and backwards.
// Return true if it is a palindrome.

// Approach: Two Pointers
// Place one pointer at start, one at end.
// Skip non-alphanumeric characters on both sides.
// Compare characters — if mismatch found, not a palindrome.
// Time: O(n) | Space: O(1)

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters (case insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();

        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama"));
        // Expected: true

        System.out.println(sol.isPalindrome("race a car"));
        // Expected: false

        System.out.println(sol.isPalindrome(" "));
        // Expected: true
    }
}