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
    ArrayList<TreeNode> curLv = new ArrayList<TreeNode>();
    ArrayList<TreeNode> nextLv = new ArrayList<TreeNode>();
    ArrayList<Integer> array = new ArrayList<Integer>();
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return array;
        }
        
        curLv.add(root);
        
        while(curLv.size() > 0) {
            // Get most right node val
            array.add(curLv.get(curLv.size()-1).val);
            
            // BFS
            TreeNode curNode = null;
            nextLv = new ArrayList<TreeNode>();
            for(int i = 0; i < curLv.size(); i++) {
                curNode = curLv.get(i);
                if(curNode.left != null) {
                    nextLv.add(curNode.left);
                }
                if(curNode.right != null) {
                    nextLv.add(curNode.right);
                }
            }
            
            curLv = nextLv;
        }
        
        return array;
    }
}
