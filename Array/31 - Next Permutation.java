/**
 * Next Permutation
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 ********************************************* idea ********************************************************************
 * From the last elements, find the first point that breaks the descending order
 * Swap the element with the first larger element in the descending sequence
 * Reverse the descending sequence
 ***********************************************************************************************************************
 */
 public class Solution {
     public void nextPermutation(int[] nums) {
         // corner case
         if ((nums == null) || (nums.length <= 1)) {
             return;
         }

         int length = nums.length;
         int breakPoint;    // the starting point of the descending sequence
         int i = length - 1;

         // find the point that ends the descending sequence
         while ((i > 0) && (nums[i - 1] >= nums[i])) {
             i--;
         }

         // check whether it's a total descending sequence
         if (i == 0) {
             reverse(nums, 0, length - 1);  // if so, reverse the whole array
             return;
         } else {
             breakPoint = i;
             // find the first larger element, swap and reverse
             for (i = length - 1; i >= breakPoint; i--) {
                 if (nums[i] > nums[breakPoint - 1]) {
                     swap(nums, i, breakPoint - 1);
                     reverse(nums, breakPoint, length - 1);
                     break;
                 }
             }
         }
     }

     // Helper function to reverse an array.
     public void reverse(int nums[], int start, int end) {

         for (int i = start, j = end; i < j; i++, j--) {
             swap(nums, i, j);
         }

     }

     // Helper function to swap two elements in an array.
     public void swap(int[] nums, int index1, int index2) {
         int tmp = nums[index1];
         nums[index1] = nums[index2];
         nums[index2] = tmp;
     }
 }
