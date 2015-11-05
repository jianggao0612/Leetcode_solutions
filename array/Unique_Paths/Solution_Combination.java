/**
 * This method is based on combination
 * Total steps would be m-1 + n-1; Assume 4 + 2 = 6, then, compute the C6(2)
 */

public class Solution {
    public int uniquePaths(int m, int n) {
        int steps = m-1 + n-1;
        
        int top = m > n?(n-1):(m-1);
        
        return compute(steps, top);
    }
    
    public int compute(int steps, int m) {
        if(steps == 0) {
            return 1;
        }
        
        if(steps == m) {
            return 1;
        }
        if(m == 0) {
            return 1;
        }
        
        double top = steps;
        double bottom = 1;
        int j = 1;
        int i = steps - 1;
        
        for(j = 1; j <= m; j++) {
            bottom = bottom * j;
        }
        
        for(i = steps-1; i >= steps - m +1; i--){
            top = top * i;
        }
        
        return (int)(top / bottom +0.5d);
    }
}
