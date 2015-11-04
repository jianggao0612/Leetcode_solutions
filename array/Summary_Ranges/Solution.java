/**
 *	Using two pointers to traverse the array
 *  as long as it is continous, move the second pointer to next. if not, print
 *  Also need to deal with the last range(one number or a range).
 */

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int first = 0;
        int second = 0;
        ArrayList<String> result = new ArrayList<>();
        
        if(nums.length == 0) {
            return result;
        }
        if(nums.length == 1) {
            result.add(Integer.toString(nums[0]));
            return result;
        }
        
        second = first + 1;
        while(second <= nums.length-1) {
            if(nums[second] == nums[second-1] + 1) {
                second++;
            } else {
                if(first != second -1) {
                    result.add(nums[first] + "->" + nums[second-1]);
                } else {
                    result.add(Integer.toString(nums[first]));
                }
                first = second;
                second++;
            }
        }
        if(first == nums.length - 1) {
            result.add(Integer.toString(nums[first]));
        } else {
            result.add(nums[first] + "->" + nums[nums.length-1]);
        }
        return result;
    }
}
