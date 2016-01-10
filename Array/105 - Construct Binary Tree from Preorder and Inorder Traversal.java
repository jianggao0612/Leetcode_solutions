/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // corner case
        if ((preorder == null) || (inorder == null)) {
            return null;
        }
        if ((preorder.length == 0) || (inorder.length == 0) || (preorder.length != inorder.length)) {
            return null;
        }

        // base case
        if ((preorder.length == 1)) {
            return new TreeNode(preorder[0]);
        }

        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length  - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {

        // base case
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // root of the sub-tree
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = inStart;

        // find the root element in the inorder sequence
        while (inorder[rootIndex] != preorder[preStart]) {
            rootIndex++;
        }

        // recursively generate the left sub-tree
        if (rootIndex > inStart) {
            root.left = buildTreeHelper(preorder, inorder, preStart + 1, preStart + (rootIndex - inStart),
                                        inStart, rootIndex - 1);
        }

        // recursively generate the right sub-tree
        if (rootIndex < inEnd) {
            root.right = buildTreeHelper(preorder, inorder, preStart + (rootIndex - inStart) + 1, preEnd, rootIndex + 1, inEnd);
        }

        return root;
    }
}
