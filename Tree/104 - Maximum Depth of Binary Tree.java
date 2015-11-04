/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
    ArrayList<TreeNode> currentPath = new ArrayList<TreeNode>();
	ArrayList<TreeNode> visitedNode = new ArrayList<TreeNode>();
	int maximumLength = 1;
	TreeNode searchNode;

	// corner case
	if (root == null) 
		return 0;

	currentPath.add(root);

	while (currentPath.size() > 0) {

		// get the top element of the stack (the last element of the ArrayList)
		searchNode = currentPath.get(currentPath.size() - 1);
		
		// determine whether to go further left
		if ((searchNode.left != null) && (!visitedNode.contains(searchNode.left))) {

			currentPath.add(searchNode.left);
			// update the current maximum path
			if (currentPath.size() > maximumLength) 
				maximumLength = currentPath.size();

		} else if ((searchNode.right != null) && (!visitedNode.contains(searchNode.right))){ // determine whether to go further right

			currentPath.add(searchNode.right);
			// update the current maximum path
			if (currentPath.size() > maximumLength) 
				maximumLength = currentPath.size();

		} else {

			// set the node as visited
			searchNode = currentPath.get(currentPath.size() - 1);
			visitedNode.add(searchNode);
			currentPath.remove(currentPath.size() - 1);
		
		}
    }
    return maximumLength;
}
