/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

       // corner case
       if ((inorder == null) || (postorder == null)) {
           return null;
       }
       if ((inorder.length == 0) || (postorder.length == 0) || (inorder.length != postorder.length)) {
           return null;
       }

       // base case
       if (inorder.length == 1) {
           return new TreeNode(inorder[0]);
       }

       // recursive call
       return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);

   }

   public TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {

       // base case
       if (inStart == inEnd) {
           return new TreeNode(inorder[inStart]);
       }

       // root of the sub-tree
       TreeNode root = new TreeNode(postorder[postEnd]);
       int rootIndex = inStart;

       // find the root element in the inorder sequence
       while (inorder[rootIndex] != postorder[postEnd]) {
           rootIndex++;
       }

       // recursively get the right sub-tree
       if (rootIndex < inEnd) {
           root.right = buildTreeHelper(inorder, postorder, rootIndex + 1, inEnd, postEnd - (inEnd - rootIndex), postEnd - 1);
       }

       // recursively get the left sub-tree
       if (rootIndex > inStart) {
           root.left = buildTreeHelper(inorder, postorder, inStart, rootIndex - 1, postStart, postEnd - (inEnd - rootIndex) - 1);
       }

       return root;
   }
}
