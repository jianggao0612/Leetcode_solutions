public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans =new int[2]; ans[0] = 0; ans[1] = 0;
        
        int[] copy = Arrays.copyOf(nums,nums.length);
        int small = 0;
        int large = 0;
        
        if(nums.length == 0)
            return ans;
        
        Arrays.sort(copy);
        
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
            int sum = copy[left] + copy[right];
            if(sum == target)
                break;
            else if(sum > target)
                right--;
            else
                left++;
        }
        
        small = copy[left];
        large = copy[right];
        
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] == small || nums[i] == large) && ans[0] == 0)
                ans[0] = i+1;
            else if(nums[i] == large || nums[i] == small)
                ans[1] = i+1;
        }
        
        return ans;
    }
}
