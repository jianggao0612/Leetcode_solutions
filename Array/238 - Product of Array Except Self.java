/**
 * Product of Array Except Self
 *
 * Given an array of n integers where n > 1, nums,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Solve it without division and in O(n).
 *
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 **************************************** Idea ******************************************************************
 * Input: [a1, a2, a4, a4]
 * Output:[a2*a3*a4, a1*a3*a4, a1*a2*a4; a1*a2*a3]
 * Seperate into two arrays:
 * [a2*a3*a4, a3*a4, a4, 1]
 * [1, a1, a1*a2, a1*a2*a3]
 * Go over the original array twice and use an extra space to do the multiplications.
 ****************************************************************************************************************
 */
 public class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] output = new int[n];

        output[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            output[i] = nums[i + 1] * output[i + 1];
        }

        int leftMul = 1;
        for (int i = 0; i < n; i++) {
            output[i] = output[i] * leftMul;
            leftMul = leftMul * nums[i];
        }

        return output;
    }
}
