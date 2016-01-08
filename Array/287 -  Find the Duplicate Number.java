/**
 * Find the Duplicate Number
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
 public class Solution {
    public int findDuplicate(int[] nums) {
        // get the length of the array, number range should be [1, length - 1] (n - 1)
        int length = nums.length;

        // binary search variables
        int start = 1;
        int end = length - 1;
        int mid;

        // binary search
        while (start < end) {
            // the middle value of the range
            mid = start + (end - start) / 2;
            int count = 0;

            for (int i = 0; i < length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            // if no duplicate, the count should equal to the middle value(half - half)
            if (count > mid) {
                // duplicate value should exist in the left side
                end = mid;
            } else {
                // duplicate value should exist in the right side
                start = mid + 1;
            }
        }

        return start;


    }
}
