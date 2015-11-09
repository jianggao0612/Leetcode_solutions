/**
 *	To deal with the duplicate, it is hard to tell which side should continue when (left) = (mid) = (right). In this caes, can only skip this left element after check if left != target
 */

public class Solution {
    public boolean search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }
    
    public boolean binarySearch(int[] nums, int target, int left, int right) {
        
        if(left > right) {
            return false;
        }
        
        int mid = (left + right) / 2;
        
        if(nums[mid] == target) {
            return true;
        }
        if(nums[left] == target) {
            return true;
        }
        
        if(nums[mid] > nums[left]) {
            // left side is in order
            if(target >= nums[left] && target <= nums[mid] ) {
                return binarySearch(nums, target, left, mid-1);
            } else {
                return binarySearch(nums, target, mid+1, right);
            }
        } else if(nums[mid] < nums[right] ){
           // right side is in order
            if(nums[mid] <= target && target <= nums[right]) {
                return binarySearch(nums, target, mid+1, right);
            } else {
                return binarySearch(nums, target, left, mid-1);
            } 
        } else {
            return binarySearch(nums, target, left+1, right);
        }
    }
}
