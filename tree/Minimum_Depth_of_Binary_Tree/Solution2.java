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
    int minimalDepth = -1;
    
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }    
        
        ArrayList<TreeNode> path = new ArrayList<TreeNode>();
        ArrayList<TreeNode> visited = new ArrayList<TreeNode>();
        
        path.add(root);
        
        while(path.size() > 0) {
            TreeNode node = path.get(path.size()-1);
            
            if(node.left == null && node.right == null) {
                if(minimalDepth == -1 || path.size() < minimalDepth) {
                    minimalDepth = path.size();
                }
                visited.add(path.remove(path.size()-1));
            } else if (path.size() < minimalDepth || minimalDepth == -1) {
                if(node.left != null && !visited.contains(node.left)) {
                    path.add(node.left);
                } else if(node.right != null && !visited.contains(node.right)){
                    path.add(node.right);
                } else {
                    visited.add(path.remove(path.size()-1));
                }
            } else {
                visited.add(path.remove(path.size()-1));
            }
        }
        return minimalDepth;
    }
}
