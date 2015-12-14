/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Traversing the tree, need to continue to the root since deeper means smaller or bigger towards mid
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int closestVal = -1;
        double minDist = -1;
        
        while(root != null) {
            double dist = Math.abs(root.val - target);
            if(minDist == -1) {
                minDist = dist;
                closestVal = root.val;
            }
            
            if(dist < minDist) {
                minDist = dist;
                closestVal = root.val;
            }
            
            root = root.val > target? root.left:root.right;
        }
        
        return closestVal;
    }
}