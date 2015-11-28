/**
 *	Using binary search to determine both end
 */

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result =  new int[2];
        result[0] = -1;
        result[1] = -1;
        
        binaryRangeSearch(nums, 0, nums.length-1, target, result);
        return result;
    }
    
    public void binaryRangeSearch(int[] nums, int left, int right, int target, int[] result) {
        int mid = (left + right) / 2;
        // System.out.println("left:"+left);
        // System.out.println("right:"+right);
        // System.out.println("mid:"+mid);
        if(left > right) {
            System.out.println(0);
            return;
        }
        
        if(nums[mid] > target) {
            System.out.println(1);
            binaryRangeSearch(nums, left, mid-1, target, result);
        } else if(nums[mid] < target) {
            System.out.println(2);
            binaryRangeSearch(nums, mid+1, right, target, result);
        } else {
            System.out.println(3);
            if(mid > 0) {
                binaryRangeSearch(nums, left, mid-1, target, result);
            }
            if(result[0] == -1 || mid < result[0]) {
                    result[0] = mid;
            }
                
            
            if(mid < right) {
                binaryRangeSearch(nums, mid+1, right, target, result);
            }
            if(result[1] == -1 || mid > result[1]) {
                    result[1] = mid;
            }
        }
    }
}
