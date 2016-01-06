/**
 * Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *
 ********************************** Dynamic programming *************************************************
 */
 public class Solution {
     public int uniquePaths(int m, int n) {

         // corner case
         if ((m == 0) || (n == 0)) {
             return 0;
         }

         // corner case
         if ((m == 1) && (n == 1)) {
             return 1;
         }

         // dp table
         int[][] path = new int[m][n];

         // the first column
         for (int i = 0; i < m; i++) {
             path[i][0] = 1;
         }

         // the first row
         for (int i = 0; i < n; i++) {
             path[0][i] = 1;
         }

         // for each shell, reaccurance function: path[i][j] = path[i - 1][j] + path[i][j - 1]
         for (int i = 1; i < m; i++) {
             for (int j = 1; j < n; j++) {
                 path[i][j] = path[i - 1][j] + path[i][j - 1];
             }
         }

         return path[m - 1][n - 1];
     }
 }
