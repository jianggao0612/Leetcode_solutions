/**
 * Remove Linked List Elements
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {

    	// corner case
    	if (head == null) {
    		return head;
    	}
    	if (head.next == null) {
    		if (head.val == val) {
    			return null;
    		} else {
    			return head;
    		}
    	}

    	// if the val appears at the beginning - easy to ignore!!
    	while ((head != null) && (head.val == val)) {

    		head = head.next;
    	}

    	if (head == null) {

    		return null;

    	} else {

    		ListNode prev = head;
	    	ListNode curr = head.next;
	        
	        while (curr != null) {

	        	if (curr.val != val) {

	        		prev = curr;
	        		curr = curr.next;
	        		continue;

	        	} else {

	        		prev.next = curr.next;
	        		curr = curr.next;

	        	}
	        	
	        }

    	}

        return head;

    }
}