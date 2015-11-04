/**
 * Binary Tree Longest Consecutive Sequence
 *
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
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

	int max = 0;
    
    public int longestConsecutive(TreeNode root) {
    	
    	if (root == null)
    		return 0;
    	longestConsecutiveCount(null, root, 0);
    	return max;


    }

    public void longestConsecutiveCount(TreeNode pre, TreeNode cur, int count) {
    	if (cur == null)
    		return;

    	if ((pre == null) || ((cur.val - pre.val) != 1))
    		count = 1;
    	else{
    		count ++;
    	}

    	if (max < count)
    		max = count;

    	longestConsecutiveCount(cur, cur.left, count);
    	longestConsecutiveCount(cur, cur.right, count);
    }

}