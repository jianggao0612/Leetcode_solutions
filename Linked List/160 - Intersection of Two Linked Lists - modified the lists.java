/**
 * Intersection of Two Linked Lists
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if ((headA == null) || (headB == null)) {
        	return null;
        }

        ListNode reversedA = reverse(headA);
        ListNode reversedB = reverse(headB);
        ListNode prev = reversedA;

        if (reversedA.val != reversedB.val) {
        	return null;
        }

        while ((reversedA != null) && (reversedB != null)) {

        	if (reversedA.val == reversedB.val) {

        		prev = reversedA;
        		reversedA = reversedA.next;
        		reversedB = reversedB.next;
        		continue;

        	} else {
        		return prev;
        	}
        }

        return prev;
        
    }

    /**
     * Helper function to reverse the list
     */
    public ListNode reverse(ListNode head) {

    	if (head == null) {
    		return head;
    	}

    	if (head.next == null) {
    		return head;
    	} 

    	ListNode prev = head;
    	ListNode curr = head.next;
    	ListNode next = curr.next;
    	prev.next = null;

    	while (curr.next != null) {
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    		next = curr.next;
    	}

    	curr.next = prev;

    	return curr;

    }

}