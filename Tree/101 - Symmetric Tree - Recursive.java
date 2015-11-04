/**
 * Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
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
    public boolean isSymmetric(TreeNode root) {
        // Corner case
        if (root == null)
            return true;

        // Corner case
        if ((root.left == null) & (root.right == null))
            return true;

        // Recursive determination
        return symmetricTree(root.left, root.right);
    }
    
    /**
     * Help function to determine whether two given tree are symmtric
     * Left child of one tree should equal right child of the other tree
     * Recursive
     */
    public boolean symmetricTree(TreeNode left, TreeNode right) {

        if ((left == null) && (right == null))
            return true;

        if (((left == null) && (right != null)) || (left != null) && (right == null) || (left.val != right.val))
            return false;

        return symmetricTree(left.left, right.right) && symmetricTree(left.right, right.left);
    }
}