// LeetCode #33 - Search in Rotated Sorted Array
// Difficulty: Medium
// Link: https://leetcode.com/problems/search-in-rotated-sorted-array/

// Problem:
// A sorted array was rotated at an unknown pivot.
// Given a target, return its index or -1 if not found.
// Must be O(log n).

// Approach: Modified Binary Search
// One half of the array is always sorted after rotation.
// Check which half is sorted, then determine if target lies in it.
// Narrow search space accordingly.
// Time: O(log n) | Space: O(1)

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // target in left half
                } else {
                    left = mid + 1;  // target in right half
                }
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;  // target in right half
                } else {
                    right = mid - 1; // target in left half
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();

        System.out.println(sol.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        // Expected: 4

        System.out.println(sol.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        // Expected: -1

        System.out.println(sol.search(new int[]{1}, 0));
        // Expected: -1
    }
}