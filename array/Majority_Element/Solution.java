/**
 * This is a naive solution that uses a hashmap to store the count of each element
 */

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(num)) {
                int count = map.get(num) + 1;
                if(count > nums.length/2) {
                    return num;
                } else {
                    map.put(num, count);
                }
            } else {
                map.put(num, 1);
            }
        }
        return nums[0]; // in case only one element in array
    }
}
