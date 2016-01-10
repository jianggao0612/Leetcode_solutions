/**
 * Maximum Product Subarray
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
 public class Solution {
     public int maxProduct(int[] nums) {
        // corner case
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0];
        int maxPos = 1;
        int minNeg = 1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
               // when nums[i] > 0, maxPos must grow with multiplication
                maxPos *= nums[i];

                // check whether minNeg should do multiplication
                if (minNeg < 0) {
                    minNeg *= nums[i];
                } else {
                    minNeg =  1;
                }

                // keep the global max
                max = Math.max(max, maxPos);

            } else if (nums[i] < 0) {

                int tmp = minNeg;
                // when nums[i] < 0, minNeg mush grow down with multiplication
                minNeg = maxPos * nums[i];
                // check whether maxPos grows with multiplication
                if (tmp < 0) {
                    maxPos = tmp * nums[i];
                    max = Math.max(maxPos, max); // do comparison only when maxPos changes
                } else {
                    maxPos = 1;
                }

            } else {
                // when nums[i] == 0, reset
                maxPos = 1;
                minNeg = 1;
                max = max > 0 ? max : 0;
            }

        }

        return max;
    }
}
