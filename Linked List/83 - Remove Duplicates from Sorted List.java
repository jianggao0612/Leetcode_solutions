/**
 * Remove Duplicates from Sorted List
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once. 
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
    	if (head == null) {

    		return head;

    	}
    	if (head.next == null) {

    		return head;

    	}

    	ListNode prev = head;
    	ListNode curr = head;

    	// remove duplicates
    	while (curr.next != null) {

    		if (prev.val == curr.val) {

    			curr = curr.next;

    		} else {

    			prev.next = curr;
    			prev = curr;
    			curr = curr.next;
    		}
    	}

    	// deal with the last element
    	if (prev.val == curr.val) {

    		prev.next = null;

    	} else {

    		prev.next = curr;
    		curr.next = null;

    	}

    	return head;
        
    }
}