/**
 * Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Recursive Implement
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

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null)
            return resultList;

        inorderTraversal(root.left);
        resultList.add(root.val);
        inorderTraversal(root.right);

        return resultList;

    }
}
