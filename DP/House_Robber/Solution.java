/*
 * maxWith - max value with current element
 * maxWithout - max value without current element
 */
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        int maxWith = nums[0];
        int maxWithout = 0;
        
        for(int i = 1; i < nums.length; i++) {
            int temp = maxWith;
            maxWith = maxWithout + nums[i];
            maxWithout = Math.max(temp, maxWithout);
        }
        
        return Math.max(maxWith, maxWithout);
    }
}