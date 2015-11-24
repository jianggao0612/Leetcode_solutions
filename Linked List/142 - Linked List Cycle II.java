/**
 * Linked List Cycle II
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list.
 * 
 * http://www.cnblogs.com/hiddenfox/p/3408931.html
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

    	if (head == null) {
    		return null;
    	} 
    	if (head.next == null) {
    		return null;
    	}

    	ListNode one = head.next;
    	ListNode two = head.next.next;

    	/*
    	 * Determine whether there is cycle and find the point of meet
    	 */
    	while (one != two) {
    		if ((one == null) || (two == null)) {
    			return null;
    		} else if (two.next == null) {
    			return null;
    		} else {
    			one = one.next;
    			two = two.next.next;
    		}
    	}

    	one = head;

    	while (one != two) {
    		one = one.next;
    		two = two.next;
    	}
        
        return one;
    }
}