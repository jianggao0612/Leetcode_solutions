/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String deString = "";
        if(root == null) {
            return deString;
        } else {
             deString = Integer.toString(root.val);
        }
        
        ArrayList<TreeNode> curLv = new ArrayList<TreeNode>();
        ArrayList<TreeNode> nextLv;
        
        curLv.add(root); // add first level
        boolean isLeaf = false;
        while(isLeaf == false) {
            nextLv = new ArrayList<TreeNode>();
            isLeaf = true;
            for(int i = 0; i < curLv.size(); i++) {
                TreeNode node = curLv.get(i);
                if(node != null) {
                    if(node.left != null) {
                        isLeaf = false;
                        deString += "," + node.left.val;
                        nextLv.add(node.left);
                    }
                    else {
                        deString += ",n";
                        nextLv.add(null);
                    }
                    if(node.right != null) { 
                        isLeaf = false;
                        deString += "," + node.right.val;
                        nextLv.add(node.right);
                    }
                    else {
                        deString += ",n";
                        nextLv.add(null);
                    }
                } 
            }
            curLv = nextLv;
        }
        // System.out.println(deString);
        return deString;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // System.out.println("deserialize");
        if(data.length() == 0) {
            return null;
        }
        
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        
        int i = 1;
        Queue<TreeNode> curLv = new LinkedList<TreeNode>();
        curLv.offer(root);
        while(curLv.size() > 0) {
            Queue<TreeNode> nextLv = new LinkedList<TreeNode>();
            TreeNode node;
            while(curLv.size() > 0) {
                node = curLv.poll();
                if(!vals[i].equals("n")) {
                    TreeNode leftChild = new TreeNode(Integer.valueOf(vals[i]));
                    node.left = leftChild;
                    nextLv.offer(leftChild);
                }
                else {
                    node.left = null;
                }
                i++;
                if(!vals[i].equals("n")) {
                    TreeNode righChild = new TreeNode(Integer.valueOf(vals[i]));
                    node.right = righChild;
                    nextLv.offer(righChild);
                }
                else {
                    node.right = null;
                }
                i++;
            }
            curLv = nextLv;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
