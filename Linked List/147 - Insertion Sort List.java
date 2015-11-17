/**
 * Insertion Sort List
 * 
 * Sort a linked list using insertion sort.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        // corner case
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        
        ListNode newHead = new ListNode(head.val);
        // nodes for loop in the original linkedList
        ListNode curr = head.next;
        ListNode next;
        // nodes in new linkedList
        ListNode prev;
        ListNode search;
        
        while(curr != null) {
            
            next = curr.next;
            // addFirst
            if (curr.val < newHead.val) {
                
                curr.next = newHead;
                newHead = curr;
                
            } else {
                
                prev = newHead;
                search = newHead.next;
                while ((search != null) && (curr.val > search.val)) {
                    prev = search;
                    search = search.next;
                }
                prev.next = curr;
                curr.next = search;
            }
            
            curr = next;
        }
        
        return newHead;
        
    }
}