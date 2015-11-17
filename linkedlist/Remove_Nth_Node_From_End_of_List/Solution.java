/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = head;
        ListNode cur = head;
        
        for(int i = 1; i <= n; i++) {
            tail = tail.next;
        }
        
        if(tail == null) {
                return head.next;
        }
        
        while(tail != null && tail.next != null) {
            cur = cur.next;
            tail = tail.next;
        }
        
        cur.next = cur.next.next;
        return head;
    }
}
