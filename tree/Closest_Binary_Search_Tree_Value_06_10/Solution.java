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
    public int closestValue(TreeNode root, double target) {
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>(); 
		nodes.add(root);
		double minOption = -1;
		TreeNode curNode = null;
		TreeNode minNode = null;
		
		while(nodes.size() > 0) {
			curNode = nodes.remove(0);
			double dis2parent = -1;
			double disLeft = -1;
			double disRight = -1;
			
			// Compute dis between parent and current node
			dis2parent = diff(curNode.val, target);
			
		    // Left child
			if(curNode.left != null) {
				disLeft = diff(curNode.left.val, target);
			}
			// Right child
			if(curNode.right != null) {
				disRight = diff(curNode.right.val, target);
			}
			
			minOption = minNodes(dis2parent, minOption);
			minOption = minNodes(disLeft, minOption);
			minOption = minNodes(disRight, minOption);
			
			if(minOption == dis2parent)
			    minNode = curNode;
			else if(minOption == disLeft)
			    minNode = curNode.left;
			else if(minOption == disRight)
			    minNode = curNode.right;
			
			if(target == curNode.val)
			    return curNode.val;
			else if(target > curNode.val && curNode.right != null)
			    nodes.add(curNode.right);
			else if(target < curNode.val && curNode.left !=null)
			    nodes.add(curNode.left);
		}
		return minNode.val;
    }

	public double diff(double v1, double v2) {
		return v1>v2?(v1-v2):(v2-v1);
	}
	
	public double minNodes(double v1, double v2) {
		if(v2 == -1) {
			return v1;
		} 
		if(v1 == -1) {
			return v2;
		}
		return v1<v2?v1:v2;	
	}
}

