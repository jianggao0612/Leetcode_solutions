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
    	if ((l1.next == null) && (l2.next == null)) {
    		if (l1.val > l2.val) {
    			l2.next = l1;
    			return l2;
    		} else {
    			l1.next = l2;
    			return l1;
    		}
    	}

		ListNode prevl1 = l1;
		ListNode currl1 = l1;
		ListNode currl2 = l2;
		ListNode nextl2 = l2.next;

		while ((currl1 != null) && (currl2.next != null) {

			if (currl1.val <= currl2.val) {
				prevl1 = currl1;
				currl1 = currl1.next;
				continue;
			}

			prevl1.next = currl2;
			currl2.next = currl1;
			currl2 = nextl2;
			nextl2 = currl2.next;
			prevl1 = prevl1.next;
		} 

		if (currl1 == null) {

			prevl1.next = currl2;

		}

		if (currl2.next == null) {
			if (currl2.val > currl1.val) {
				currl2.next = currl1.next;
				currl1.next = currl2;
			} else {
				prevl1.next = currl2;
				currl2.next = currl1;
			}
		}

		return l1;
    	
        
    }
}