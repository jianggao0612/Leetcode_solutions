/**
 * Search for a Range
 *
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
 public class Solution {
    public int[] searchRange(int[] nums, int target) {

        // result initialization
        int[] range = new int[2];
        range[0] = -1;
        range[1] = -1;

        // corner case
        if ((nums == null) || (nums.length == 0)) {
            return range;
        }

        // binary search lower and upper bound
        int start = 0;
        int end = nums.length - 1;

        // binary search middle element
        int mid = -1;

        // binary search
        while (start <= end) {
            mid = start + (end - start) / 2;

            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else { // when found, go left and right to ge the range
                range[0] = mid;
                range[1] = mid;

                // find the lower bound of the range
                while ((range[0] > 0) && (nums[range[0] - 1] == target)) {
                    range[0]--;
                }

                // find the upper bound of the range
                while ((range[1] < nums.length - 1) && (nums[range[1] + 1] == target)) {
                    range[1]++;
                }

                // end loop - important
                break;
            }
        }

        return range;
    }
}
