/**
 * Set Matrix Zeros
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 *
 ***************************************** In place marker ************************************
 * use the first row and first column as markers
 * use two flags to indicate the first row and column themselves
 **********************************************************************************************
 */
 public class Solution {
    public void setZeroes(int[][] matrix) {
        // corner case
        if (matrix == null) {
            return;
        }

        // get the total numbers of rows and columns
        int r = matrix.length;
        int c = matrix[0].length;

        // corner case
        if ((r == 0) || (c == 0)) {
            return;
        }

        // flags indicating zeros in first row and first column
        boolean rowZero = false;
        boolean columnZero = false;

        // go over the whole matrix to find all zeros, use the first row and column as markers
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    // whether 0 exists in the first row
                    if (i == 0) {
                        rowZero = true;
                    }
                    // whether 0 exists in the first column
                    if (j == 0) {
                        columnZero = true;
                    }
                    // set markers
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set all the columns containing 0 to be 0
        for (int i = 1; i < c; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < r; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // set all the rows containing 0 to be 0
        for (int i = 1; i < r; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // deal with the first row
        if (rowZero) {
            for (int i = 0; i < c; i++) {
                matrix[0][i] = 0;
            }
        }

        // deal with the first column
        if (columnZero) {
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }

        return;
    }
}
