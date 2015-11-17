/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    
    public ListNode mergeSort(ListNode head) {
        // Length = 0 or Length = 1
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = null;
        
        // Length = 2
        if(head.next.next == null) {
            if(head.next.val < head.val) {
                newHead = head.next;
                head.next = null;
                newHead.next = head;
                return newHead;
            } else {
                return head;
            }
        }
        
        
        ListNode mid = findMid(head); //System.out.println("mid:"+mid.val);
        ListNode secondHalf = mid.next;
        mid.next = null; 
        
        ListNode leftHead = mergeSort(head);
        ListNode rightHead = mergeSort(secondHalf);
        
        //printList(leftHead);
        //printList(rightHead);
        return merge(leftHead, rightHead);
    }
    
    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = null;
        
        if(node1.val < node2.val) {
            head = node1;
            node1 = node1.next;
        } else {
            head = node2;
            node2 = node2.next;
        }
        
        ListNode cur = head;
        
        while(node1 != null && node2 != null) {
            ListNode next = null;
            if(node1.val < node2.val) {
                next = node1.next;
                node1.next = null;
                cur.next = node1;
                cur = cur.next;
                node1 = next;
            } else {
                next = node2.next;
                node2.next = null;
                cur.next = node2;
                cur = cur.next;
                node2 = next;
            }
        }
        
        if(node1 == null) {
            cur.next = node2;
        } else {
            cur.next = node1;
        }
        return head;
    }
    
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    // Helper function
    public void printList(ListNode head) {
        if(head == null) {
            System.out.println("null");
        }  
        System.out.print(head.val);
        head = head.next;
        while(head != null) {
            System.out.print("->"+head.val);
            head = head.next;
        }
        
        System.out.println();
    }
}
