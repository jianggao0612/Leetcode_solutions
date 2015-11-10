/**
 * Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    	if (l1 == null)
    		return l2;
    	if (l2 == null)
    		return l1;

    	ListNode head = null;
    	ListNode curr = null;
    	ListNode nodeOne;
    	ListNode nodeTwo;

    	// deal with the head for the merged list
    	if (l1.val < l2.val) {

    		head = l1;
    		nodeOne = l1.next;
    		nodeTwo = l2;

    	} else {

    		head = l2;
    		nodeOne = l1;
    		nodeTwo = l2.next;
    	}
    	
    	curr = head;

    	while ((nodeOne != null) && (nodeTwo != null)) {

    		// link nodes to the merged list with the correct order
    		if (nodeOne.val < nodeTwo.val) {
    			curr.next = nodeOne;
    			nodeOne = nodeOne.next;
    		} else {
    			curr.next = nodeTwo;
    			nodeTwo = nodeTwo.next;
    		}

    		curr = curr.next;
    	}

    	// deal with the tail nodes
    	if (nodeOne == null) {
    		curr.next = nodeTwo;
    	} 

    	if (nodeTwo == null) {
    		curr.next = nodeOne;
    	}

    	return head;
    	
        
    }
}