/**
 * This method utilize that it doesn't matter what you leave beyond the new length.
 *
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int size = nums.length;
        
        while(i < nums.length && j >= 0 && i <= j) {
            if(nums[j] == val) {
                size--;
                j--;
                continue;
            }
            
            if(nums[i] == val) {
                size--;
                nums[i] = nums[j];
                j--;
            }
            i++;
        }
        return size;
    }
}
