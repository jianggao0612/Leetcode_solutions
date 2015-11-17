/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode cur = head;
        ListNode next = head.next;
        while(next != null) {
            if(next.val != cur.val) {
                cur.next = next;
                cur = next;
            }
            next = next.next;
        }
        cur.next = next;
        
        return head;
    }
}
