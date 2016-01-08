/**
 * Missing Number
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * For example,
 * Given nums = [0, 1, 3] return 2.
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
 public class Solution {
     public int missingNumber(int[] nums) {
         // corner case
         if ((nums == null) || (nums.length == 0)) {
             return 0;
         }

         int length = nums.length;
         int missVal = length;

         for (int i = 0; i < length; i++) {
             while (nums[i] != i) {
                 if (nums[i] >= length) {
                     missVal = i;
                     break;
                 } else {
                     swap(nums, nums[i], i);
                 }
             }
         }

         return missVal;
     }

     public void swap(int[] nums, int index1, int index2) {
         int tmp = nums[index1];
         nums[index1] = nums[index2];
         nums[index2] = tmp;
     }
}
