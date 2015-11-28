/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// No need to reverse list in this one, most significant bits are on the right side
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } 
        
        if(l2 == null) {
            return l1;
        }
        
        ListNode list = merge(l1, l2);
        return list;
    }
    
    public ListNode merge(ListNode reL1, ListNode reL2) {
        // choose either head to start
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = dummyHead;
        
        boolean overflow = false;
        while(reL1 != null && reL2 != null) {
            int sum = reL1.val + reL2.val;
            
            if(overflow == true) {
                sum = sum + 1;
            }
            
            if(sum > 9) {
                overflow = true;
                sum = sum - 10;
            } else {
                overflow = false;
            }
            
            ListNode node = new ListNode(sum);
            node.next = null;
            curNode.next = node;
            curNode = node;
            reL1 = reL1.next;
            reL2 = reL2.next;
        }
        
        ListNode tail = reL1==null?reL2:reL1;
        
        while(tail != null) {
            int sum = tail.val;
            if(overflow == true) {
                sum += 1;
                overflow = false;
            }
            
            if(sum > 9) {
                overflow = true;
                sum = sum - 10;
            } else {
                overflow = false;
            }
            
            ListNode node = new ListNode(sum);
            node.next = null;
            curNode.next = node;
            curNode = node;
            tail = tail.next;
        }
        
        if(overflow == true) {
            ListNode node = new ListNode(1);
            node.next = null;
            curNode.next = node;
            curNode = node;
        }
        
        return dummyHead.next;
    }
}
