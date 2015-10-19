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
    ArrayList<TreeNode> nodeCurLv = new ArrayList<TreeNode>();
    ArrayList<TreeNode> nodeNextLv = new ArrayList<TreeNode>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // Empty input
        if(root == null)
            return result;
            
        nodeCurLv.add(root);
        
        while(nodeCurLv.size() > 0){
            ArrayList<Integer> curLvList = new ArrayList<Integer>();
            for(int i = 0; i < nodeCurLv.size(); i++) {
                TreeNode curNode = nodeCurLv.get(i);
                curLvList.add(curNode.val);
                if(curNode.left != null)
                    nodeNextLv.add(curNode.left);
                if(curNode.right!=null)
                    nodeNextLv.add(curNode.right);
            }
            
            result.add(0,curLvList);
            nodeCurLv = nodeNextLv;
            nodeNextLv = new ArrayList<TreeNode>();
        }
        return result;
    }
}
