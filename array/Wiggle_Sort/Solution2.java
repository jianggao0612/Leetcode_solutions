/**
 *	This is a O(n) time and O(1) space solution. just need to make sure the relation between two slots is correct
 */

public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 0; i  < nums.length - 1; i++) {
            int temp = 0;
            if( (i % 2 == 0 && nums[i] > nums[i+1]) || (i % 2 == 1 && nums[i] < nums[i+1])) {
                temp = nums[i+1];
                nums[i+1] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
