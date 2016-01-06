/**
 * Count Primes
 *
 * Description:
 *
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class Solution {
    public int countPrimes(int n) {

    	// corner case
        if (n <= 1) {
        	return 0;
        }

        // initialization set all the number as prime
        boolean[] nums = new boolean[n];
        nums[0] = false;
        nums[1] = false;
        for (int i = 2; i < n; i++) {
        	nums[i] = true;
        }

        int count = 0;

        // when the largest number in the sequence is less than the square of the last marked prime number, terminate
        for (int i = 2; i * i < n; i++) {

        	// if a number is prime number, mark off all its multiples (which are not prime numbers)
        	if (nums[i]) {
        		for (int j = 2; i * j < n; j++) {
        			nums[i * j] = false;
       			}
        	}
        }

        // count all the numbers haven't been marked off to ge the total number of prime numbers
        for (int i = 0; i < n; i++) {
        	if (nums[i]) {
        		count++;
        	}
        }

        return count;
    }
}