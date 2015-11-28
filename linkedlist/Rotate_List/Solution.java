// Cut list into two pieces and move the second piece to the front

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int size = getSize(head);
        if(size == 0 || k == 0) {
            return head;
        }
        
        k = k % size;
        
        if(head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        for(int i = 0; i < k; i++) {
            fast = fast.next;
        }
        
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
    
    
    public int getSize(ListNode head) {
        int size = 0;
        while(head != null) {
            size++;
            head = head.next;
        }
        
        return size;
    }
}
