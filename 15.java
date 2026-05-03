// LeetCode #35 - Search Insert Position
// Difficulty: Easy
// Link: https://leetcode.com/problems/search-insert-position/

// Problem:
// Given a sorted array and a target, return the index if found.
// If not found, return the index where it would be inserted in order.

// Approach: Binary Search with a twist
// Standard binary search — but when target isn't found,
// left pointer ends up exactly where target should be inserted.
// Time: O(log n) | Space: O(1)

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // left is now the insertion point
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition sol = new SearchInsertPosition();

        System.out.println(sol.searchInsert(new int[]{1, 3, 5, 6}, 5));
        // Expected: 2 (found at index 2)

        System.out.println(sol.searchInsert(new int[]{1, 3, 5, 6}, 2));
        // Expected: 1 (would insert between 1 and 3)

        System.out.println(sol.searchInsert(new int[]{1, 3, 5, 6}, 7));
        // Expected: 4 (would insert at end)
    }
}