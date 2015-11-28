// Just check if find more than two 1s in the bit presentation


public class Solution {
    public boolean isPowerOfTwo(int n) {
        int oneCount = 0;
        
        while(n != 0) {
            int lastBit = n & 1;
            if(lastBit == 1) {
                oneCount++;
                if(oneCount > 1) {
                    return false;
                }
            }
            
            n >>= 1;
        }
        
        return oneCount == 1;
    }
}
