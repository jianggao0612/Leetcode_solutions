/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        int leftDepth = 0;
        int rightDepth = 0;
        if(root == null)
            return true;
        
        if(root.left != null)
            leftDepth = getDepth(root.left,leftDepth+1);
        if(root.right != null)
            rightDepth = getDepth(root.right, rightDepth+1);
        if(rightDepth == -1 || leftDepth == -1)
            return false;
        if(leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1)
            return false;
        return true;
    }
    
    public int getDepth(TreeNode node, int depth) {
        if(node.left == null && node.right == null) {
            return depth;
        }
        
        int leftDepth = depth;
        int rightDepth = depth;
        if(node.left != null)
            leftDepth = getDepth(node.left, depth+1);
        if(node.right != null)
            rightDepth = getDepth(node.right, depth+1);
        if(rightDepth == -1 || leftDepth == -1)
            return -1;
        if(leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1)
            return -1;
        return leftDepth>rightDepth?leftDepth:rightDepth;
    }
}
