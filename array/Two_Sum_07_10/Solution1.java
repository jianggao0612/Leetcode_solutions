public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length < 1)
            return null;
            
        int[] ans = {0,0};
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    ans[0] = i+1;
                    ans[1] = j+1;
                }
            }
        }
        return ans;
    }
}
