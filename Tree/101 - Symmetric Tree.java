/**
 * Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
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
    public boolean isSymmetric(TreeNode root) {
        ArrayList<TreeNode> leftList = new ArrayList<TreeNode>();
        ArrayList<TreeNode> rightList = new ArrayList<TreeNode>();
        ArrayList<TreeNode> leftFinished = new ArrayList<TreeNode>();
        ArrayList<TreeNode> rightFinished = new ArrayList<TreeNode>();

        TreeNode leftNode = null;
        TreeNode rightNode = null;

        if (root == null)
        	return true;

        if ((root.left == null) && (root.right == null)) 
        	return true;

        if (((root.left == null) && (root.right != null)) || ((root.left != null) && (root.right == null)))
        	return false;

       	leftList.add(root.left);
       	rightList.add(root.right);

        while ((!leftList.isEmpty()) && (!rightList.isEmpty())) {
        	leftNode = leftList.get(leftList.size() - 1);
        	rightNode = rightList.get(rightList.size() - 1);

        	if ((leftNode.left != null) && (rightNode.right != null) && (!leftFinished.contains(leftNode)) && (!rightFinished.contains(rightNode))) {
        		if (leftNode.left.val != rightNode.right.val)
        			return false;
        		else {
        			leftList.add(leftNode);
        			rightList.add(rightNode);
        			leftNode = leftNode.left;
        			rightNode = rightNode.right;
        		}
        	} else if ((leftNode.right != null) && (rightNode.left != null) && (!leftFinished.contains(leftNode)) && (!rightFinished.contains(rightNode))) {
        		if (leftNode.right.val != rightNode.right.val)
        			return false;
        		else {
        			leftList.add(leftNode);
        			rightList.add(rightNode);
        			leftNode = leftNode.right;
        			rightNode = rightNode.left;
        		}
        	} else {
        		leftFinished.add(leftList.get(leftList.size() - 1));
        		rightFinished.add(rightList.get(rightList.size() - 1));

        		leftList.remove(leftList.size() - 1);
        		rightList.remove(rightList.size() - 1);
        	}
        }

        if ((leftList == null) && (rightList == null))
        	return true;
        else
        	return false;

    }

    }
}