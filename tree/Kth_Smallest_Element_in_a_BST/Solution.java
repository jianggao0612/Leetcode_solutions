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
    ArrayList<TreeNode> trace = new ArrayList<TreeNode>();
    
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return trace.get(k-1).val;
    }
    
    // Preorder traversal
    public void traverse(TreeNode node, int k) {
        if(trace.size() == k) {
            return;
        }
        
        if(node.left == null && node.right == null) {
            trace.add(node);
            return;
        }
        if(node.left != null) {
            traverse(node.left, k);
        }
        trace.add(node);
        if(node.right != null) {
            traverse(node.right, k);
        }
    }
}
