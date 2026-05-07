// LeetCode #200 - Number of Islands
// Difficulty: Medium
// Link: https://leetcode.com/problems/number-of-islands/

// Problem:
// Given a 2D grid of '1's (land) and '0's (water),
// return the number of islands.
// An island is surrounded by water and formed by connecting
// adjacent land cells horizontally or vertically.

// Approach: DFS - Sink the island
// Every time we find a '1', increment island count and
// DFS to mark all connected land as visited (change to '0').
// This way we never count the same island twice.
// Time: O(n * m) | Space: O(n * m)

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    sink(grid, r, c); // mark entire island as visited
                }
            }
        }

        return count;
    }

    private void sink(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return;
        if (grid[r][c] != '1') return;

        grid[r][c] = '0'; // sink this cell

        sink(grid, r + 1, c);
        sink(grid, r - 1, c);
        sink(grid, r, c + 1);
        sink(grid, r, c - 1);
    }

    public static void main(String[] args) {
        NumberOfIslands sol = new NumberOfIslands();

        char[][] grid1 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println(sol.numIslands(grid1));
        // Expected: 1

        char[][] grid2 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println(sol.numIslands(grid2));
        // Expected: 3
    }
}