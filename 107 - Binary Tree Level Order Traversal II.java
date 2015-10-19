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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        ArrayList<TreeNode> currentPath = new ArrayList<TreeNode>();
        ArrayList<TreeNode> visited = new ArrayList<TreeNode>();
        TreeNode node = root;

        if (root == null)
        	return null;

        currentPath.add(root);

        while (currentPath.size() > 0) {

        	node = currentPath.get(currentPath.size() - 1);
        	if(!resultList.get(currentPath.size() - 1).contains(node.val))
        		resultList.get(currentPath.size() - 1).add(node.val);

        	if ((node.left != null) && (!visited.contains(node))) {

        		currentPath.add(node.left);
        		if(!resultList.get(currentPath.size() - 1).contains(node.val))
        			resultList.get(currentPath.size() - 1).add(node.val);

        	} else if ((node.right != null) && (!visited.contains(node))) {

        		currentPath.add(node.right);
        		if(!resultList.get(currentPath.size() - 1).contains(node.val))
        			resultList.get(currentPath.size() - 1).add(node.val);

        	} else {

        		node = currentPath.get(currentPath.size() - 1);
        		visited.add(node);
        		currentPath.remove(currentPath.size() - 1);

        	}
        }

       	for(int i = 0, j = resultList.size() - 1; i < j; i++, j--) {
       		ArrayList<Integer> temp = new ArrayList<Integer>;

       		temp = resultList.get(i);
       		resultList.get(i) = resultList.get(j);
       		resultList.get(j) = temp;
       	}

       	return resultList;

    }
}