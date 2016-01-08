/**
 * Rotate Image
 *
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 ******************************************** Idea ************************************
 * Calculate the rules for indices
 * Notice the swap round for odd number and even number
 **************************************************************************************
 */
 public class Solution {
     public void rotate(int[][] matrix) {

         // corner case
         if (matrix == null) {
             return;
         }

         // get the length of the matrix
         int n = matrix.length;

         // corner case
         if (n <= 1) {
             return;
         }

         // times to do swap
         int rowCount;
         int columnCount;

         // if n is odd, row times is smaller than colunm times
         if ((n % 2) != 0) {
              rowCount = n / 2;
              columnCount = n / 2 + 1;
         } else {
             rowCount = columnCount = n / 2;
         }

         // for each number, do swap in a round of 4 numbers
         for (int i = 0; i < rowCount; i++) {
             for (int j = 0; j < columnCount; j++) {
                 swap(matrix, i, j, j, n - 1 - i);
                 swap(matrix, i, j, n - 1 - i, n - 1 - j);
                 swap(matrix, i, j, n - 1 - j, i);
             }
         }

         return;
     }

     /**
      * Helper function for swap.
      */
     public void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
         int tmp = matrix[r1][c1];
         matrix[r1][c1] = matrix[r2][c2];
         matrix[r2][c2] = tmp;
     }
}
