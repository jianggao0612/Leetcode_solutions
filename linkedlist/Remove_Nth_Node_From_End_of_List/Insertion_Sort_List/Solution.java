/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Traver each node and simulate constructing a "new" linkedlist by inserting it.
// Needs to first assign head.next = null

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode cur = head.next;
        ListNode next = cur.next;
        head.next = null;
        
        while(cur != null) {
            next = cur.next;
            head = insertNode(cur, head);
            cur = next;
        }
        return head;
    }
    
    public ListNode insertNode(ListNode node, ListNode head) {
        if(head.val > node.val) {
            node.next = head;
            return node;
        }
        
        ListNode cur = head;
        
        while(cur.next != null && cur.next.val <= node.val) {
            cur = cur.next;
        }
        
        node.next = cur.next;
        cur.next = node;
    
        return head;
    }
}
