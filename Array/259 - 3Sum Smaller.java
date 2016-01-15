/**
 * 3Sum Smaller
 *
 * Given an array of n integers nums and a target,
 * find the number of index triplets i, j, k
 * with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 *
 * Return 2. Because there are two triplets which sums are less than 2:
 *
 * [-2, 0, 1]
 * [-2, 0, 3]
 *
 * Follow up:
 * Could you solve it in O(n2) runtime?
 */
 public class Solution {
     public int threeSumSmaller(int[] nums, int target) {

         // corner case
         if ((nums == null) || (nums.length < 3)) {
             return 0;
         }

         // sort the array for two pointers
         Arrays.sort(nums);

         // global count
         int count = 0;

         // go over every possible elements
         // NOTICE: do not need to care about duplicate, since it requires indices
         for (int i = 0; i <= nums.length - 3; i++) {
             count += twoSumSmaller(nums, target - nums[i], i + 1);
         }

         return count;

     }

     // Helper function for calculating two sums.
     public int twoSumSmaller(int[] nums, int target, int start) {

         int low = start, high = nums.length - 1;
         int count = 0;

         while (low < high) {

             // find the largest number for the range
             while ((low < high) && (nums[low] + nums[high]) >= target) {
                 high--;
             }

             // check loop condition
             if (low >= high) {
                 break;
             }

             // count the number of indices
             count += (high - low);
             // go on to find more
             low++;
         }

         return count;
     }
}
