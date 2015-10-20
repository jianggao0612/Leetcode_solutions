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
    int count = 0;
    
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) {
            return 0;
        }
        traverse(root);
        return count;
    }
    
    public boolean traverse(TreeNode node) {
        System.out.println(node.val);
        if(node.left == null && node.right == null) {
            count++;
            return true; 
        } else if(node.left != null && node.right != null ) {
            boolean leftResult = traverse(node.left);
            boolean rightResult = traverse(node.right);
            if(leftResult == true && rightResult == true && node.val == node.left.val && node.val == node.right.val) {
                count++;
                return true;
            } else {
                return false;
            }
        }  else if(node.left != null) {
            if(traverse(node.left) == true && node.val == node.left.val) {
                count++;
                return true;
            } else {
                return false;
            }
        }  else {
            if(traverse(node.right) == true && node.val == node.right.val) {
                count++;
                return true;
            } else {
                return false;
            }
        }
    }
}
