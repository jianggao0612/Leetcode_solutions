/**
 * Remove Element
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {

        int head = 0;
        int tail = nums.length - 1;
        int length = nums.length;
        
        while ((head <= nums.length - 1) && (tail >= 0) && (head <= tail)) {
            
            if (nums[tail] == val) {
                tail--;
                length--;
                continue; // needs to recheck whether tail is out of bound, since it is used in the next if
            }
            
            if (nums[head] == val) {
                nums[head] = nums[tail];
                tail--;
                length--;
            }
            
            head++; // head needs to go further no matter equals or not
        }
        
        return length;
    }
}