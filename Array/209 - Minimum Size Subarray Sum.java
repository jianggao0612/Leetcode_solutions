/**
 * Minimum Size Subarray Sum
 *
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 *
 ************************************************ Idea - Dynamic sliding window ********************************************
 * Use two pointers - fastPointer and slowPointer
 * Use fast pointer to find the sequence first, then use the slow pointer to reduce the length of the sequence
 * Take care of the corners
 **************************************************************************************************
 *
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

 */
 public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // corner case
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        // variable definitions
        int fastPointer = 0, slowPointer = 0;
        int sum = 0;
        int length = 0;

        while (fastPointer < nums.length) {
            // find the sequence whose sum is equal or larger than s
            while ((fastPointer < nums.length) && (sum < s)) {
                sum += nums[fastPointer++];
            }

            // concise the sequence to find the local minimum length
            while (sum >= s) {
                sum -= nums[slowPointer++];
            }

            // compare to get global minimun length
            if ((length == 0) || (length > (fastPointer - slowPointer + 1))) {
                length = fastPointer - slowPointer + 1;
            }
        }

        // if the minimum length is larger than the length of the array, there is no such subarray
        return length > nums.length ? 0 : length;
    }
}
