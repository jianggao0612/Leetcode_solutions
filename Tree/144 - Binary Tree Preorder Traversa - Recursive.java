/**
 * Binary Tree Preorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.
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

    List<Integer> resultList = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {

        TreeNode node;

        if (root == null)
            return resultList;

        /*
         * Access the value of root first
         * Traverse the left sub-tree
         * Traverse the right sub-tree
         */
        resultList.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return resultList;

    }
}