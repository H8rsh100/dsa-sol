// LeetCode #217 - Contains Duplicate
// Difficulty: Easy
// Link: https://leetcode.com/problems/contains-duplicate/

// Problem:
// Given an integer array, return true if any value appears at least twice,
// return false if every element is distinct.

// Approach: HashSet
// Add each number to a HashSet as we iterate.
// If we try to add a number that already exists — duplicate found.
// Time: O(n) | Space: O(n)

import java.util.HashSet;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                // Already saw this number — it's a duplicate
                return true;
            }
            seen.add(num);
        }

        return false; // no duplicates found
    }

    public static void main(String[] args) {
        ContainsDuplicate sol = new ContainsDuplicate();

        System.out.println(sol.containsDuplicate(new int[]{1, 2, 3, 1}));
        // Expected: true

        System.out.println(sol.containsDuplicate(new int[]{1, 2, 3, 4}));
        // Expected: false
    }
}
