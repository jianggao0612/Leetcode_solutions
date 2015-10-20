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
    ArrayList<TreeNode> path = new ArrayList<TreeNode>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Traverse(root, p);
        System.out.println(path.size());
        if(path.size() <= 1 || path.get(path.size()-2).val != p.val) {
            return null;
        } else {
            return path.get(path.size()-1);
        }
    }
    
    public void Traverse(TreeNode root, TreeNode p) {
        if(root.left != null) {
            Traverse(root.left, p);
        }
        if(path.size() <= 1 || path.get(path.size()-1).val <= p.val)
            path.add(root);
        
        if(root.right != null ) {
            Traverse(root.right, p);
        }
    }
    
}
