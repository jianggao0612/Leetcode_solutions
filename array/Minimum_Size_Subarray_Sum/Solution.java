/**
 *	Use two pointers to traverse array. One front and one tail, continously check the length.
 */ 

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int minLength = 0;
        int i = 0; 
        int j = 0;
        int sum = 0;

        while(i < nums.length) {
            int newSum = sum + nums[i];
            if(newSum < s) {
                i++;
                sum = newSum;
                continue;
            } else {
                while(j < i && newSum >= s) {
                    newSum = newSum - nums[j];
                    j++;
                }
                sum = newSum;
                if(j == i) {
                    if(newSum >= s) {
                        return 1; // This newSum >= s
                    } else {
                        minLength = 2; // newSum < s
                    }
                } else {
                    if(i - j + 1 < minLength || minLength == 0) {
                        minLength = i - j + 2;
                    }
                }
                i++;
            }
        }
        return minLength;
    }
}
