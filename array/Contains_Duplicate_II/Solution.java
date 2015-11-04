/**
 * Always record last index of each distinct element
 */

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(num)) {
                if(i - map.get(num) <= k) {
                    return true;
                } else {
                    map.put(num, i);
                }
            } else {
                map.put(num,i);
            }
        }
        return false;
    }
}
