/**
 * Sum Root to Leaf Numbers
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 *
 *************************************************************************************************************************************************
 * General idea: When access a node, the sum from the last level should multiply 10 and add the value of this node
 * then go to the next level
 *
 * For each node in the tree, there are three situations:
 * If the node is null, just return 0 (since it's upper level should be the leaves, which cannot be multiplied by 10)
 * If the node is a leaf node (which doesn't have left and right child), multiply the sum from the last level by 10 and add the value of the node
 * If the node is a normal node (which has a left or right child), multiply the sum from the last level by 10 and add the value of the node
 * then go to the next level (recursive)
 *************************************************************************************************************************************************
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

    public int sumNumbers(TreeNode root) {

    	return sumNumbersHelper(root, 0);

    }

    public int sumNumbersHelper(TreeNode root, int sum) {

    	if (root == null){

    		return 0;

    	} else if ((root.left == null) && (root.right == null)){

    		return sum * 10 + root.val;

    	else {

    		return sumNumbersHelper(root.left, sum * 10 + root.val) + sumNumbersHelper(root.right, sum * 10 + root.val);

    	}


    }
}