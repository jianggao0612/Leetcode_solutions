/**
 * Spiral Matrix
 *
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 *
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
 public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<Integer>();

        // corner case
        if (matrix == null) {
            return result;
        }

        // corner cases
        int r = matrix.length;
        if (r == 0) {
            return result;
        }

        int c = matrix[0].length;
        if (c == 0) {
            return result;
        }

        // access the elements in round
        for (int i = 0; i < (Math.min(r, c) + 1) / 2; i++) {

            // first horizontal
            for (int j = i; j <= c - 1 - i; j++) {
                result.add(matrix[i][j]);
            }

            // first vertical
            for (int j = i + 1; j <= r - 1 - i; j++) {
                result.add(matrix[j][c - 1 - i]);
            }

            // if the second horizontal has not been visited, visit it
            if ((r - 1 - i) > i) {

                for (int j = (c - 1 - i) - 1; j >= i; j--) {
                    result.add(matrix[r - 1 - i][j]);
                }
            }

            // if the second vertical has not been visited, visit it
            if ((c - 1 - i) > i) {
                for (int j = (r - 1 - i) - 1; j > i; j--) {
                    result.add(matrix[j][i]);
                }
            }

        }

        return result;

    }
}
