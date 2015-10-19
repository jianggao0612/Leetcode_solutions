/**
 * Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * Using BFS to deal with every level
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
    public List<List<Integer>> levelOrder (TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        // Corner case
        if (root == null)
            return resultList;

        levelTraverse(root, 0, resultList);
        return resultList;

    }

    /**
     * Help function to traverse every level
     */
    public void levelTraverse (TreeNode node, int level, List<List<Integer>> resultList) {

        /*
         * Determine whether the current level is visited
         * If not, create a new list for the current level
         * If so, add the node value in the current list
         */
        if (resultList.size() <= level) {
            List<Integer> currentVal = new ArrayList<Integer>();
            currentVal.add(node.val);
            resultList.add(currentVal);
        } else {
            resultList.get(level).add(node.val);
        }

        /**
         * Recursively Traverse level by level
         */
        if (node.left != null)
            levelTraverse(node.left, level + 1, resultList);
        if (node.right != null) 
            levelTraverse(node.right, level + 1, resultList);
    } 
}