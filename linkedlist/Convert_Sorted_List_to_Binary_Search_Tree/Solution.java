/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// Using inorder traversal to build the tree
// Important: split linked list into half and recursively build left subtree and right subtree

public class Solution {
    
    ListNode node;
    
    public TreeNode sortedListToBST(ListNode head) {
        
        if(head == null) {
            return null;
        }
        
        if(head.next == null) {
            return new TreeNode(head.val);
        }
        
        node = head;
        int size = getSize(head);
        
        return buildTree(0, size-1);
    }
    
    
    public TreeNode buildTree(int start, int end) {
        if(start > end) {
            return null;
        }
        
        int mid = (start + end) / 2;
        
        // Build left subtree
        TreeNode leftChild = buildTree(start, mid-1);
        
        // Build mid
        TreeNode midNode = new TreeNode(node.val);
        node = node.next;
        
        // Build right subtree
        TreeNode rightChild = buildTree(mid+1, end);
        
        midNode.left = leftChild;
        midNode.right = rightChild;
        
        return midNode;
    }
    
    
    public int getSize(ListNode head) {
        int size = 0 ;
        while(head != null) {
            size++;
            head = head.next;
        }
        
        return size;
    }
    
}
