/**
 * Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        ArrayList<TreeNode> currentPath = new ArrayList<TreeNode>();
        ArrayList<TreeNode> finished = new ArrayList<TreeNode>();
        TreeNode node = root;
        int minLength = Integer.MAX_VALUE;

        if (root == null)
        	return 0;

        if (root.left == null || root.right == null)
        	return 1;

        currentPath.add(root);

        while (currentPath.size() > 0) {
        	node = currentPath.get(currentPath.size() - 1);

        	if ((node.left != null) && (!finished.contains(node))) {

        		currentPath.add(node.left);

        	} else if ((node.right != null) && (!finished.contains(node))) {

        		currentPath.add(node.right);

        	} else if ((node.left == null) && (node.right == null)) {

        		if (currentPath.size() < minLength)
        			minLength = currentPath.size();
        		
        		node = currentPath.get(currentPath.size() - 1);
        		finished.add(node);
        		currentPath.remove(currentPath.size() - 1);

        	} else {

        		node = currentPath.get(currentPath.size() - 1);
        		finished.add(node);
        		currentPath.remove(currentPaht.size() - 1);

        	}
        }

        return minLength;

    }
}