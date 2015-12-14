/**
 * Symmatrically check left side char and right side char. If not match any pairs, return false
 */

public class Solution {
    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length()-1;
        
        while(left <= right) {
            char leftChar = num.charAt(left); // get left side char
            char rightChar = num.charAt(right); // get right side char
            left++;
            right--;
            
            if(leftChar == '6' && rightChar == '9') {
                // do nothing
            } else if(leftChar == '9' && rightChar == '6') {
                // do nothing
            } else if(leftChar == '1' && rightChar == '1') {
                // do nothing
            } else if(leftChar == '8' && rightChar == '8') {
                // do nothing
            } else if(leftChar == '0' && rightChar == '0') {
                // do nothing
            } else if(left == right + 2 && (leftChar == '0' || leftChar == '1' || leftChar == '8')){
                // mid of string, left == right, do nothing
            } else {
                return false;
            }
        }
        return true; // all passed
    }
}