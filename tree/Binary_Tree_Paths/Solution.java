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
    
    ArrayList<TreeNode> visited = new ArrayList<TreeNode>();
    ArrayList<TreeNode> path = new ArrayList<TreeNode>();
    ArrayList<String> paths = new ArrayList<String>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return paths; 
        }
        
        path.add(root);
        
        while(path.size() > 0) {
            TreeNode curNode = path.get(path.size()-1);
            if(curNode.left == null && curNode.right == null) {
                paths.add(pathToString());
                visited.add(path.remove(path.size()-1));
            } else if( curNode.left != null && visited.contains(curNode.left) == false) {
                path.add(curNode.left);
            } else if(curNode.right != null && visited.contains(curNode.right) == false) {
                path.add(curNode.right);
            } else {
                visited.add(path.remove(path.size()-1));
            }
        }
        return paths;
    }
    
    public String pathToString() {
        String pathString = ""+path.get(0).val;
        for(int i = 1; i < path.size(); i++) {
            pathString = pathString + "->"+path.get(i).val;
        }
        return pathString;
    }
    
    
}
