/**
 * Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
 * such that adding up all the values along the path equals the given sum.
 *
 * Use DFS
 ********************** NOTICE: do the sum comparison only in leaf node (a little bit different from other DFS problem)****************
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
    public boolean hasPathSum(TreeNode root, int sum) {
        ArrayList<TreeNode> currentPath = new ArrayList<TreeNode>();
        ArrayList<TreeNode> finished = new ArrayList<TreeNode>();
        TreeNode node;
        int pathSum = 0;

        if (root == null) {
            return false;
        }

        if ((root.left == null) && (root.right == null) && (root.val == sum)) {
            return true;
        } 

        currentPath.add(root);
        pathSum += root.val;

        while (currentPath.size() > 0) {
            node = currentPath.get(currentPath.size() - 1);
        
            if ((node.left != null) && (!finished.contains(node.left))) {

                currentPath.add(node.left);
                pathSum += node.left.val;

            } else if ((node.right != null) && (!finished.contains(node.right))) {

                currentPath.add(node.right);
                pathSum += node.right.val;

            } else if ((node.left == null) && (node.right == null)) {

                if (pathSum == sum) {
                    return true;
                }

                node = currentPath.remove(currentPath.size() - 1);
                finished.add(node);
                pathSum -= node.val;

            } else {
                
                node = currentPath.remove(currentPath.size() - 1);
                finished.add(node);
                pathSum -= node.val;
                
            }

         }

         return false;
    }
}