/**
 * Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
 public class Solution {
    public int minPathSum(int[][] grid) {

        // corner case
        if (grid == null) {
            return 0;
        }

        int r = grid.length;
        int c = grid[0].length;

        if ((r == 0) || (c == 0)) {
            return 0;
        }

        int[][] sumGrid = new int[r][c];
        sumGrid[0][0] = grid[0][0];

        for (int i = 1; i < r; i++) {
            sumGrid[i][0] = grid[i][0] + sumGrid[i - 1][0];
        }

        for (int i = 1; i < c; i++) {
            sumGrid[0][i] = grid[0][i] + sumGrid[0][i - 1];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                sumGrid[i][j] = Math.min(sumGrid[i - 1][j] + grid[i][j] , sumGrid[i][j  - 1] + grid[i][j]);
            }
        }

        return sumGrid[r - 1][c - 1];


    }
}
