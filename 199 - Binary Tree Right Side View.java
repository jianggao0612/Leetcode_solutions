/**
 *
 * Binary Tree Right Side View
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * For example:
 * Given the following binary tree,
 *	   1            ---
 *	 /   \
 *	2     3         ---
 *	 \     \
 *	  5     4       ---
 *
 ************************************************************************************************************************************************
 * Use BFS, the right most node in each level can be seen
 ************************************************************************************************************************************************
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
    public List<Integer> rightSideView(TreeNode root) {

    	List<Integer> resultList = new ArrayList<Integer>();	
    	List<TreeNode> currentLevel = new ArrayList<TreeNode>();
    	TreeNode node;

    	if (root == null) 
    		return resultList;

    	currentLevel.add(root);

    	/*
    	 * For each level, get the right most val
    	 */
    	while (currentLevel.size() > 0) {

    		node = currentLevel.get(currentLevel.size() - 1); // the right most node
    		resultList.add(node.val); // store the right most value in the resultList

    		/*
    		 * Get the nodes in the next level from the left side
    		 */
    		List<TreeNode> nextLevel = new ArrayList<TreeNode>();
    		for (int i = 0; i < currentLevel.size(); i++) {

    			node = currentLevel.get(i);

    			if (node.left != null)
    				nextLevel.add(node.left);
    			if (node.right != null)
    				nextLevel.add(node.right);

    		}

    		currentLevel = nextLevel;
    	}

    	return resultList;
      
    }
}