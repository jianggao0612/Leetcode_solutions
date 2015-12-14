/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * A simple DFS solution
 */
public class Solution {
    ArrayList<String> result = new ArrayList<String>();
    ArrayList<TreeNode> path = new ArrayList<TreeNode>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root != null) {
            traverse(root);
        }
        return result;
    }
    
    private void traverse(TreeNode node) {
        path.add(node);
        
        if(node.left == null && node.right == null) {
            // print
            result.add(printPath());
        }
        if(node.left != null) {
            traverse(node.left);
        }
        if(node.right != null) {
            traverse(node.right);
        }
        
        path.remove(path.size() - 1);
    }
    
    private String printPath() {
        TreeNode root = path.get(0);
        StringBuilder str = new StringBuilder();
        str.append(root.val);
        
        for(int i = 1; i < path.size(); i++) {
            str.append("->" + path.get(i).val);
        }
        
        return str.toString();
    }
}