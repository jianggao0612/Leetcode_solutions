/**
 * Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Recursive Implementation
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
    public int minDepth(TreeNode root) {

        int minLeft = 0;
        int minRight = 0;

        if (root == null)
            return 0;
        
        if ((root.left == null) && (root.right == null))
            return 1;

        minLeft = minDepth(root.left);
        minRight = minDepth(root.right);
        
        if ((root.left != null) && (root.right == null)) 
            return minLeft + 1;
        if ((root.left == null) && (root.right != null))
            return minRight + 1;
        
        return Math.min(minLeft, minRight) + 1;
        
    }
}
