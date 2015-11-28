// Swap bits if left and right side are different


public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int left = 1 << 16;
        int right = 1 << 15;
        int leftIndex = 17;
        int rightIndex = 16;
        for(int i = 0; i < 16; i++) {
            int leftBit = ((n & left) >> (leftIndex - 1)) & 1;
            int rightBit = ((n & right) >> (rightIndex - 1)) & 1;
            
            if(leftBit != rightBit) {
                n = swapBit(n, leftIndex, rightIndex);    
            }
            
            left <<= 1;
            right >>=1;
            leftIndex++;
            rightIndex--;
            
        }
        
        return n;
    }
    
    public int swapBit(int n, int leftIndex, int rightIndex) {
        int leftBit = (n >> (leftIndex -1)) & 1;
        int rightBit = (n >> (rightIndex -1)) & 1;
        
        if(leftBit == 1) {
            n |= leftBit << (rightIndex - 1);
            // right bit must be 0
            n &= ~(leftBit << (leftIndex - 1));
        } else {
            n &= ~(rightBit << (rightIndex - 1));
            // right bit must be 1
            n |= rightBit << (leftIndex - 1);
        }
        
        return n;
    }
}
