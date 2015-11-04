/**
 * Validate Binary Search Tree
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *****************************************************************************************************
 * Use inorder traverse to do the validation
 *****************************************************************************************************
 *
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

    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode currentNode = root;
            TreeNode preNode = null;
            
            if (root == null)
                return true;
    
            while (true) {
                while (currentNode != null) {
    
                    stack.push(currentNode);
                    currentNode = currentNode.left;
    
                }
    
                if (stack.isEmpty())
                    break;
    
                currentNode = stack.pop();
    
                if (preNode != null && preNode.val >= currentNode.val) // note: when pre == null, do not compare
                    return false;
    
                preNode = currentNode;
                currentNode = currentNode.right;
    
    
            }
    
            return true;

    }
}