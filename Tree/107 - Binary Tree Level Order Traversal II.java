/**
 * Binary Tree Level Order Traversal II
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level). Bottom - top
 *
 * Using BFS to deal with every level
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> tempList = new ArrayList<List<Integer>>();
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        ArrayList<TreeNode> currentLevel = new ArrayList<TreeNode>();
        ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();

        TreeNode node = root;

        if (root == null)
            return resultList;

        currentLevel.add(root);

        while (currentLevel.size() > 0) {
        	/*
        	 * Create an empty list for the loop of every level
        	 */
            ArrayList<Integer> currentVal = new ArrayList<Integer>();
            nextLevel = new ArrayList<TreeNode>();
            
            while (currentLevel.size() > 0) {
            	// Start from the first node in current level to get its child in next level
                node = currentLevel.get(0);
                currentLevel.remove(0);
                currentVal.add(node.val); // store the value of the node in the current level

                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }

            }

            tempList.add(currentVal);
            // Go to the next level
            currentLevel = nextLevel;

        }

        // Reverse the list to get the result list
        for (int i = tempList.size() - 1; i >= 0; i--)
        	resultList.add(tempList.get(i));

        return resultList;

    }
}