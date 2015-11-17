/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Create a dummy head
// Use two pointers to iterate each linked list
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = null;
        
        ListNode curNode = dummyHead;
        ListNode tempNode = null;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tempNode = l1;
                l1 = l1.next;
                tempNode.next = null;
                curNode.next = tempNode;
            } else {
                tempNode = l2;
                l2 = l2.next;
                tempNode.next = null;
                curNode.next = tempNode;
            }
            curNode = curNode.next;
        }
        
        if(l1 == null) {
            curNode.next = l2;
        } else {
            curNode.next = l1;
        }
        return dummyHead.next;
    }
}
