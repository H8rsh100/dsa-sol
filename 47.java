// LeetCode #191 - Number of 1 Bits
// Difficulty: Easy
// Link: https://leetcode.com/problems/number-of-1-bits/

// Problem:
// Given a positive integer, return the number of set bits (1s)
// in its binary representation. Also known as Hamming Weight.

// Approach: Brian Kernighan's Algorithm
// n & (n-1) clears the lowest set bit of n.
// Count how many times we can do this until n becomes 0.
// Much faster than checking every bit individually.
// Time: O(k) where k = number of set bits | Space: O(1)

class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1); // clear lowest set bit
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits sol = new NumberOf1Bits();

        System.out.println(sol.hammingWeight(11));
        // 11 in binary = 1011 → 3 set bits
        // Expected: 3

        System.out.println(sol.hammingWeight(128));
        // 128 in binary = 10000000 → 1 set bit
        // Expected: 1

        System.out.println(sol.hammingWeight(2147483645));
        // Expected: 30
    }
}