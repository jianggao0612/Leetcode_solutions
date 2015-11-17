/**
 * Linked List Cycle
 *
 * Given a linked list, determine if it has a cycle in it.
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
    public boolean hasCycle(ListNode head) {
        // corner case
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        if (head.next.next == null) {
            return false;
        }
        
        ListNode one = head.next; // one-step pointer
        ListNode two = head.next.next; // two-step pointer
        
        // if there is cycle, the two pointer should meet at some point
        while (one != two) {
            // if there is null - no cycle
            if ((one == null) || (two == null))
                return false;
            if (two.next == null)
                return false;
            else {
                one = one.next;
                two = two.next.next;
            }
        }
        return true;
    }
}