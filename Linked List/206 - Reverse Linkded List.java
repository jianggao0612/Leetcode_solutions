/**
 * Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        
        // corner case
        if (head == null) {
        	return null;
        }
        if (head.next == null) {
        	return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        prev.next = null; // set the tail pointer in the reversed list to null
        
        while (next != null) {

        	curr.next = prev;
        	prev = curr;
        	curr = next;
        	next = curr.next;

        }

        curr.next = prev; // deal with the last element
        return curr;

    }
}