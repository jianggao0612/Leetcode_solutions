/**
 * 3Sum
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 */
 public class Solution {

     private static final int SUM = 0;

     public List<List<Integer>> threeSum(int[] nums) {

         List<List<Integer>> result = new ArrayList<List<Integer>>();

         // corner case
         if ((nums == null) || (nums.length < 3)) {
             return result;
         }

         // sort the array to avoid duplicate
         Arrays.sort(nums);
         int length = nums.length;

         // corner case
         if (nums[0] * 3 > SUM) {
             return result;
         }

         // corner case
         if (nums[length - 1] * 3 < SUM) {
             return result;
         }

         for (int i = 0; i < length; i++) {

             // avoid duplicate
             if ((i > 0) && (nums[i - 1] == nums[i])) {
                 continue;
             }

             // if the current number is too small
             if (nums[i] + nums[length - 1] * 2 < SUM) {
                 continue;
             }

             // if the current number is too large
             if (nums[i] * 3 > SUM) {
                 break;
             }

             // check whether the number itself can meet the requirement
             if (nums[i] * 3 == SUM) {
                 if (((i + 2) < length) && (nums[i + 2] == nums[i])) {
                     result.add(Arrays.asList(nums[i], nums[i], nums[i]));
                 }
                 break;
             }

             // get the other two elements for nums[i] calling twoSum
             twoSum(SUM - nums[i], nums, nums[i], i + 1, length - 1, result);

         }

         return result;
     }

     /**
      * Helper function for 3Sum - find the two elements for a give element
      */
     public void twoSum(int target, int[] nums, int num1, int start, int end, List<List<Integer>> result) {

         if (nums[end] * 2 < target) {
             return;
         }

         if (nums[start] * 2 > target) {
             return;
         }

         for (int i = start, j = end; i < j;) {
             int num2 = nums[i];
             int num3 = nums[j];

             int sum = num2 + num3;

             if (sum == target) {
                 result.add(Arrays.asList(num1, num2, num3));

                 while ((++i < j) && (nums[i] == num2)) {
                     ;
                 }

                 while ((--j > i) && (nums[j] == num3)) {
                     ;
                 }
             }

             if (sum < target) {
                 i++;
             }

             if (sum > target) {
                 j--;
             }
         }

         return;
     }

}
