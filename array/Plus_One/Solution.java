public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0) {
            return digits;
        }
        
        int size = digits.length;
        
        if(digits[size-1] <= 8) {
            digits[size-1]++;
            return digits;
        } else {
            digits[size-1] = 0;
        }
        
        for(int i = digits.length -2 ; i >= 0; i--) {
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
