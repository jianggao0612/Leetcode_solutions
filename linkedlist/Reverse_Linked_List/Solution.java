/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * In place, be careful about the first element (needs to set up next to null)
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode post = cur.next;
        
        while(cur != null) {
            cur.next = prev;
            prev = cur;
            cur = post;
            if(post != null) {
                post = post.next;
            }
        }
        head.next = null;
        return prev;
    }
}
