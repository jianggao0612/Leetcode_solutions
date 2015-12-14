/*
 * Using an array to store all numSqaures of previous numbers
 */
public class Solution {
    public int numSquares(int n) {
        int size = n;
        int[] subSquares = new int[size+1];
        
        subSquares[1] = 1;
        for(int i = 2; i <= size; i++) {
            if(isSquare(i)) {
                subSquares[i] = 1;
                continue;
            }
            
            int minNum = i;
            int s = 1;
            while(s*s < i) {
                int interSqr = s*s;
                int curMin = 1 + subSquares[i-interSqr];
                if(curMin < minNum) {
                    minNum = curMin;
                }
                s++;
            }
            
            subSquares[i] = minNum;
        }
        return subSquares[n];
    }
    
    private boolean isSquare(int num) {
        double squared = Math.sqrt(num);
        return squared == (int)squared;
    }
}
