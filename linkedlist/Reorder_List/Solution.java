// Divide original linkedlist into 2, reverse second half, combine two at the end

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        ListNode mid = findMid(head);
        ListNode secStart = mid.next;
        
        mid.next = null;
        
        ListNode secHead = reverse(secStart);
        
        merge(head, secHead);
    }
    
    
    public ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode post = null;
        
        head.next = null;
        
        while(cur != null) {
            post = cur.next;
            cur.next = prev;
            prev = cur;
            cur = post;
        }
        
        return prev;
    }
    
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = dummyHead;
        
        while(head1 != null && head2 != null) {
            ListNode node1 = head1;
            ListNode node2 = head2;
            head1 = head1.next;
            head2 = head2.next;
            
            curNode.next = node1;
            node1.next = node2;
            curNode = node2;
        }
        
        if(head1 == null) {
            curNode.next = head2;
        } else {
            curNode.next = head1;
        }
        
        return dummyHead.next;
    }
}
