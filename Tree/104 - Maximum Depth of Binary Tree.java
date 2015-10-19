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
	int maximumLength = 0;
	TreeNode searchNode;

	// corner case
	if (root == null) 
		return maximumLength;

	currentPath.add(root);

	while (currentPath.size() > 0) {
		searchNode = currentPath.get(currentPath.size() - 1);
		
		if ((searchNode.left != null) && (!visitedNode.contains(searchNode))) {
			currentPath.add(searchNode.left);
			if (currentPath.size() > maximumLength) 
				maximumLength = currentPath.size();
		} else if ((searchNode.right != null) && (!visitedNode.contains(searchNode))){
			currentPath.add(searchNode.right);
			if (currentPath.size() > maximumLength) 
				maximumLength = currentPath.size();
		} else {
			visitedNode.add(currentPath.get(currentPath.size() - 1));
			currentPath.remove(currentPath.get(currentPath.size() - 1));
		}
    }
    return maximumLength;
}
