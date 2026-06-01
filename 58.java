// LeetCode #84 - Largest Rectangle in Histogram
// Difficulty: Hard
// Link: https://leetcode.com/problems/largest-rectangle-in-histogram/

// Problem:
// Given an array of integers representing bar heights in a histogram,
// return the area of the largest rectangle in the histogram.

// Approach: Monotonic Stack
// Maintain a stack of indices with increasing heights.
// When we find a bar shorter than stack top, we can calculate
// the area with stack top as the shortest bar.
// Width extends from current index back to the new stack top.
// Time: O(n) | Space: O(n)

import java.util.Stack;

class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // stores indices
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // Use 0 as sentinel height at the end to flush stack
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                // Width: from current index back to new stack top
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram sol = new LargestRectangleInHistogram();

        System.out.println(sol.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        // Expected: 10 (bars of height 5 and 6, width 2)

        System.out.println(sol.largestRectangleArea(new int[]{2, 4}));
        // Expected: 4

        System.out.println(sol.largestRectangleArea(new int[]{1}));
        // Expected: 1
    }
}