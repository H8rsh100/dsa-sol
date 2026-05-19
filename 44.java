// LeetCode #136 - Single Number
// Difficulty: Easy
// Link: https://leetcode.com/problems/single-number/

// Problem:
// Given a non-empty array where every element appears twice
// except for one. Find that single one.
// Must be O(n) time and O(1) space.

// Approach: XOR Bit Manipulation
// XOR properties:
//   a ^ a = 0 (same number cancels out)
//   a ^ 0 = a (zero has no effect)
//   XOR is commutative and associative
// So XOR all numbers together — pairs cancel, single remains.
// Time: O(n) | Space: O(1)

class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num; // XOR each number
        }

        return result; // all pairs cancelled, only single remains
    }

    public static void main(String[] args) {
        SingleNumber sol = new SingleNumber();

        System.out.println(sol.singleNumber(new int[]{2, 2, 1}));
        // Expected: 1

        System.out.println(sol.singleNumber(new int[]{4, 1, 2, 1, 2}));
        // Expected: 4

        System.out.println(sol.singleNumber(new int[]{1}));
        // Expected: 1
    }
}