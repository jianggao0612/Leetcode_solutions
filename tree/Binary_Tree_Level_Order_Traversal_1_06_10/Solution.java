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
    ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return result;
        
        ArrayList<TreeNode> curLv = new ArrayList<TreeNode>();
        ArrayList<TreeNode> nextLv = new ArrayList<TreeNode>();
        
        curLv.add(root);
        while(curLv.size()> 0) {
            TreeNode curNode = null;
            ArrayList<Integer> curLvVal = new ArrayList<Integer>();
            for(int i = 0; i < curLv.size(); i++) {
                curNode = curLv.get(i);
                curLvVal.add(curNode.val);
                if(curNode.left != null)
                    nextLv.add(curNode.left);
                if(curNode.right !=null)
                    nextLv.add(curNode.right);
            }
            result.add(curLvVal);
            curLv = nextLv;
            nextLv = new ArrayList<TreeNode>();
        }
        return result;
    }
}
