/**
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
        ListNode fast = head;
        ListNode slow = head;
        
        if(head == null) {
            return false;
        }
        
        int i = 1;
        while(true) {
            if(fast.next == null || fast.next.next == null) {
                return false;
            }
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow) {
                return true;
            }
        }
    }
}
