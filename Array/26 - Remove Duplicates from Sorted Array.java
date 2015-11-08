/**
 * Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {

    	if (nums.length <= 1)
    		return nums.length;

    	int flag = nums[0] - 1; // since the array is sorted, the number smaller than the first element should appear in the array
    	int curr = nums[0];
    	int size = nums.length; // record the length after removal

    	// mark the duplicated element as flag
    	for (int i = 1; i < nums.length; i++) {

    		if (nums[i] == curr) {
    			nums[i] = flag;
    			size--;
    		} else {
    			curr = nums[i];
    		}

    	}

    	int forePointer = 1;
    	int backPointer = 0;

    	// remove all the flag element 
    	while (backPointer < nums.length) {

    		if (nums[backPointer] == flag) {

    			while ((forePointer < nums.length) && (nums[forePointer] == flag)) { // note the sequence of the two condition - ArrayIndexOutOfBound
    				forePointer++;
    			}

    			if (forePointer == nums.length) {
    				break;
    			}

    			if (nums[forePointer] != flag) {
    				nums[backPointer] = nums[forePointer];
    				nums[forePointer] = flag; 
    			}
    		}

    		backPointer++;
    		forePointer++;
    	}

    	return size;
         
    }
}