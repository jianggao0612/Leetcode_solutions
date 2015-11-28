// Use a count to record the difference
// If that number is not guaranteed in the array, we need to double check the number

public class Solution {
    public int majorityElement(int[] nums) {
        
        // if(nums.length < 1) {
        //     return null; // corner case
        // }
        
        int count = 0;
        int element = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                element = nums[i];
                count = 1;
            } else if(nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        
        return element;
    }
}
