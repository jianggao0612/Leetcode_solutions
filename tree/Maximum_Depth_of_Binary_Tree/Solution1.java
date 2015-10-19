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
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            maxDepth = 1;
        }
        traverse(root, maxDepth);
        return maxDepth;
    }
    
    public void traverse(TreeNode node, int depth) {
        if(depth > maxDepth) {
            maxDepth = depth;
        } 
        if(node.left != null) {
            traverse(node.left, depth+1);
        }
        if(node.right != null) {
            traverse(node.right, depth+1);
        }
    }
}
