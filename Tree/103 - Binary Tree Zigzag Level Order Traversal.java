/**
 * Binary Tree Zigzag Level Order Traversal
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * return its zigzag level order traversal as:
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // corner case
        if (root == null) {
            return result;
        }

        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        int count;
        int direction = 1;
        TreeNode node = root;

        queue.add(root);

        while (!queue.isEmpty()) {
            count = queue.size();
            ArrayList<Integer> list = new ArrayList<Integer>();

            for (int i = 0; i < count; i++) {
                if (queue.get(i).left != null) {
                    queue.add(queue.get(i).left);
                }

                if (queue.get(i).right != null) {
                    queue.add(queue.get(i).right);
                }
            }

            if (direction % 2 != 0) {
                for (int i = 0; i < count; i++) {
                    list.add(queue.remove(0).val);
                }
            } else {
                for (int i = count - 1; i >= 0; i--) {
                    list.add(queue.remove(i).val);
                }
            }

            direction++;
            if (!list.isEmpty()) {
                result.add(list);
            }
        }

        return result;

    }
}
