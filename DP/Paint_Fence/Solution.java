/*
 * Fomula:
 * temp = same
 * same = diff
 * diff = (temp * (k-1)) + (diff * (k-1))
 */
public class Solution {
    public int numWays(int n, int k) {
        if(n <= 0 || k <= 0) {
            return 0;
        }
        
        if(n == 1) {
            return k;
        }
        
        int same = k;
        int diff = k * (k-1);
        int i = 2;
        
        while(i < n) {
            int temp = same;
            same = diff;
            diff = temp * (k-1) + diff * (k-1);
            i++;
        }
        
        return same + diff;
    }
}