/**
 *
 * Binary Search Tree Iterator
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST. 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 *************************************************************************************************************************************
 * Keep a stack store all the left node 
 * When pop one node out, if it has right child, the right child is its next; if not, the next node in the stack should be its next
 * NOTICE!!!!!: when pop one node that has a right child, the right sub-tree should also be traversed (push the left node into stack)
 ************************************************************************************************************************************* 
 *
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

	Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
    	
    	TreeNode node = root;

    	while (node != null) {

    		stack.push(node);
    		node = node.left;

    	}
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

    	return !(stack.isEmpty());
        
    }

    /** @return the next smallest number */
    public int next() {

    	TreeNode node = stack.pop();

    	if (node.right != null) {
    		stack.push(node.right);
    	
	    	TreeNode currentNode = stack.peek();
	    	
	    	while(currentNode.left != null) {
	    		stack.push(currentNode.left);
	    		currentNode = currentNode.left;
	    	}
	    }

    	return node.val;
        
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */