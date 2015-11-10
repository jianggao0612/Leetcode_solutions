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

        if (k > (nums.length - 1)) {

            return false;

        }

        HashSet<Integer> visited = new HashSet<Integer>();

        int i = 0, j = i + k;

        while (j < nums.length) {

            visited.add(nums[i]);

            if (visited.contains(nums[j])) {

                return true;

            } else {

                i++;
                j++;

            }
        }

        return false; 
        
        
    }
}