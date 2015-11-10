/**
 * Move Zeros
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Use two pointers.
 *
 */
public class Solution {
    public void moveZeroes(int[] nums) {

    	if (nums.length <= 1)
    		return;
        
        int backPointer = 0;
        int forePointer = 1;

        while (backPointer < nums.length) {

        	if (nums[backPointer] == 0) {

        		while ((forePointer < nums.length) && (nums[forePointer] == 0)) {

        			forePointer++;

        		}

        		if (forePointer == nums.length) {

        			break;

        		}

        		if (nums[forePointer] != 0) {

        			nums[backPointer] = nums[forePointer];
        			nums[forePointer] = 0;

        		}
        	}

        	forePointer++;
        	backPointer++;

        }
    }
}