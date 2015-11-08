/**
 * Rotate Array
 *
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Use another array
 */
public class Solution {
    public void rotate(int[] nums, int k) {

    	
        if (nums.length <= 1)
    		return;
    	if (k == 0)
    	    return;

    	int[] result = new int[nums.length];

    	for (int i = 0; i < nums.length; i++) {
    		result[(i + k) % nums.length] = nums[i];
    	}

    	for (int i = 0; i < nums.length; i++) {
    	    nums[i] = result[i];
    	}

    }
}