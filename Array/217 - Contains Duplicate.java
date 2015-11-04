/**
 * Contains Duplicate
 *
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 */
public class Solution {
	/**
	 * use HashSet
	 */
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1)
            return false;
            
        HashSet<Integer> hashset = new HashSet<Integer>();
        int i = 0;
        
        while (i < nums.length) {
            if (!hashset.add(nums[i]))
                return true;
            else
                i++;
        }
        return false;
    }

    /**
     * use Arrays.sort()
     */
    public boolean containsDuplicate_sort(int[] nums) {

    	if (nums.length <= 1)
            return false;
        
        Arrays.sort(nums); // no return value, just do sort on the original array
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        
        return false;

    }
}