/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;

public class Solution {
    // Current path
    ArrayList<TreeNode> path = new ArrayList<TreeNode>();
    ArrayList<TreeNode> visitedNode = new ArrayList<TreeNode>();
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.val == sum && root.left == null && root.right == null)
            return true;
        return (root.left!=null && computePath(root.left, sum, root.val)) || (root.right!=null && computePath(root.right, sum, root.val));
        
    }
    
    public boolean computePath(TreeNode curNode, int target, int curSum) {
        if((curNode.val+curSum == target) && curNode.left == null && curNode.right == null) {
            return true;
        }
        
        // if(curNode.val+curSum > target) {
        //     return false;
        // }
        
        return ((curNode.left!=null && computePath(curNode.left, target, curSum+curNode.val))
        || (curNode.right!=null && computePath(curNode.right, target, curSum+curNode.val)));
    }
}
