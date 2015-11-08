/** 
 * Summary Ranges
 *
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<String>();

        // corner case
        if (nums.length == 0) 
        	return result;
        if (nums.length == 1) {
            result.add("" + nums[0]);
            return result;
        }

        String curr = "";
        int lowerBound = 0; // lower bound of the ranges
        int currNum = 0; // moving pointer

    	// NOTICE: note array out of bound and the corner of the last element
    	while ((currNum < nums.length - 1)) {

    		if ((nums[currNum + 1] == (nums[currNum] + 1))) {
	    		currNum++;
	    		continue;
    		}
            
            // determine whether the pointer moved
            if (currNum > lowerBound) {
            	curr += nums[lowerBound] + "->" + nums[currNum];
            	result.add(curr);
            } else {
                result.add("" + nums[currNum]);
            }
            
        	curr = "";
        	lowerBound = currNum + 1; // update lower bound
        	currNum++;
        }

        // deal with the last element
        if (nums[nums.length - 1] == (nums[nums.length - 2] + 1)) {

        	curr += nums[lowerBound] + "->" + nums[nums.length - 1];
        	result.add(curr);

        } else {

        	curr += nums[nums.length - 1];
        	result.add(curr);

        }

        return result;
    }
}