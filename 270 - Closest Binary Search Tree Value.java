/**
 * Closest Binary Search Tree Value
 *
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Keep one node as the current search node
 * Keep another node as the current minimum distance node
 * Keep a value as the current minimum distance
 * Do binary search in the binary search tree
 * O(logn)
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode searchNode = root; // current search node to traverse the tree
        TreeNode miniNode = root; // current minimum distance node
        double miniDistance = Math.abs(root.val - target); // current minimum distance

        // Remember to consider corner case if the question doesn't mention the tree is not empty
        while (searchNode != null) {
            double distance = Math.abs(searchNode.val - target);
        	// determine whether the current search node has smaller distance 
        	if (distance < miniDistance) {
        		// update the current minimums if so
        		miniDistance = distance;
        		miniNode = searchNode;
        	} 

        	// no distance will small than 0, breakpoint
        	if (miniDistance == 0)
        		break;

        	// do binary search
        	if (searchNode.val > target) 
        		searchNode = searchNode.left;
        	else
        		searchNode = searchNode.right;
        }

        return miniNode.val;
    }
}