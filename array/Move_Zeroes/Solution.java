/**
 * Using two pointers. the first one alwasy point to next 0 that needs to be shifted back
 */

public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        // find first 0
        while(j < nums.length && nums[j] != 0) {
            j++;
        }
        
        for(i = j+1; i < nums.length; i++) {
            if(nums[i] == 0) {
                continue;
            } else {
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
        }
    }
}
