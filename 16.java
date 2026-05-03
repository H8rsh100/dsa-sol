// LeetCode #104 - Maximum Depth of Binary Tree
// Difficulty: Easy
// Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/

// Problem:
// Given root of a binary tree, return its maximum depth.
// Maximum depth = number of nodes along the longest path
// from root down to the farthest leaf node.

// Approach: Recursion (DFS)
// The depth of a tree is 1 + max(depth of left, depth of right).
// Base case: null node has depth 0.
// This naturally traverses the entire tree bottom-up.
// Time: O(n) | Space: O(h) where h = height of tree (call stack)

class MaxDepthBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0; // base case

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        MaxDepthBinaryTree sol = new MaxDepthBinaryTree();

        // Build tree:    3
        //               / \
        //              9  20
        //                /  \
        //               15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(sol.maxDepth(root));
        // Expected: 3
    }
}