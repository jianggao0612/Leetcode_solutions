/**
 * Lowest Common Ancestor of a Binary Search Tree
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * Recursive implementation
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;

        if ((root == null) || (p == null) || (q == null))
            return null;

        if ((node.val >= p.val) && (node.val <= q.val))
            return node;

        if ((node.val > p.val) && (node.val > q.val))
            return lowestCommonAncestor(node.left, p, q);

        if ((node.val < p.val) && (node.val < q.val))
            return lowestCommonAncestor(node.right, p, q);

        return root;


    }
}