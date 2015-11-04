/**
 * Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> resultList = new ArrayList<Integer>();
        ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
        TreeNode node = root;

        // Corner case
        if (root == null)
            return resultList;

        while (true) {

            /*
             * Traverse the left sub-tree first, put root in the stack
             */
            while (node != null) {

                stack.add(node);
                node = node.left;

            }

            if (stack.size() == 0)

                break;

            else {
                
                /*
                 * Access the root before the right sub-tree
                 * Traverse the right sub-tree in the same way
                 */
                node = stack.remove(stack.size() - 1);
                resultList.add(node.val);
                node = node.right;

            }
        }

        return resultList;
    }
}