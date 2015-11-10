/**
 * Remove Nth Node From End of List
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

    	// corner case
    	if (head == null) {
    		return head;
    	}
    	if (n == 0) {
    		return head;
    	}
    	
    	ListNode curr = head;
    	ListNode prev = head;
    	int count = 0;

    	// set the distance of curr and prev as n - 1 to find the previous node of the node to be removed
    	while ((count < n) && (curr.next != null)) {

    		curr = curr.next;
    		count++;

    	} 

    	// if n is larger or equal the length (equal the length - remove the first)
    	if (curr.next == null) {

    		if (count + 1 == n) {
    			head = head.next;
    			return head;
    		} 

    	}

    	// move the prev pointer to find the node previous to the node to be removed
		while (curr.next != null) {
    		curr = curr.next;
    		prev = prev.next;
    	}
        
    	prev.next = prev.next.next; // remove the node
    	
    	return head;	
    }
        
    }
}