// LeetCode #215 - Kth Largest Element in an Array
// Difficulty: Medium
// Link: https://leetcode.com/problems/kth-largest-element-in-an-array/

// Problem:
// Given an integer array, return the kth largest element.
// Not kth distinct — kth largest in sorted order.

// Approach: Min Heap of size k
// Maintain a min heap of the k largest elements seen so far.
// For each element: add it to heap.
// If heap size exceeds k, remove the smallest (heap top).
// At the end, heap top is the kth largest.
// Time: O(n log k) | Space: O(k)

import java.util.PriorityQueue;

class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue in Java is a min heap by default
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            // Keep only k largest elements
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }
        }

        return minHeap.peek(); // top of heap = kth largest
    }

    public static void main(String[] args) {
        KthLargestElement sol = new KthLargestElement();

        System.out.println(sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        // Expected: 5

        System.out.println(sol.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        // Expected: 4
    }
}