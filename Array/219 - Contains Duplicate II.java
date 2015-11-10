/**
 * Contains Duplicate II
 *
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
 * such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums.length <= 1) {
            return false;
        } 

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // use a hashmap to record and update the position of each element

        for(int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {

                if ((i - map.get(nums[i])) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i); // update the position to the new postion
                }
                
            }
        }

        return false; 
        
        
    }
}