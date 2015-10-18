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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> nodeOnePath = new ArrayList<TreeNode>();
        ArrayList<TreeNode> nodeTwoPath = new ArrayList<TreeNode>();
        
        // empty tree case
        if ((root == null) || (p == null) || (q == null))
            return null;

        // p or q is the root of the tree
        if ((root.val == p.val) || (root.val == q.val))
            return root;

        nodeOnePath = findPath(root, p);
        nodeTwoPath = findPath(root, q);

        // if cannot find p or q in the tree
        if ((nodeOnePath.size() == 0) || (nodeTwoPath.size() == 0))
            return null;

        // go over both the path and find the first different node in the paths
        int i;
        for (i = 0; i < nodeOnePath.size() && i < nodeTwoPath.size(); i++) {
            if (nodeOnePath.get(i) != nodeTwoPath.get(i))
                break;
        }

        // return the last same node in the paths
        return nodeOnePath.get(i - 1);

    }

    /**
     * Find the path to a given node in the tree
     */
    public ArrayList<TreeNode> findPath(TreeNode root, TreeNode p) {
        ArrayList<TreeNode> currentPath = new ArrayList<TreeNode>();
        ArrayList<TreeNode> visitedNode = new ArrayList<TreeNode>();
        TreeNode searchNode;

        // corner case
        if ((root == null) || (p == null))
            return null;

        // p == root
        if (root.val == p.val) {
            currentPath.add(root);
            return currentPath;
        } 

        // DFS
        currentPath.add(root);
        while (currentPath.size() > 0) {
            searchNode = currentPath.get(currentPath.size() - 1);
            if (searchNode.val == p.val) {
                currentPath.add(searchNode);
                return currentPath;
            } else {
                if ((searchNode.left != null) && (!visitedNode.contains(searchNode))) {
                    currentPath.add(searchNode.left);
                } else if ((searchNode.right != null) && (!visitedNode.contains(searchNode))) {
                    currentPath.add(searchNode.right);
                } else {
                    visitedNode.add(currentPath.get(currentPath.size() - 1));
                    currentPath.remove(currentPath.size() - 1);
                }
            }
        }

        return currentPath;
    }
}