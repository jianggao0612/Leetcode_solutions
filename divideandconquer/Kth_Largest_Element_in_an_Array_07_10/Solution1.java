import java.util.PriorityQueue;

public class Solution {
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
    
    public int findKthLargest(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        
        while(k>1) {
            queue.poll();
            k--;
        }
        return queue.poll();
    }
}
