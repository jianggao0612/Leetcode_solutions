/**
 * Missing Ranges
 *
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
 *
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
 public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> result = new ArrayList<String>();

        // corner case
        if (lower > upper) {
            return result;
        }
        if ((nums == null) || (nums.length == 0)) {
            result.add((lower == upper) ? lower + "" : lower + "->" + upper);
            return result;
        }

        int length = nums.length;
        int rangeStart, rangeEnd;

        if (length == 1) {
            if ((nums[0]< lower) || (nums[0] > upper)) {
               result.add((lower == upper) ? lower + "" : lower + "->" + upper);
               return result;
            } else if ((nums[0] == lower) && (nums[0] == upper)) {
                return result;
            } else if (nums[0] == lower) {
               rangeStart = lower + 1;
               result.add((rangeStart == upper) ? rangeStart + "" : rangeStart + "->" + upper);
               return result;
            } else if (nums[0] == upper) {
               rangeEnd = upper - 1;
               result.add((lower == rangeEnd) ? rangeEnd + "" : lower + "->" + rangeEnd);
               return result;
            } else {
               result.add(((nums[0] - 1) == lower) ? lower + "" : lower + "->" + (nums[0] - 1));
               result.add(((nums[0] + 1) == upper) ? upper + "" : (nums[0] + 1) + "->" + upper);
               return result;
            }
        }

        int start = 0;

        // find the start pointer of the array
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] < lower) {
                continue;
            } else if (nums[i] > lower) {
                result.add(((nums[i] - 1) == lower) ? lower + "" : lower + "->" + (nums[i] - 1));
                start = i;
                break;
            } else {
                start = i;
                break;
            }
        }

        for (int i = start; i < length - 1; i++) {
            if ((nums[i + 1] - nums[i]) == 1) {
                continue;
            } else {
                rangeStart = nums[i] + 1;
                if (nums[i + 1] <= upper) {
                    rangeEnd = nums[i + 1] - 1;
                    result.add((rangeStart == rangeEnd) ? rangeStart + "" : rangeStart + "->" + rangeEnd);
                } else {
                    rangeEnd = upper - 1;
                    result.add((rangeStart == rangeEnd) ? rangeStart + "" : rangeStart + "->" + rangeEnd);
                    break;
                }
            }
        }

        if (nums[length - 1] < upper) {
            result.add(((nums[length - 1] + 1) == upper) ? upper + "" : (nums[length - 1] + 1) + "->" + upper);
        }

        return result;


    }
}
