// LeetCode #101 - Symmetric Tree
// Difficulty: Easy
// Link: https://leetcode.com/problems/symmetric-tree/

// Problem:
// Given root of a binary tree, check whether it is a mirror of itself
// (i.e. symmetric around its center).

// Approach: Recursion
// A tree is symmetric if left subtree is a mirror of right subtree.
// Two trees are mirrors if:
//   1. Their roots have the same value
//   2. Left's left mirrors Right's right
//   3. Left's right mirrors Right's left
// Time: O(n) | Space: O(h)

class SymmetricTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;  // both null — symmetric
        if (left == null || right == null) return false; // one null — not symmetric

        return (left.val == right.val)
            && isMirror(left.left, right.right)   // outer pair
            && isMirror(left.right, right.left);  // inner pair
    }

    public static void main(String[] args) {
        SymmetricTree sol = new SymmetricTree();

        // Symmetric tree:    1
        //                   / \
        //                  2   2
        //                 / \ / \
        //                3  4 4  3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(sol.isSymmetric(root));
        // Expected: true
    }
}