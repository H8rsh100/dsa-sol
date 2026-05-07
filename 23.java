// LeetCode #733 - Flood Fill
// Difficulty: Easy
// Link: https://leetcode.com/problems/flood-fill/

// Problem:
// Given an image (2D array), a starting pixel (sr, sc), and a new color,
// perform flood fill — change the starting pixel and all connected pixels
// of the same original color to the new color.
// (Like the paint bucket tool in MS Paint)

// Approach: DFS Recursion
// From starting pixel, recursively fill all 4-directional neighbors
// that have the same original color.
// Base case: out of bounds, wrong color, or already filled.
// Time: O(n * m) | Space: O(n * m) call stack

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        // If original color is same as new color, nothing to do
        if (originalColor == color) return image;

        fill(image, sr, sc, originalColor, color);
        return image;
    }

    private void fill(int[][] image, int r, int c, int original, int color) {
        // Out of bounds check
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        // Not the original color — stop
        if (image[r][c] != original) return;

        image[r][c] = color; // fill this pixel

        // Recurse in all 4 directions
        fill(image, r + 1, c, original, color); // down
        fill(image, r - 1, c, original, color); // up
        fill(image, r, c + 1, original, color); // right
        fill(image, r, c - 1, original, color); // left
    }

    public static void main(String[] args) {
        FloodFill sol = new FloodFill();

        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] result = sol.floodFill(image, 1, 1, 2);

        for (int[] row : result) {
            for (int pixel : row) System.out.print(pixel + " ");
            System.out.println();
        }
        // Expected:
        // 2 2 2
        // 2 2 0
        // 2 0 1
    }
}