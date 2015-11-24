/**
 * Sort List
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {

    	if ((head == null) || (head.next == null)) {
    		return head;
    	}

    	ListNode mid = findMiddle(head);
    	ListNode secondHalf = mid.next;
    	mid.next = null;

    	return mergeSort(sortList(head), sortList(secondHalf));
        
    }

    public ListNode mergeSort(ListNode one, ListNode two) {

    	if ((one == null) && (two == null)) {
    		return null;
    	}

    	if ((one == null) || (two == null)) {
    		return one == null ? two: one;
    	}

    	ListNode dummyHead = new ListNode(0);
    	dummyHead.next = null;

    	ListNode nodeOne = one;
    	ListNode nodeTwo = two;
    	ListNode curr = dummyHead;
    	
    	while ((nodeOne != null) && (nodeTwo != null)) {
    		if (nodeOne.val < nodeTwo.val) {
    			curr.next = nodeOne;
    			nodeOne = nodeOne.next;
    		} else {
    			curr.next = nodeTwo;
    			nodeTwo = nodeTwo;
    		}
    		curr = curr.next;
    	}

    	if (nodeOne != null) {
    		curr.next = nodeOne;
    	}

    	if (nodeTwo != null) {
    		curr.next = nodeTwo;
    	}

    	return dummyHead.next;

    }

    public ListNode findMiddle(ListNode head) {

    	if ((head == null) || (head.next == null)) {
    		return head;
    	}

    	ListNode slow = head;
    	ListNode fast = head;

    	while((fast.next != null) && (fast.next.next != null)) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}

    	return slow;
    }
}