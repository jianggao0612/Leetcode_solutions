/**
 * This is better version of DP.
 */

public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) {
            return 0;
        }
        
        if(n == 1) {
            return k;
        }
        int same = k;
        int diff = k * (k -1);
        
        for(int i = 2; i < n; i++) {
            int temp = same;
            same = diff;
            diff = temp * (k-1) + diff * (k-1);
        }
        
        return same + diff;
    }
}