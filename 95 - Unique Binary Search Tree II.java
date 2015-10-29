/**
 *
 * Unique Binary Search Trees II
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 *******************************************************************************************************************
 * The idea is similar to Unique Binary Search Tree I, looking at the left sub-tree and right sub-tree seperately
 * Loop to set every node as the root node and then recursively generate all its left sub-tree and right sub-tree
 * Combine every possible left sub-tree and right sub-tree to generete a BST
 *******************************************************************************************************************
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

	// TODO: use dynamic programming
    public List<TreeNode> generateTrees(int n) {
        
        return generateTreesHelper(1, n);

    }

    public List<TreeNode> generateTreesHelper(int start, int end) {

    	List<TreeNode> resultList = new ArrayList<TreeNode>();

    	if (start > end) {
    		resultList.add(null);
    		return resultList;
    	}
    	
    	/*
    	 * Not sure whether they are needed
    	 */
    	if (start == end) {
    	    TreeNode node = new TreeNode(start);
    	    resultList.add(node);
    	    return resultList;
    	}

    	for (int i = start; i <= end; i++) {

    		List<TreeNode> leftList = generateTreesHelper(start, i - 1); // recursively generate every possible left sub-tree
    		List<TreeNode> rightList = generateTreesHelper(i + 1, end); // recursively generate every possible right sub-tree
 			
 			/*
 			 * Combine left and right sub-trees
 			 */
    		for (int j = 0; j < leftList.size(); j++) {
    			for (int k = 0; k < rightList.size(); k++) {
    				TreeNode node = new TreeNode(i);
    				node.left = leftList.get(j);
    				node.right = rightList.get(k);
    				resultList.add(node);
    			}
    		}

    	}

    	return resultList;

    }
}