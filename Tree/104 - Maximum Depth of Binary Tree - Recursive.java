/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
public int maxDepth(TreeNode root) {

	int leftMax = 0;
	int rightMax = 0;
    
    if (root == null) {
    	return 0;
    }

    if ((root.left == null) && (root.right == null) ) {
		return 1;
	}

	// Recursively calculate th depth of the left and right sub-tree
	leftMax = maxDepth(root.left);
	rightMax = maxDepth(root.right);

	return Math.max(leftMax, rightMax) + 1;

}