/**
 * Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Using DFS (currentPath and visited)
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        ArrayList<TreeNode> currentPath = new ArrayList<TreeNode>();
        ArrayList<TreeNode> finished = new ArrayList<TreeNode>();
        TreeNode node = root;
        int minLength = Integer.MAX_VALUE;

        // Corner Case
        if (root == null)
            return 0;

        // Corner case
        if (root.left == null && root.right == null)
            return 1;

        currentPath.add(root);

        // DFS find the shortest path
        while (currentPath.size() > 0) {
            // Get the top element of the stack (last element of the ArrayList)
            node = currentPath.get(currentPath.size() - 1);

            // Determine whether go further left
            if ((node.left != null) && (!finished.contains(node.left))) {

                currentPath.add(node.left);

            } else if ((node.right != null) && (!finished.contains(node.right))) { // determine whether go further right

                currentPath.add(node.right);

            } else if ((node.left == null) && (node.right == null)) { // find leaf node and compare the length of the path

                if (currentPath.size() < minLength)
                    minLength = currentPath.size();
                
                node = currentPath.get(currentPath.size() - 1);
                finished.add(node);
                currentPath.remove(currentPath.size() - 1);

            } else { // finish a node

                node = currentPath.get(currentPath.size() - 1);
                finished.add(node);
                currentPath.remove(currentPath.size() - 1);

            }
        }

        return minLength;

    }
}