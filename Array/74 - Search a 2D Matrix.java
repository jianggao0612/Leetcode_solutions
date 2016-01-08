/**
 * Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 *
 * Consider the following matrix:
 *
 * [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
 public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // corner case
        if (matrix == null) {
            return false;
        }

        // get the number of rows and columns of the matrix
        int r = matrix.length;
        int c = matrix[0].length;

        // corner case
        if ((r == 0) || (c == 0)) {
            return false;
        }

        int start = 0;
        int end = r - 1;
        int midRow;

        // outer binary search to locate row
        while (start <= end) {

            midRow = start + (end - start) / 2;

            if (target < matrix[midRow][0]) {
                end = midRow - 1;
            } else if (target > matrix[midRow][c - 1]) {
                start = midRow + 1;
            } else if ((target > matrix[midRow][0]) && (target < matrix[midRow][c - 1])) {
                // inner binary search in the target row
                start = 0;
                end = c - 1;
                int midColumn;

                while (start <= end) {
                     midColumn= start + (end - start) / 2;

                    if (target < matrix[midRow][midColumn]) {
                        end = midColumn - 1;
                    } else if (target > matrix[midRow][midColumn]) {
                        start = midColumn + 1;
                    } else {
                        return true;
                    }
                }

                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
