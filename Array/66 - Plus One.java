/**
 * Plus One
 *
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 *
 */
public class Solution {
    public int[] plusOne(int[] digits) {

    	// corner case
        if (digits.length == 0)
            return digits;
            
         if (digits[digits.length - 1] < 9) {
             
             digits[digits.length - 1]++;
             return digits;
             
         } else {
             
             digits[digits.length - 1] = 0;
             
         }
         
         for (int i = digits.length - 2; i >= 0; i--) {
             
             if (digits[i] < 9) {
                 
                 digits[i]++;
                 return digits;
                 
             } else {
                 
                 digits[i] = 0;
                 
             }
         }
         
         // deal with overflow
         int[] overflowArray = new int[digits.length + 1];
         System.arraycopy(digits, 0, overflowArray, 1, digits.length);
         overflowArray[0] = 1;
         return overflowArray;
    }
}