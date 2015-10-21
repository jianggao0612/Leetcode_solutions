/**
 * Binary Tree Upside Down
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, 
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 *
 * Idea:
 * For each node:
 * Initialize: Store its parent, store its parent's right node
 * First step: Before change this node, store its left for next iteration, and then put its parent's right node to its left
 * Second step: Update the right node to the node's right node for next iteration, and then put its parent(literally parent, actually the result in last iteration) to its right
 * Third step: Update the parent node as the current node for next iteration
 * Fourth step: Go the the next iteration
 *
 * *********************** SPECIAL NOTICE: Take care of the sequence when doing update, otherwise the steps cannot continue correctly [Store before update] ************************
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
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {

    	// Corner case
    	if (root == null)
    		return null;

    	TreeNode node = root;
    	TreeNode parent = null;
    	TreeNode rightNode = null;

    	while (node != null) {

    		TreeNode leftNode = node.left; // store the leftNode in the original tree for the next iteration
    		node.left = rightNode; // update current node's left with its parent's right node
    		rightNode = node.right; // store current node's right node for the next iteration
    		node.right = parent; // update current node's right with the node from last iteration
    		parent = node; // set current node as parent for next iteration
    		node = leftNode; // go to next iteration

    	}

    	return parent;

    }
}