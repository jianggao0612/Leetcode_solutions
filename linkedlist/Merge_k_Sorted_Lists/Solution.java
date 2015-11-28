// Use a priority queue to store front of each list
// Poll from queue and push next node into queue

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    static class NodeComparator implements Comparator<ListNode> {
        public int compare(ListNode one, ListNode two) {
			return one.val - two.val;
		}
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length == 0) {
            return null;
        }
        
        NodeComparator nodeComparator = new NodeComparator();
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, nodeComparator);
        
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null)
                queue.offer(lists[i]);
        }
        
        ListNode dummyHead = new ListNode(0); dummyHead.next = null;
        ListNode curNode = dummyHead;
        
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            curNode.next = node;
            curNode = node;
            if(node.next != null) {
                queue.offer(node.next);
            }
        }
        
        return dummyHead.next;
    }
}
