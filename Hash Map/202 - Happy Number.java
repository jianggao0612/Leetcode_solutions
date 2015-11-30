/**
 * Happy Number
 *
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the sum of the squares of its digits, 
 * and repeat the process until the number equals 1 (where it will stay), 
 * or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 *
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
 public class Solution {
    public boolean isHappy(int n) {
        
        if (n == 1) {
            return true;
        }
        
        int sum;
        Set<Integer> sumSet = new HashSet<Integer>();
        
        while (true) {
            
            sum = 0;
            int factor = n / 10;
            int residual = n % 10;
            while (factor >= 10) {
                sum += residual * residual;
                residual = factor % 10;
                factor /= 10;
                
            }
            sum += factor * factor + residual * residual; // get a digit square sum of a number

            if (sum == 1) {
                return true;
            } else {
                if (sumSet.contains(sum)) {
                	// if the sum looply reach a repeat number, it is not a happy number
                    return false;
                } else {
                	// use hashSet to check whether there are repeated sum
                    sumSet.add(sum);
                }
            }
            
            n = sum;
            
        }
        
    }
}