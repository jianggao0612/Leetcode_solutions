/**
 * Flatten Binary Tree to Linked List
 * Given a binary tree, flatten it to a linked list in-place.
 *
 *****************************************************************************************************************************
 * Idea: Store all the right node in stack and change the pointer. Notice the node for traverse and the node for the new tree.
 *****************************************************************************************************************************
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
    public void flatten(TreeNode root) {

    	Stack<TreeNode> rightNodeStack = new Stack<TreeNode>();
    	TreeNode node, currentNode;

    	if (root == null)
    		return;
    		
    	if ((root.left == null) && (root.right == null))
    	    return;
        
    	node = root;
    	currentNode = root;

    	while (true) {
    		
    		while (node != null) {
    		    
    			if (node.right != null) {
    				rightNodeStack.push(node.right); // push the right node in stack
    			}

				node = node.left; // keep track of the left node in the old tree

				/*
				 * change the pointer in the new tree nodes
				 */
    			if (node != null) {

    				currentNode.left = null;
	    			currentNode.right = node;
	    			currentNode = currentNode.right;

    			}
    				    		
    		}

    		if (rightNodeStack.size() == 0)
    			break;

    		/*
    		 * For the right node in the stack, do the same thing
    		 */
    		node = rightNodeStack.pop();
    		currentNode.right = node;
    		currentNode = currentNode.right;

    	}
        
    }
}