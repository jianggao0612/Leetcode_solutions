/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Use two pointers and a dummy head to insert those nodes with smaller value to the front
public class Solution {
    public ListNode partition(ListNode head, int x) {
        
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode dummyHead = new ListNode(x-1);
        dummyHead.next = head;
        
        ListNode cur = dummyHead;
        ListNode post = cur;
        
        while(post.next != null) {
            if(post.next.val < x) {
                if(post == cur) {
                    post = post.next;
                    cur = cur.next;
                } else {
                    ListNode node = post.next;
                    post.next = post.next.next;
                    node.next = cur.next;
                    cur.next = node;
                    cur = node;
                }
            } else {
                post = post.next;
            }
        }
        return dummyHead.next;
    }
}
