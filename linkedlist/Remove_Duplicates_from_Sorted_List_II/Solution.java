/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


// A good strategy: using dummy head to deal with dea

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode helper = new ListNode(head.val+1); helper.next = head;
        ListNode slow = helper;
        ListNode fast = head;
        
        while(fast != null) {
            while(fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            
            if(slow.next == fast) {
                // no duplicate
                slow = fast;
                fast = fast.next;
            } else {
                slow.next = fast.next;
                fast = fast.next;
            }
        }
        
        
        
        return helper.next;
    }
}
