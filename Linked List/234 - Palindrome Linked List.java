/**
 * Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        
        ListNode forePointer = head;
        ListNode afterPointer = head;
        
        // find the central position and get the second half
        while (forePointer != null) {
            
            if (forePointer.next == null){
                break;
            } else{
                forePointer = forePointer.next.next;
                afterPointer = afterPointer.next;
            }
            
        }
        
        // reverse the second half
        ListNode reversedHalf = reverse(afterPointer);
        
        // compare the first half and the second half
        while (reversedHalf != null) {

        	if (reversedHalf.val == head.val) {
        		reversedHalf = reversedHalf.next;
        		head = head.next;
        		continue;
        	} else {
        		return false;
        	}

        }

        return true;
        
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
}