/**
 *	Using m + n space to store which row or column needs to be set to 0
 */

public class Solution {
    public void setZeroes(int[][] matrix) {
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        int[] row = new int[rowSize];
        int[] column = new int[columnSize];
        int i = 0;
        int j = 0;
        
        for(i = 0; i < rowSize; i++) {
            for(j = 0; j < columnSize; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }
        
        for( i = 0; i < rowSize; i++) {
            for(j = 0; j < columnSize; j++) {
                if(row[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        return;
    }
}
