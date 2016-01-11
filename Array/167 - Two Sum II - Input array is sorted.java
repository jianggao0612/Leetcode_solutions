/**
 * Two Sum II - Input array is sorted
 *
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
 public class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];

        // corner case
        if (numbers == null) {
            return result;
        }
        if (numbers.length < 2) {
            return result;
        }

        // use two pointer to find the possible answer
        for (int i = 0, j = numbers.length - 1; i < j;) {
            if (numbers[i] + numbers[j] == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return result;
    }
}