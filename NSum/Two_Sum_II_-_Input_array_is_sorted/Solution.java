public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // iterate from left and right side to middle
        int[] ans = new int[2];
        
        int left = 0;
        int right = numbers.length-1;
        
        while(left <= right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                break;
            }  else if(sum < target) {
                left++; // sum is greater than target
            } else {
                right--; // sum is smaller than target
            }
        }
        
        if(left == right) {
            // not found, impossible
        }
        
        ans[0] = left+1;
        ans[1] = right+1;
        return ans;
    }
}