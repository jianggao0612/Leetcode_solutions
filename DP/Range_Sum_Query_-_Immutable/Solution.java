/*
 * A helper array - store the sum of all previous and current elements
 */
public class NumArray {
    private int[] helperArray;
    private int length;
    
    public NumArray(int[] nums) {
        this.length = nums.length;
        if(length == 0) {
            return;
        } else {
            helperArray = new int[nums.length];
        }
        
        // init helper array
        helperArray[0] = nums[0];
        for(int i = 1; i < length; i++) {
            helperArray[i] = nums[i] + helperArray[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i < 0 || j < 0 || i >= length || j>= length ) {
            return 0;
        }
        
        if( i > j) {
            return 0;
        }
        
        if(i == 0) {
            return helperArray[j];
        } else {
            return helperArray[j] - helperArray[i-1];
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);