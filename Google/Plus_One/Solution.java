/*
 * Iterate each digit and see if there's an overflow
 */

public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0) {
            return digits;
        }
        
        int size = digits.length;
        
        for(int i = digits.length -1 ; i >= 0; i--) {
            if(digits[i] <= 8) {
                ++digits[i];
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        
        // overflow
        int[] newDigiest = new int[digits.length+1];
        newDigiest[0] = 1;
        return newDigiest;
    }
}