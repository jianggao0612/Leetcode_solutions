/**
 * Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * Recursive implementation
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
    public TreeNode sortedArrayToBST(int[] nums) {

    	return convertArrayToBST(nums, 0, nums.length - 1);
        
    }

    public TreeNode convertArrayToBST(int[] nums, int start, int end) {
        
    	if (start > end) {
    		return null;
    	}

    	if (start == end) {

    		TreeNode root = new TreeNode(nums[start]);

    		return root;
    	}

    	int mid = (end + start) / 2; // TRICKY: Use + not - in case of stack over flow
    	
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = convertArrayToBST(nums, start, mid - 1); // recursively generate left sub-tree
    	root.right = convertArrayToBST(nums, mid + 1, end); // recursively generate right sub-tree

    	return root;
    }
}