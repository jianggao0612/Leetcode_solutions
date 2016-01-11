/**
 * Maximum Size Subarray Sum Equals k
 *
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
 * If there isn't one, return 0 instead.
 *
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 *
 * Example 2:
 * Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 *
 * Do it in O(n) time.
 *
 ******************************************** Idea (similar to 2Sum) ****************************************
 * Use hashmap to store sum and index (sum, i), key is (nums[0] + ... + nums[i]), value is index i
 * For each element nums[i], if sum equals to k, get the length i + 1;
 * If it doesn't equal to k, find the difference between sum and k -> (sum - k).
 * If (sum - k) is one of the previous sums, get the index j, which means nums[j + 1] + ... + nums[i] equals target k
 * If not, store the new sum, and keep going. (if the sum is already stored, which means there are 0s, keep the leftmost one).
 ***********************************************************************************************************
 */
 public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {

        // corner case
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        // hashMap to store sum and corresponding index
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // accumulative sum
        int sum = 0;
        // global maximum length
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            // get the current total sum
            sum += nums[i];
            // if sum equals to target, current maxLength should be i + 1 and store the current sum (so no else of this if)
            if (sum == k) {
                maxLength = i + 1;
            }
            // if sum doesn't equal to target, find the difference
            if (map.containsKey(sum - k)) {
                // if the difference is a previous sum, get the distance
                maxLength = (i - map.get(sum - k)) > maxLength ? i - map.get(sum - k) : maxLength;
            } else if (!map.containsKey(sum)) {
                // if not, store the current sum
                map.put(sum, i);
            }
        }

        return maxLength;

    }
}
