/**
 * Count Univalue Subtrees
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * Recursive implementation
 *
 ************************************* Idea *****************************************
 * For each root, if no left or right child, sum + 1
 * If left but not right, if left.val == root.val, sum + 1
 * If right but not left, if right.val == root.val, sum + 1
 * NOTICE: Each recursion count the sum of the current level, so there is no need to sum up the child's count in the root level computation (Figure out the recursive process)
 * NOTICE!!!!: The shortout of if-statement - use flags
 ************************************************************************************
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

    int sum = 0;

    public int countUnivalSubtrees(TreeNode root) {

        if (root == null)
            return 0;

        isUnivalSubtree(root);

        return sum;
        
    }

    public boolean isUnivalSubtree (TreeNode root) {
        
        boolean leftFlag, rightFlag;

        if ((root.left == null) && (root.right == null)) {
            sum += 1;
            return true;
        }

        if ((root.left != null) && (root.right == null)) {
            
            leftFlag = isUnivalSubtree(root.left);
            
            if ((root.val == root.left.val) && leftFlag) {
                sum += 1;
                return true;
            } else {
                return false;
            }

        } else if ((root.left == null) && (root.right != null)) {

            rightFlag = isUnivalSubtree(root.right);
            
            if ((root.val == root.right.val) && rightFlag) {
                sum += 1;
                return true;
            } else {
                return false;
            }

        } else {
            
            leftFlag = isUnivalSubtree(root.left);
            rightFlag = isUnivalSubtree(root.right);
            
            if (leftFlag && rightFlag && (root.val == root.left.val) && (root.val == root.right.val)) {
                sum += 1;
                return true;
            } else {
                return false;
            }

        }
    }
}