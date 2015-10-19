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
	// Three situation
    // 1. p = q
    // 2. parent == q or parent == q, then return parent
    // 3. p and q sit in two sides, return parent
    // 4. p and q sit in same sides, recursion to subtree
       
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        
        if(p == root || q == root) {
            // either one is current root
            return root;
        } else if((root.val > p.val && root.val <q.val) || (root.val < p.val && root.val >q.val)) {
            // p and q sit two sides
            return root;
        } else if( root.val > p.val && root.val > q.val) {
            // both sit left side
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // both sit right side
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
