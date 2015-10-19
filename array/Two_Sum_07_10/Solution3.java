public class Solution {
    HashMap<Integer, Integer>map = new HashMap<Integer, Integer>();
    
    public int[] twoSum(int[] nums, int target) {
        int[] ans = {-1,-1};
        if(nums.length == 0) {
            return ans;
        }
        for(int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            if(map.containsKey(gap)) {
                if(i > map.get(gap)) {
                    ans[0] = map.get(gap)+1;
                    ans[1] = i+1;
                } else {
                    ans[0] = i+1;
                    ans[1] = map.get(gap)+1;
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
