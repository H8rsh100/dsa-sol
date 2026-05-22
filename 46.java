// LeetCode #7 - Reverse Integer
// Difficulty: Medium
// Link: https://leetcode.com/problems/reverse-integer/

// Problem:
// Given a signed 32-bit integer, reverse its digits.
// If reversing causes overflow outside [-2³¹, 2³¹-1], return 0.

// Approach: Math - Pop and Push digits
// Pop last digit using % 10.
// Push it onto reversed number using * 10.
// Check for overflow BEFORE multiplying to avoid actual overflow.
// Time: O(log n) | Space: O(1)

class ReverseInteger {
    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10; // pop last digit
            x /= 10;

            // Check overflow before pushing digit
            // If reversed > Integer.MAX_VALUE/10, next push will overflow
            if (reversed > Integer.MAX_VALUE / 10 ||
               (reversed == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (reversed < Integer.MIN_VALUE / 10 ||
               (reversed == Integer.MIN_VALUE / 10 && digit < -8)) return 0;

            reversed = reversed * 10 + digit; // push digit
        }

        return reversed;
    }

    public static void main(String[] args) {
        ReverseInteger sol = new ReverseInteger();

        System.out.println(sol.reverse(123));
        // Expected: 321

        System.out.println(sol.reverse(-123));
        // Expected: -321

        System.out.println(sol.reverse(120));
        // Expected: 21

        System.out.println(sol.reverse(1534236469));
        // Expected: 0 (overflow)
    }
}