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
    ArrayList<String> paths = new ArrayList<String>();
    ArrayList<TreeNode> path = new ArrayList<TreeNode>();
    ArrayList<TreeNode> visited = new ArrayList<TreeNode>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return paths;
        }
        path.add(root);
        traverse(root);
        return paths;
    }
    
    public void traverse(TreeNode node) {
        if(node.left == null && node.right == null) {
            paths.add(pathToString());
            visited.add(path.remove(path.size()-1));
            return;
        } 
        if(node.left != null || node.right != null) {
            if(node.left != null && !visited.contains(node.left)) {
                path.add(node.left);
                traverse(node.left);
            }
            if(node.right != null && !visited.contains(node.right)) {
                path.add(node.right);
                traverse(node.right);
            } 
            visited.add(path.remove(path.size()-1));
        } else {
            visited.add(path.remove(path.size()-1));
        }
    }
    
    public String pathToString() {
        String pathString = "" + path.get(0).val;
        for(int i = 1; i < path.size(); i++) {
            pathString += "->"+path.get(i).val;
        }
        return pathString;
    }
}
