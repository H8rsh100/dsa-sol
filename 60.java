// LeetCode #239 - Sliding Window Maximum
// Difficulty: Hard
// Link: https://leetcode.com/problems/sliding-window-maximum/

// Problem:
// Given an array and window size k,
// return the maximum value in each sliding window of size k.

// Approach: Monotonic Deque
// Maintain a deque of indices in decreasing order of their values.
// Front of deque = index of max element in current window.
// For each new element:
//   Remove indices outside current window from front.
//   Remove smaller elements from back (they'll never be the max).
//   Add current index to back.
//   Front of deque is the max for this window.
// Time: O(n) | Space: O(k)

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // Remove elements outside current window from front
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements from back — they'll never be max
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Start recording results once first window is complete
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum sol = new SlidingWindowMaximum();

        System.out.println(Arrays.toString(
            sol.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)
        ));
        // Expected: [3,3,5,5,6,7]

        System.out.println(Arrays.toString(
            sol.maxSlidingWindow(new int[]{1}, 1)
        ));
        // Expected: [1]
    }
}