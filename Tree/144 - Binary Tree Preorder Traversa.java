/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> resultList = new List<Integer>();
        TreeNode node = root;

        if (root == null) {
        	return null;
        }

        while (true) {
        	while (node != null) {
        		resultList.add(node.val);
        		if (node.right != null) {
        			stack.push(node.right);
        		}
        	} 

        }

    }
}