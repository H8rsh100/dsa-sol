// LeetCode #347 - Top K Frequent Elements
// Difficulty: Medium
// Link: https://leetcode.com/problems/top-k-frequent-elements/

// Problem:
// Given an integer array, return the k most frequent elements.
// Answer can be in any order.

// Approach: HashMap + Min Heap
// Count frequency of each element using HashMap.
// Use a min heap of size k ordered by frequency.
// At end, heap contains the k most frequent elements.
// Time: O(n log k) | Space: O(n)

import java.util.*;

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // Count frequencies
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Min heap ordered by frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> freq.get(a) - freq.get(b));

        for (int num : freq.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove least frequent
            }
        }

        // Build result from heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements sol = new TopKFrequentElements();

        System.out.println(Arrays.toString(sol.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2)));
        // Expected: [1, 2]

        System.out.println(Arrays.toString(sol.topKFrequent(new int[] { 1 }, 1)));
        // Expected: [1]
    }
}