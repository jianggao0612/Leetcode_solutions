/**
 * Using two pointers to go through all elements. Use the second pointer to point to last unique value
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        if(nums.length <= 1) {
            return nums.length;
        }
        
        j = i + 1;
        while( j < nums.length) {
            if(nums[j] != nums[i]) {
                nums[i+1] = nums[j];
                i++;
                j++;
            } else {
                j++;
            }
        }
        
        return i+1;
    }
}
