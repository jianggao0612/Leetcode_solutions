// Idea sum of 1..n is (1+n)*n/2

public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int size = nums.length;
        
        if(size < 1) {
            return 0;
        }
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        int total = (size + 1) * size / 2;
        return total - sum;
    }
}
