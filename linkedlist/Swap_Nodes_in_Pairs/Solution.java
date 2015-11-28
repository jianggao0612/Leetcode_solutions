// Using three pointers, one for last head and other two to find pairs

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode cur = head;
        ListNode next = cur.next;
        ListNode prev = null;
        ListNode dummyHead = new ListNode(0);
        prev = dummyHead;
        
        dummyHead.next = head;
        while(cur != null) {
            next = cur.next;
            if(next == null) {
                break; // only one left
            }
            cur.next = next.next;
            next.next = cur;
            prev.next = next;
            prev = cur;
            cur = prev.next;
        }
        
        return dummyHead.next;
    }
}
