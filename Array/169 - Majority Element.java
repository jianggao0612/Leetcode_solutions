/**
 * Majority Element
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * HashMap, Sorting, Moore voting
 */
public class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        int maj = nums[0];

       	for (int i = 0; i < nums.length; i++) {

       		if (count == 0) {

       			maj = nums[i];
       			count = 1;
       			continue;

       		} else {

       			if (maj == nums[i]) {

       				count++;

	       		} else {

	       			count--;
	       		}

	       	}
	       	
	    }

	    return maj;
}