// Cut the linkedlist with k nodes in the middle, reverse it, and finally concat with both side


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) {
            return head;
        }
        
        ListNode dummyHead = new ListNode(0); dummyHead.next = head;
        
        ListNode curHead = dummyHead;
        ListNode curSubHead = curHead.next;
        ListNode curSubTail = dummyHead;
        
        while(true) {
            
            curSubHead = curHead.next;
            curSubTail = curHead;
            
            // jump k nodes from current
            for(int i = 0; i < k; i++) {
                curSubTail = curSubTail.next;
                if(curSubTail == null) {
                    return dummyHead.next;
                }
            }
            
            ListNode nextHead = curSubTail.next;
            
            curSubTail.next = null;
            
            ListNode subNewHead = reverse(curSubHead); // reverse sub-linkedlist in the middle
            curHead.next = subNewHead; // concat front
            curSubHead.next = nextHead; // concat end
            
            curHead = curSubHead; // jump to new start
            
        }
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
}
