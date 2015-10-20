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
    TreeNode newRoot = null;
    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) {
            return null;
        } 
        
        if(root.left == null && root.right == null) {
            newRoot = root;
            return newRoot;
        }
        
        upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        
        

        return newRoot;
        
    }
}
