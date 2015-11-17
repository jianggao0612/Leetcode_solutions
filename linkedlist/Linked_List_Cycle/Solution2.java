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

// Reverse solution
// If we reverse it, it will eventually reach to the head
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        
        if(head.next == head || head.next.next == head) {
            return true;
        }
        
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode post = null;
        
        head.next = null;
        while(cur.next != null) {
            post = cur.next;
            if(post.next == head) {
                return true;
            }
            cur.next = prev;
            prev = cur;
            cur = post;
        }
        
        return false;
    }
}
