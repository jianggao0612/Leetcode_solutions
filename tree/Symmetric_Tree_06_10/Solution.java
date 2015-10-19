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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == root.right)
            return true;
        return isSame(root.left, root.right);
    }
    
    public boolean isSame(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 != null)
            return false;
        if(n1 != null && n2 == null)
            return false;
        if(n1 == n2)
            return true;
        if(n1.val != n2.val)
            return false;
        return isSame(n1.left, n2.right) && isSame(n1.right, n2.left);
    }
}
