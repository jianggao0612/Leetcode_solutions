/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
 * use preorder traverse to do the switch - for every node, switch it's left and right child
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode searchNode = root;
        TreeNode switchNode = null;

        // deal with corner case
        if (root == null) 
        	return null;
        if ((root.left == null) && (root.right == null))
        	return root;

        // do preorder traverse
        while (true) {
        	while (searchNode != null) {
        		// switch the left and right child
        		switchNode = searchNode.left;
        		searchNode.left = searchNode.right;
        		searchNode.right = switchNode;

        		// push the right child into stack for preorder traverse
        		if (searchNode.right != null)
        			stack.push(searchNode.right);

        		// continue dealing with the left sub-tree
        		searchNode = searchNode.left;
        	}

        	if (stack.isEmpty())
        		break;

        	searchNode = stack.pop();
        }

        return root;
    }
}