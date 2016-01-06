/**
 * Two Sum
 *
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 ****************************************************Idea***********************************************************
 * Use the hashMap to store a number's difference of the target and the index of itself
 * E.g. 9 = 2 + 7, when coming across 2, store (7, indexOf(2))
 * Then when coming across 7, the result can be returned directly
 *******************************************************************************************************************
 */
 public class Solution {
    public int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> targetMap = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            // find a match then construct the result with the indices
            if (targetMap.containsKey(numbers[i])) {
                result[0] = targetMap.get(numbers[i]) + 1;
                result[1] = i + 1;
            } else {
                // otherwise, put it's difference the the index into the map
                targetMap.put(target - numbers[i], i);
            }
        }

        return result;


    }
}
