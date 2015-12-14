/**
 * This is a NlogN solution
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        
        for(int i = 0; i < rowSize; i++) {
            int leftBound = matrix[i][0];
            int rightBound = matrix[i][columnSize-1];
            
            if(leftBound <= target && rightBound >= target) {
                if(binarySearch(matrix[i], target, 0, columnSize-1)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     *  Binary Search in an 1d array
     */
    public boolean binarySearch(int[] array, int target, int left, int right) {
        if(left > right) {
            return false;
        }
        
        int mid = (left + right) / 2;
        
        if(array[mid] == target) {
            return true;
        }
        
        if(array[mid] > target) {
            return binarySearch(array, target, left, mid-1);
        } else {
            return binarySearch(array, target, mid+1, right);
        }
    }
}