// LeetCode #235 - Lowest Common Ancestor of BST
// Difficulty: Medium
// Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

// Problem:
// Given a BST and two nodes p and q, find their lowest common ancestor.
// LCA is the deepest node that has both p and q as descendants.

// Approach: BST Property
// In a BST, left < root < right.
// If both p and q are smaller than root → LCA is in left subtree.
// If both are larger → LCA is in right subtree.
// If they split (one each side) → current node IS the LCA.
// Time: O(h) | Space: O(1)

class LowestCommonAncestor {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;  // both in left subtree
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right; // both in right subtree
            } else {
                return root; // they split here — this is the LCA
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LowestCommonAncestor sol = new LowestCommonAncestor();

        //        6
        //       / \
        //      2   8
        //     / \ / \
        //    0  4 7  9
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;        // node 2
        TreeNode q = root.left.right;  // node 4

        System.out.println(sol.lowestCommonAncestor(root, p, q).val);
        // Expected: 2
    }
}