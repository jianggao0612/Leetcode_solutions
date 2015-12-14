/*
 * At each pos, there are two possible ways to reach:
 * 1. take one step from -1 pos
 * 2. take two steps from -2 pos
 */

public class Solution {
    public int climbStairs(int n) {
        if(n < 1) {
            return 0;
        }
        
        if( n <= 2) {
            return n;
        }
        
        int first = 1;
        int second = 2;
        int result = 0;
        int i = 3;
        while( i <= n) {
            result = first + second;
            first = second;
            second = result;
            i++;
        }
        
        return result;
    }
}