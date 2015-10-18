/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
    int leftDepth = 0;
    int rightDepth = 0;

    // corner case
    if (root == null)
    	return false;
    if ((root.left == null) && (root.right == null))
    	return true;

    // get depth of the left subtree and right subtree
    leftDepth = findDepth(root.left) + 1;
    rightDepth = findDepth(root.right) + 1;

    // determine whether it's balanced
    if (Math.abs(leftDepth - rightDepth) <= 1)
    	return true;
    else
    	return false;
}

/**
 * Find the depth of a given binary tree
 */
public int findDepth(TreeNode root) {
	ArrayList<TreeNode> currentPath = new ArrayList<TreeNode>();
	ArrayList<TreeNode> visitedPath = new ArrayList<TreeNode>();
	int depth = 0;
	TreeNode searchNode;

	if (root == null)
		return 0;

	currentPath.add(root);

	while (currentPath.size() > 0) {
		searchNode = currentPath.get(currentPath.size() - 1);
		if ((searchNode.left != null) && (!visitedPath.contains(searchNode))) {
			currentPath.add(searchNode.left);
			if (currentPath.size() > depth)
				depth = currentPath.size();
		} else if((searchNode.right != null) && (!visitedPath.contains(searchNode))) {
			currentPath.add(searchNode.right);
			if (currentPath.size() > depth)
				depth = currentPath.size();
		} else {
			visitedPath.add(currentPath.get(currentPath.size() - 1));
			currentPath.remove(currentPath.size() - 1);
		}
	}

	return depth;
}
