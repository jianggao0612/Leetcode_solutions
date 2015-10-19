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
    int minimalDepth = -1;
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        traverse(root, 1);
        
        return minimalDepth;
    }
    
    public void traverse(TreeNode node, int depth) {
        if(depth >= minimalDepth && minimalDepth != -1) {
            return;
        }
        if(node.left != null) {
            traverse(node.left, depth+1);
        } 
        if(node.right != null) {
            traverse(node.right, depth+1);
        }
        if(node.left == null && node.right == null) {
            if(depth < minimalDepth || minimalDepth == -1) {
                minimalDepth = depth;
            }
        }
    }
}
