// LeetCode #417 - Pacific Atlantic Water Flow
// Difficulty: Medium
// Link: https://leetcode.com/problems/pacific-atlantic-water-flow/

// Problem:
// Given an m x n matrix of heights, water can flow to neighboring
// cells with equal or lower height.
// Pacific ocean touches top and left edges.
// Atlantic ocean touches bottom and right edges.
// Return all cells that can flow to BOTH oceans.

// Approach: Reverse DFS from both oceans
// Instead of checking each cell forward, reverse it —
// start from ocean edges and flow UPHILL (to equal or higher cells).
// Cells reachable from Pacific AND Atlantic are our answer.
// Time: O(m * n) | Space: O(m * n)

import java.util.*;

class PacificAtlanticWaterFlow {
    private int[][] heights;
    private int rows, cols;
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.rows = heights.length;
        this.cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // DFS from Pacific edges (top row + left col)
        for (int c = 0; c < cols; c++) dfs(0, c, pacific);
        for (int r = 0; r < rows; r++) dfs(r, 0, pacific);

        // DFS from Atlantic edges (bottom row + right col)
        for (int c = 0; c < cols; c++) dfs(rows - 1, c, atlantic);
        for (int r = 0; r < rows; r++) dfs(r, cols - 1, atlantic);

        // Collect cells reachable from both
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
            if (visited[nr][nc]) continue;
            if (heights[nr][nc] < heights[r][c]) continue; // must go uphill

            dfs(nr, nc, visited);
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow sol = new PacificAtlanticWaterFlow();

        int[][] heights = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };

        System.out.println(sol.pacificAtlantic(heights));
        // Expected: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
    }
}