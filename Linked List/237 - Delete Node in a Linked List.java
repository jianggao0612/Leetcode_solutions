/**
 * Delete Node in a Linked List
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {

    	node.val = node.next.val;
        node.next = node.next.next;
        
    }
}