// LeetCode #704 - Binary Search
// Difficulty: Easy
// Link: https://leetcode.com/problems/binary-search/

// Problem:
// Given a sorted array of integers and a target,
// return the index of target. If not found, return -1.

// Approach: Classic Binary Search
// Repeatedly halve the search space.
// If mid == target, return it.
// If mid < target, search right half.
// If mid > target, search left half.
// Time: O(log n) | Space: O(1)

class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // avoids integer overflow vs (left+right)/2

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;  // target in right half
            } else {
                right = mid - 1; // target in left half
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {
        BinarySearch sol = new BinarySearch();

        System.out.println(sol.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        // Expected: 4

        System.out.println(sol.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        // Expected: -1
    }
}