/**
 *  Compute all possible trees for nodes of N and store them in an array.
 *  For next n, 
 *  select one node to be root and just need to compate
 *  array[0]*array[n-1] + array[1]*array[n-2] .... + array[n-1]*array[0]
 */

public class Solution {
    public int numTrees(int n) {
        int[] array = new int[n+1];
        
        if(n <= 1) {
            return n;
        }
        
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            int sum = 0;
            for(int j = 1; j <= i; j++) {
                sum += array[j-1] * array[i-j];
            }
            array[i] = sum;
        }
        
        return array[n];
    }
}