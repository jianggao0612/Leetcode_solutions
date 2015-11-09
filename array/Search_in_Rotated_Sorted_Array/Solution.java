/**
 *	This approach is based on binary search. Needs to take care of corner case
 */

public class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }
    
    public int binarySearch(int[] nums, int target, int left, int right) {
        
        if(left > right) {
            return -1;
        }
        
        int mid = (left + right) / 2;
        
        if(nums[mid] == target) {
            return mid;
        }
        
        if(nums[0] <= nums[mid]) {
            // left side is in order
            if(nums[mid] > target && target >= nums[0]) {
                return binarySearch(nums, target, left, mid-1);
            } else {
                return binarySearch(nums, target, mid+1, right);
            }
        } else {
            // right side is in order
            if(nums[mid] < target && target <= nums[right]) {
                return binarySearch(nums, target, mid+1, right);
            } else {
                return binarySearch(nums, target, left, mid-1);
            }
        }
    }
}
