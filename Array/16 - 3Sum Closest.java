/**
 * 3Sum Closest
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 ********************************************* Same as 3Sum ******************************************************
 * Sort the array
 * Maintain a global difference for go over each element
 * For each element, call the function of 2Sum to find the local minimum difference
 * When the global difference goes into an acsending trend, break
 *****************************************************************************************************************
 */
 public class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int closestSum = 0;
        // corner case
        if ((nums == null) || (nums.length == 0)) {
            return closestSum;
        }
        if (nums.length <= 3) {
            for (int num: nums) {
                closestSum += num;
            }
            return closestSum;
        }

        // sort the array first
        Arrays.sort(nums);
        // global minimum gap
        int minDiff = Integer.MAX_VALUE;
        // local minimum gap for each element
        int currentDiff;

        for (int i = 0; i <= nums.length - 3; i++) {
            // divide into 2Sum problem
            currentDiff = findLocalDiff(nums, target - nums[i], i + 1);

            if (currentDiff == 0) {
                return target;  // find the closest
            } else {
                // local gap is smaller than global gap, set global gap as the local one, keep going
                if (Math.abs(currentDiff) < Math.abs(minDiff)) {
                    minDiff = currentDiff;
                }
            }

            // if the global gap goes into increasing trend, break (since the array is sorted)
            if (minDiff >= 0) {
                break;
            }
        }

        return target + minDiff;
    }

    // 2Sum variation to find the closest sum.
    public int findLocalDiff(int[] nums, int target, int start) {

        int minDiff = Integer.MAX_VALUE;
        int currentDiff;

        for (int i = start, j = nums.length - 1; i < j;) {

            currentDiff = nums[i] + nums[j] - target;

            if (Math.abs(currentDiff) < Math.abs(minDiff)) {
                minDiff = currentDiff;
            }

            if (currentDiff < 0) {
                i++;
            } else if (currentDiff > 0) {
                j--;
            } else {
                break;
            }
        }

        return minDiff;
    }
}
