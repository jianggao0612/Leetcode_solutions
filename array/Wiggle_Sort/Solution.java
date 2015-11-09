/**
 * 	This is a O(nlogn) solution...
 */

public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i+1 < nums.length; i+=2) {
            int temp = nums[i+1];
            nums[i+1] = nums[i];
            nums[i] = temp;
        }
    }
}
