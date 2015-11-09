/** 
 * This method is 0(n), and could be improved to O(lgn * lng)
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = 0;
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        // find row
        while(row != rowSize && matrix[row][columnSize-1] < target) {
            row++;
        }
        
        if(row == rowSize) {
            return false;
        }
        
        for(column = 0; column < columnSize; column++) {
            if(matrix[row][column] == target) {
                return true;
            }
        }
        
        return false;
    }
}
