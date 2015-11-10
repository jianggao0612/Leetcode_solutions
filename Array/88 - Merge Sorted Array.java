/**
 * Merge Sorted Array
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 **********************************Use the extra space in nums1********************************
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

    	if (n == 0) {

    		return;

    	}

    	int i = m - 1, j = n - 1, k = m + n - 1;

    	while ((i > -1) && (j > -1)) {

    		nums1[k] = (nums1[i] > nums2[j] ? nums1[i--] : nums2[j--]); // move the larger one to the tail
    		k--;

    	}

    	if (i == -1) {

    		System.arraycopy(nums2, 0, nums1, 0, j + 1); // deal with the residuals in nums2

    	}

    }
}