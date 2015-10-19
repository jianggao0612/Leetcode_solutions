/**
 * Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
 *
 * DFS - Need optimization
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
    public List<String> binaryTreePaths(TreeNode root) {

    	List<String> resultList = new ArrayList<String>();
    	ArrayList<TreeNode> currentPath = new ArrayList<TreeNode>();
    	ArrayList<TreeNode> finished = new ArrayList<TreeNode>();
    	TreeNode node = root;

    	// Corner Case
    	if (root == null)
    		return resultList;

    	// Corner Case - notice the way to convert int to string
    	if ((root.left == null) && (root.right == null)) {

    		resultList.add("" + root.val);
    		return resultList;
    	
    	}

    	currentPath.add(root);

    	while (currentPath.size() > 0) {

    		String currentPathStr = "";
    		node = currentPath.get(currentPath.size() - 1);

    		if ((node.left != null) && (!finished.contains(node.left))) {

    			currentPath.add(node.left);

    		} else if ((node.right != null) && (!finished.contains(node.right))) {

    			currentPath.add(node.right);

    		} else if ((node.left == null) && (node.right == null)) {

    			for (int i = 0; i < currentPath.size() - 1; i++) {

    				currentPathStr += currentPath.get(i).val + "->";

    			}
    			currentPathStr += currentPath.get(currentPath.size() - 1).val;
    			resultList.add(currentPathStr);

    			node = currentPath.remove(currentPath.size() - 1);
    			finished.add(node);
    		
    		} else {

    			node = currentPath.remove(currentPath.size() - 1);
    			finished.add(node);

    		}

    	}

    	return resultList;
        
    }
}