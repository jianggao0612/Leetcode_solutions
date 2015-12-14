/*
 *  This problem is similar to Local Minimum. And according to the given condition, num[i] != num[i+1], 
 *  there must exist a O(logN) solution. So we use binary search for this problem.
 *  If num[i-1] < num[i] > num[i+1], then num[i] is peak
 *  If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
 *  If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
 *  If num[i-1] > num[i] < num[i+1], then both sides have peak (n is num.length)
 */

public class Solution {
    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length-1);
    }
    
    public int findPeak(int[] nums, int left, int right) {
        if(left >= right) {
            return left;
        }
        
        int mid = (left + right)/2;
        
        int num = nums[mid];
        if(left + 1 == right) {
            return nums[left] > nums[right]?left:right;
        } else if(num > nums[mid-1] && num > nums[mid+1]) {
            return mid;
        } else if(num > nums[mid-1] && num < nums[mid+1])  {
            return findPeak(nums, mid+1, right);
        } else if(num < nums[mid-1] && num > nums[mid+1] ) {
            return findPeak(nums, left, mid-1);
        } else {
            return findPeak(nums, left, mid-1); // both sides are find
        }
    }
}