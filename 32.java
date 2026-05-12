// LeetCode #153 - Find Minimum in Rotated Sorted Array
// Difficulty: Medium
// Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

// Problem:
// A sorted array was rotated at some unknown pivot.
// Find the minimum element. Must be O(log n).

// Approach: Binary Search
// If mid > right, minimum is in right half (rotation point is there).
// If mid <= right, minimum is in left half including mid.
// Narrow down until left == right — that's the minimum.
// Time: O(log n) | Space: O(1)

class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum is in right half
                left = mid + 1;
            } else {
                // Minimum is in left half including mid
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray sol = new FindMinimumInRotatedSortedArray();

        System.out.println(sol.findMin(new int[]{3, 4, 5, 1, 2}));
        // Expected: 1

        System.out.println(sol.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        // Expected: 0

        System.out.println(sol.findMin(new int[]{11, 13, 15, 17}));
        // Expected: 11 (no rotation)
    }
}