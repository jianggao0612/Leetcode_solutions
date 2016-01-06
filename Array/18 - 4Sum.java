/**
 * 4Sum
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 */
 public class Solution {
     public List<List<Integer>> fourSum(int[] nums, int target) {
         ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

         // corner case - total number of numbers is less than 4
         if ((nums == null) || (nums.length < 4)) {
             return result;
         }

         // sort the array to avoid duplicate
         Arrays.sort(nums);

         // get the max number in the array - for considering corner case
         int max = nums[nums.length - 1];

         // corner cases
         if (max * 4 < target) {
             return result;
         }
         if (nums[0] * 4 > target) {
             return result;
         }

         // go over the array to find 4 sums
         for (int i = 0; i < nums.length; i++) {

             int num = nums[i];

             // avoid duplicate
             if ((i > 0) && (num == nums[i - 1])) {
                 continue;
             }

             // current num is too small
             if ((num + max * 3) < target) {
                 continue;
             }
             // current num is too large
             if (num * 4 > target) {
                 break;
             }

             // current num itself meets the requirement
             if (num * 4 == target) {
                 if (((i + 3) < nums.length) && (nums[i + 3] == num)) {
                     result.add(Arrays.asList(num, num, num, num));
                 }
                 break;
             }

             // do 3 sum with the current num
             threeSum(nums, target - num, i + 1, nums.length - 1, result, num);
         }

         return result;
     }

     public void threeSum(int[] nums, int target, int start, int end, ArrayList<List<Integer>> result, int num1) {

         int max = nums[end];

         // corner cases
         if (max * 3 < target) {
             return;
         }
         if (nums[start] * 3 > target) {
             return;
         }

         // go over the array to find 3 sums
         for (int i = start; i < end; i++) {
             int num = nums[i];

             // avoid duplicates
             if ((i > start) && (num == nums[i - 1])) {
                 continue;
             }
             // num is too small
             if ((num + max * 2) < target) {
                 continue;
             }

             // num is too large
             if (num * 3 > target) {
                 break;
             }

             if ((num * 3) == target) {
                 // be careful that end is the last element of the array, array bound issues
                 if (((i + 2) <= end) && (nums[i + 2] == num)) {
                     result.add(Arrays.asList(num1, num, num, num));
                 }
                 break;
             }

             // do 2 sum for the current num
             twoSum(nums, target - num, i + 1, end, result, num1, num);
         }

         return;

     }

     public void twoSum(int[] nums, int target, int start, int end, ArrayList<List<Integer>> result, int num1, int num2) {

         int max = nums[end];

         // corner cases
         if (max * 2 < target) {
             return;
         }

         if (nums[start] * 2 > target) {
             return;
         }

         // two pointers to find the 2 sums
         for (int i = start, j = end; i < j;) {
             int num3 = nums[i];
             int num4 = nums[j];

             int sum = num3 + num4;

             if (sum == target) {
                 result.add(Arrays.asList(num1, num2, num3, num4));

                 // avoid duplicates
                 while ((++i < j) && (nums[i] == num3)) {
                     ;
                 }
                 while ((--j > i) && (nums[j] == num4)) {
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
