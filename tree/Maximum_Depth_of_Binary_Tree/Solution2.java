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
    /**
     * Using a list to store the path
     * Whenever insert a new node, check current length
     * Using another list to store all visited node. 
     * A node would be considered visitid when both child(if exist) have been visited
     */
     
    public static ArrayList<TreeNode> curPath = new ArrayList<TreeNode>();
    public static ArrayList<TreeNode> visited = new ArrayList<TreeNode>();
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int maxDepth = 1;
        curPath.add(root);
        
        while(curPath.size() > 0) {
            TreeNode node = curPath.get(curPath.size()-1);
            if(node.left != null && !visited.contains(node.left)) {
                // check left node
                curPath.add(node.left);
                if(curPath.size() > maxDepth) {
                    maxDepth = curPath.size();
                }
            } else if(node.right != null && !visited.contains(node.right)) {
                // check right node
                curPath.add(node.right);
                if(curPath.size() > maxDepth) {
                    maxDepth = curPath.size();
                }
            } else {
                // put curNode to visited
                node = curPath.remove(curPath.size() - 1);
                visited.add(node);
            }
        }
        return maxDepth;
    }
}
