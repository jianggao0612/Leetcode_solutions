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
 ***************************************** Get the length solution ******************************
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
        
        // get the smaller length of the two list
        int lengthA = length(headA);
        int lengthB = length(headB);
        int minLength = Math.min(lengthA, lengthB);

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        // move the longer list to the same length of it with the shoreter list
        while (lengthA > minLength) {
        	nodeA = nodeA.next;
        	lengthA--;
        }

        while (lengthB > minLength) {
        	nodeB = nodeB.next;
        	lengthB--;
        }

        // find intersection node
        while (nodeA != null) {

        	if (nodeA.val == nodeB.val) {

        		return nodeA; // note that there is no cycle in the entire linked list

        	} else {

        		nodeA = nodeA.next;
        		nodeB = nodeB.next;

        	}
        }

        return null;
        
    }

    /**
     * Helper function to find the length of the list
     */ 
    public int length(ListNode head) {

    	if (head == null) {
    		return 0;
    	}

    	int length = 0;

    	while (head != null) {
    		length++;
    		head = head.next;
    	}

    	return length;
    }

}