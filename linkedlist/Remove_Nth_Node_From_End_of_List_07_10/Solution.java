/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    // n is always valid
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode leader = head;
        ListNode curNode = head;
        
        if(n == 1 && head.next == null)
            return null;
            
        for(int i = 0; i < n; i++) {
            leader = leader.next;
        }

        while(leader != null && leader.next != null) {
            leader = leader.next;
            curNode = curNode.next;
        }
        
        // Check if head
        if(leader == null)
            return head.next;
        else {
            curNode.next = curNode.next.next;
        }
        return head;
    }
}
