// LeetCode #226 - Invert Binary Tree
// Difficulty: Easy
// Link: https://leetcode.com/problems/invert-binary-tree/

// Problem:
// Given root of a binary tree, invert it (mirror it) and return its root.

// Approach: Recursion (DFS)
// At every node, swap left and right children.
// Then recursively invert both subtrees.
// Same pattern: base case → swap → recurse.
// Time: O(n) | Space: O(h)

class InvertBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null; // base case

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert both subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree sol = new InvertBinaryTree();

        // Build tree:    4
        //               / \
        //              2   7
        //             / \ / \
        //            1  3 6  9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode inverted = sol.invertTree(root);

        // Expected output (level order): 4 7 2 9 6 3 1
        System.out.println(inverted.val);           // 4
        System.out.println(inverted.left.val);      // 7
        System.out.println(inverted.right.val);     // 2
    }
}