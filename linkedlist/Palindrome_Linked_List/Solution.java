/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        
        int size = getSize(head);
        
        if(head.next.next == null) {
            if(head.val == head.next.val) {
                return true;
            } else {
                return false;
            }
        }
        
        ListNode left = head;
        ListNode right = null;
        
        for(int i = 1; i < size/2; i++) {
            left = left.next;
        }
        
        if(size % 2 == 0) {
            right = left.next;
        } else {
            right = left.next.next;
        }
        
        left.next = null;
        left = reverseLeft(head);
            
        while(left != null && right != null) {
            System.out.println("left:"+left);
            System.out.println("right:"+right);
            if(left.val != right.val) {
                return false;
            } else {
                left = left.next;
                right = right.next;
            }
        }
        
        return left == null && right == null;
        
    }
    
    
    public int getSize(ListNode head) {
        int size = 1;
        while(head.next != null) {
            size++;
            head = head.next;
        }
        
        return size;
    }
    
    public ListNode reverseLeft(ListNode head) {
        
        ListNode prev = null;
        ListNode cur = null;
        ListNode post = null;
        
        if(head.next == null) {
            return head;
        }
        
        prev = head;
        cur = head.next;
        
        head.next = null;
        do {
            post = cur.next;
            cur.next = prev;
            prev = cur;
            cur = post;
        }while(cur != null);
        
        return prev;
    }
    
}
