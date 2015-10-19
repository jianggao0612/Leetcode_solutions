/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/**
 * The important thing is that p and q are actual nodes in the tree.
 * Need to compare the object rather than value. This guarantees the lowestCommonAncestor is unique.
 */
public class Solution {
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null) {
           return null;
       }
       
       if( root == p || root == q) {
           return root;
       }
       
       TreeNode left = lowestCommonAncestor(root.left, p, q);
       TreeNode right = lowestCommonAncestor(root.right, p, q);
       
       if(left == null && right == null) {
           return null;
       } else if(left != null && right != null) {
           return root;
       } else if(left != null && right == null) {
           return left;
       } else if(left == null && right != null) {
           return right;
       }
       return null;
   }
}
