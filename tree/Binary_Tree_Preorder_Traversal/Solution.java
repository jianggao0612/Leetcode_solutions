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
    Stack<TreeNode> stack = new Stack<TreeNode>();
    ArrayList<TreeNode> visited = new ArrayList<TreeNode>();
    
    ArrayList<Integer> ans = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return ans;
        }
        stack.push(root);
        while(stack.isEmpty() == false) {
            TreeNode node = stack.peek();
            if(visited.contains(node) == false) {
                visited.add(node);
                ans.add(node.val);
            }
            if(node.left != null && visited.contains(node.left) == false) {
                stack.push(node.left);
            } else if (node.right != null && visited.contains(node.right) == false) {
                stack.push(node.right);
            } else {
                stack.pop();
            }
        }
        return ans;
    }
}
