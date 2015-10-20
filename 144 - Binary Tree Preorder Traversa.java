/**
 * Binary Tree Preorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.
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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
        List<Integer> resultList = new ArrayList<Integer>();
        TreeNode node = root;

        // Corner case
        if (root == null) {
        	return resultList;
        }

        while (true) {

            while (node != null) {

                // Access the root first (pre-order)
                resultList.add(node.val);

                // Push the right child into the stack
                if (node.right != null)
                    stack.add(node.right);

                // Do the same thing to the left sub-tree first
                node = node.left;

            }

            if (stack.size() == 0)
                break;
            else
                node = stack.remove(stack.size() - 1); // Do the same thing to the right sub-tree
        
        }

        return resultList;

    }
}