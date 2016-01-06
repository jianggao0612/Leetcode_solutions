/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public boolean isSameTree(TreeNode p, TreeNode q) {
    TreeNode nodeOne = p;
    TreeNode nodeTwo = q;
    Stack<TreeNode> stackOne = new Stack<TreeNode>();
    Stack<TreeNode> stackTwo = new Stack<TreeNode>();

    // deal with empty tree
    if ((p == null) && (q == null)) {
    	return true;
    } else if ((p == null) || (q == null)) {
    	return false;
    }

    // use preorder traverse to determine
    while (true) {
    	while ((nodeOne != null) && (nodeTwo != null)) {
    		if (nodeOne.val != nodeTwo.val) {
    			return false;
    		} else {
    			if ((nodeOne.right != null) && (nodeTwo.right != null)) {
    				stackOne.push(nodeOne.right);
    				stackTwo.push(nodeTwo.right);
    			} else if ((nodeOne.right != null) || (nodeTwo.right != null)) { // one has right child while the other not
    				return false;
    			}
    			nodeOne = nodeOne.left;
    			nodeTwo = nodeTwo.left;
    		}
    	}

    	// NOTICE: easy to be wrong about the logic here! - deal with the left child
    	if (((nodeOne == null) && (nodeTwo != null)) || ((nodeOne != null) && (nodeTwo == null)))
    	    return false;

    	if (stackOne.isEmpty() || stackTwo.isEmpty())
    		return true;
    	nodeOne = stackOne.pop();
    	nodeTwo = stackTwo.pop();

    }
}
