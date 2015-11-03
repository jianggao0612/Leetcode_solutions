public class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        int[] newNums = new int[size];
        
        k = k % size;
        if(k == 0) {
            return;
        }
        
        int j = size-k;
        int i = 0;
        for(i = 0; i < size; i++) {
            newNums[i] = nums[j%size];
            ++j;
        }
        
        for(i = 0; i < size; i++) {
            nums[i] = newNums[i];
        }
        
        return;
    }
}
