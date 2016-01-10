/**
 * Maximum Subarray
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
 public class Solution {
    public int maxSubArray(int[] nums) {

        // corner case
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        int length = nums.length;
        int[] sum = new int[length];
        sum[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < length; i++) {
            sum[i] = Math.max(nums[i], nums[i] + sum[i - 1]);
            if (sum[i] > max) {
                max = sum[i];
            }
        }

        return max;


    }
}
