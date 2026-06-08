// LeetCode #407 - Trapping Rain Water II
// Difficulty: Hard
// Link: https://leetcode.com/problems/trapping-rain-water-ii/

// Problem:
// Given an m x n matrix of heights representing an elevation map,
// return how much water it can trap after raining.
// 3D version of the classic trapping rain water problem.

// Approach: Min Heap (Priority Queue) + BFS
// Water level at any cell is determined by the minimum height
// on the path from that cell to the boundary.
// Start from all boundary cells (they can't trap water).
// Use min heap to always process the lowest boundary cell first.
// For each neighbor — if it's lower than current cell, it traps water.
// Time: O(m * n * log(m * n)) | Space: O(m * n)

import java.util.*;

class TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3) return 0;

        int rows = heightMap.length;
        int cols = heightMap[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // Min heap: [height, row, col]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Add all boundary cells to heap
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1) {
                    minHeap.offer(new int[]{heightMap[r][c], r, c});
                    visited[r][c] = true;
                }
            }
        }

        int water = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            int height = cell[0], r = cell[1], c = cell[2];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (visited[nr][nc]) continue;

                visited[nr][nc] = true;

                // If neighbor is lower than current boundary — it traps water
                if (heightMap[nr][nc] < height) {
                    water += height - heightMap[nr][nc];
                }

                // Push neighbor with max of its height and current boundary
                minHeap.offer(new int[]{Math.max(height, heightMap[nr][nc]), nr, nc});
            }
        }

        return water;
    }

    public static void main(String[] args) {
        TrappingRainWaterII sol = new TrappingRainWaterII();

        System.out.println(sol.trapRainWater(new int[][]{
            {1,4,3,1,3,2},
            {3,2,1,3,2,4},
            {2,3,3,2,3,1}
        }));
        // Expected: 4

        System.out.println(sol.trapRainWater(new int[][]{
            {3,3,3,3,3},
            {3,2,2,2,3},
            {3,2,1,2,3},
            {3,2,2,2,3},
            {3,3,3,3,3}
        }));
        // Expected: 10
    }
}