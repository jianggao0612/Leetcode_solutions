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
        StringBuilder strBuilder = new StringBuilder();
        se(root, strBuilder);
        System.out.println(strBuilder.toString());
        return strBuilder.toString();
    }
    
    public void se(TreeNode node, StringBuilder strBuilder) {
        if(node == null) {
            strBuilder.append("null,");
            return;
        }
        
        strBuilder.append(node.val + ",");
        
        se(node.left, strBuilder);
        se(node.right, strBuilder);
    }

    class Pos {
        int index;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        Pos pos = new Pos();
        pos.index = 0;

        return de(vals, pos);
    }
    
    public TreeNode de(String[] vals, Pos pos) {
        if(vals.length == pos.index) {
            return null;
        }
        
        String valStr = vals[pos.index];
        pos.index++;
        if(valStr.equals("null")){
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(valStr));
        node.left = de(vals, pos);
        node.right = de(vals, pos);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
