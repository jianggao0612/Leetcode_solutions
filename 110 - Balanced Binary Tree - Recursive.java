/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Recursive implementation
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public boolean isBalanced(TreeNode root) {

	// Corner case
    if (root == null) {
    	return true;
    }

    // Corner case
    if ((root.left == null) && (root.right == null)) {
    	return true;
    }

    // Determine whether it's balanced
    if (Math.abs(findLength(root.left) - findLength(root.right)) > 1) {
    	return false;
    }

    // Recursively go over all the left and right sub-tree
    return (isBalanced(root.left) && isBalanced(root.right));

}

/**
 * A help function to find the max length of a given tree
 */
public int findLength(TreeNode root) {

	if (root == null) {
		return 0;
	} else {
		return Math.max(findLength(root.left), findLength(root.right)) + 1;
	}
}
