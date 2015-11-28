// Do binary search on n. (reduce the possible search time)

public class Solution {
    public int hammingWeight(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        
        return binaryCountBit(n, 32);
    }
    
    public int binaryCountBit(int n, int length) {
        if(length <= 1) {
            // System.out.println("length:"+length);
            // System.out.println("n:"+n);
            return n;
        }
        
        int shift = length / 2;
        int mask = (1 << shift) -1;
        int leftHalf = (n >> shift) & mask;
        int rightHalf = n & mask;
        
        int count = 0;
        if(leftHalf != 0) {
            count = count + binaryCountBit(leftHalf, shift);
        }
        
        if(rightHalf != 0) {
            count = count + binaryCountBit(rightHalf, shift);
        }
        
        return count;
    }
}
