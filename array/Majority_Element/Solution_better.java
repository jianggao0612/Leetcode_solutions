/**
 * This method uses Moore Voting algorithm. Link:https://www.youtube.com/watch?v=zOyOwDEF1Rc
 */

public class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int candidate = nums[0];
        for(int i = 1; i < nums.length; i++) {
            
            if(count == 0) {
                candidate = nums[i];
                count = 1;
            } else {
                if(nums[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate; 
    }
}
