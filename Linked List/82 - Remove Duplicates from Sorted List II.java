/**
 * Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {

    	// corner case
    	if ((head == null) || (head.next == null)) {
    		return head;
    	}
    	
    	ListNode prev = null;
    	ListNode curr = null;
    	boolean dup = false; // store whether there is duplicate - for the last duplicate elements in a sequence
		
		/*
		 * Find the first head that is not duplicate as its next
		 */
    	while ((head.next != null)) {
    		if (head.val == head.next.val) {
	    		head = head.next;
	    		dup = true;
	    		continue;
	    	}
	    	if (dup) {
    			head = head.next;
    			dup = false;
    		} else {
    			break;
    		}
    	}
    	
    	// deal with the last duplicate element in a sequence
    	if (dup) {
    	    head = head.next;
    	}
    	
    	// determine corner case again
		if ((head == null) || (head.next == null)) {
    		return head;
    	}

    	prev = head;
    	curr = head.next;
    	
    	dup = false;
    	while (curr.next != null) {
    		if (curr.val == curr.next.val) {
    			curr = curr.next;
    			dup = true;
    			continue;
    		}
    		if (dup) {
    			prev.next = curr.next;
    			curr = prev.next;
    			dup = false;
    		} else {
    			prev = curr;
    			curr = curr.next;
    		}
    		
    	}
    	
    	// deal with the last duplicate element in a sequence
    	if (dup) {
			prev.next = curr.next;
    	}

    	return head;
       
    }
}