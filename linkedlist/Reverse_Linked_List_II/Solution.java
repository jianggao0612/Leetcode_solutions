// cut middle linked list and reverse it, connect tail 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int reverseCount = n - m;
        if(reverseCount == 0) {
            return head;
        }
        
        int step = 1;
        
        // DummyHead 
        ListNode dummyHead = new ListNode(0);
        ListNode start = dummyHead;
        ListNode end = dummyHead;
        dummyHead.next = head;
        
        while(step < m) {
            start = start.next;
            step++;
        }
        
        end = start;
        while(step <= n) {
            end = end.next;
            step++;
        }
        // System.out.println("start:"+start.val);
        // System.out.println("end:"+end.val);
        
        ListNode tailHead = end.next;
        ListNode middleHead = start.next;
        end.next = null;
        
        middleHead = reverse(middleHead, tailHead); // reverse middle part and connect tail
        start.next = middleHead;
        
        return dummyHead.next;
    }
    
    
    public ListNode reverse(ListNode head, ListNode tail) {
        if(head == null) {
            return tail;
        } 
        
        if(head.next == null) {
            head.next = tail;
            return head;
        }
        
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
        
        head.next = tail;
        return prev;
    }
}
